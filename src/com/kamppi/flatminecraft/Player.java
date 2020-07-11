package com.kamppi.testgame;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kamppi.testgame.commands.ChatInputBox;
import com.kamppi.testgame.graphics.Font;
import com.kamppi.testgame.graphics.Sprite;
import com.kamppi.testgame.graphics.Textures;
import com.kamppi.testgame.inventory.Inventory;
import com.kamppi.testgame.inventory.PlayerInventory;
import com.kamppi.testgame.inventory.ContainerScreen;
import com.kamppi.testgame.inventory.ContainerType;
import com.kamppi.testgame.inventory.CraftingGrid;
import com.kamppi.testgame.items.Item;
import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.items.ToolItem;
import com.kamppi.testgame.tiles.Tiles;
import com.kamppi.testgame.util.KeyHandler;
import com.kamppi.testgame.util.MouseHandler;
import com.kamppi.testgame.util.Timer;
import com.kamppi.testgame.util.Vector2d;
import com.kamppi.testgame.util.Vector2f;
import com.kamppi.testgame.world.World;

public class Player {
	
	World world;
	
	private String name;
	private PlayerInventory inv;
	private ContainerScreen guiScreen;
	private int selectedItemSlot;
	
	private float maxHealth, health;
	private double x, y, vX, vY;
	private boolean dead, inWater, onGround, sprinting, sneaking;
	private int facing, foodLevel;
	
	private Vector2d eyePos = new Vector2d();
	private Vector2d mousePos = new Vector2d();
	private Vector2d pointPos = new Vector2d();
	
	private int miningX;
	private int miningY;
	private float miningProgress;
	
	private double width;
	private double height;
	private final int renderOffsetX = (int) (GamePanel.width / 2 - width * 32 / 2);
	private final int renderOffsetY = (int) (GamePanel.height / 2 + height * 32 / 2);

	private List<Timer> timers = new ArrayList<>();
	private Timer placeTimer = new Timer();
	private Timer damageImmunityTimer = new Timer();
	private Timer healthFlashTimer = new Timer();
	private boolean healthFlash;
	private boolean healthFlashHeal;
	private int healthDamage;
	
	public Player(World world) {
		this.world = world;
		
		name = "Player";
		
		timers.add(placeTimer);
		timers.add(damageImmunityTimer);
		timers.add(healthFlashTimer);
		
		createEntity();
	}

	private void createEntity() {
		for (Timer t : timers) {
			t.reset();
		}
		
		inv = new PlayerInventory();
		selectedItemSlot = 0;
		maxHealth = 20.0f;
		health = maxHealth;
		foodLevel = 20;
		x = -0.3d;
		y = 64.0d;
		vX = 0.0d;
		vY = 0.0d;
		dead = false;
		onGround = false;
		sprinting = false;
		sneaking = false;
		facing = 1;
		width = 0.6f;
		height = 1.8f;
	}
	
	private void collideAndMove() {
		double nextX = x + vX;
		double nextY = y + vY;
		
		Vector2d collisionTile = new Vector2d();
		
		if (onGround && sneaking && nextY == y) {
			if (vX > 0) collisionTile = world.collisionCheck(nextX, y - 0.5d);
			if (vX < 0) collisionTile = world.collisionCheck(nextX + width, y - 0.5d);
			if (collisionTile == null) {
				return;
			}
		}
		
		collisionTile = world.collisionCheck(nextX, y, width, height);
		if (collisionTile != null) {
			if (collisionTile.x + 0.5d <= x + width / 2) {
				x = collisionTile.x + 1.0d;
			} else {
				x = collisionTile.x - width - 0.01F;
			}
			vX = 0;
		} else {
			x = nextX;
		}
		
		collisionTile = world.collisionCheck(x, nextY, width, height);
		if (collisionTile != null) {
			if (collisionTile.y <= y) {
				y = collisionTile.y + 1.0d;
				onGround = true;
				if (vY < -0.25d) {
					damage((float) Math.ceil((-vY - 0.25d) * 49.23418d), DamageType.FALL, true);
				}
			} else {
				y = collisionTile.y - height;
			}
			vY = 0;
		} else {
			y = nextY;
			onGround = false;
		}
	}
	
	private void decreaseVelocity() {
		if (onGround) {
			vX *= 0.7d;
		} else {
			vX *= 0.97d;
			vY -= 0.008711111280d;
		}
	}
	
	private void addVX() {
		double mult = facing;
		if (!onGround) mult /= 5d;
		double vXC = 0.0d;
		
		if (sprinting) {
			vXC = 0.05d;
		} else if (sneaking) {
			vXC = 0.02d;
		} else {
			vXC = 0.04d;
		}
		
		vXC *= mult;
		vX += vXC;
	}
	
	public void update() {
		/// TIMERS ///
		for (Timer t : timers) {
			t.update();
		}
		
		/// VOID DAMAGE ///
		if (y < -64) {
			damage(4.0f, DamageType.GENERIC, false);
		}
		
		/// HEALTH FLASH ///
		healthFlashUpdate();
		
		/// STUFF ///
		if (dead == false) {
			collideAndMove();
			decreaseVelocity();
		} else {
			createEntity();
		}
		
		/// HEIGHT ADJUSTMENT ///
		if (!sneaking && world.collisionCheck(x, y, width, 1.8d) == null) {
			height = 1.8d;
		} else {
			height = 1.5d;
		}
		
		/// BOOLEAN RESET ///
		sneaking = false;
		sprinting = false;
		
		/// INVENTORY ///
		if (guiScreen != null) guiScreen.update();
	}

	public void input(MouseHandler mouse, KeyHandler key) {
		/// INVENTORY ///
		if (guiScreen != null) {
			guiScreen.input(key, mouse);
			
			if (key.inventory.clicked || key.escape.clicked) {
				guiScreen = null;
			}
		} else {
			
			/// KEYBOARD ///
			if (key.sneak.down) {
				sneaking = true;
			}
			if (key.sprint.down && !sneaking) {
				sprinting = true;
			}
			if (key.up.down) {
				
			}
			if (key.down.down) {
				
			}
			if (key.left.down) {
				facing = -1;
				addVX();
			}
			if (key.right.down) {
				facing = 1;
				addVX();
			}
			if (key.jump.down) {
				if (onGround) 
					vY = 0.14321833F;
			}
			if (key.enter.clicked) {
				new ChatInputBox(world, this);
			}
			if (key.drop.clicked && getInv().getItems().get(selectedItemSlot) != null) {
				if (key.sneak.down) {
					getInv().setItemCount(selectedItemSlot, 0);
				} else {
					getInv().decreaseItemCount(selectedItemSlot);
				}
			}
			if (key.inventory.clicked) {
				guiScreen = new ContainerScreen(this, new CraftingGrid(), ContainerType.INVENTORY);
			}
			if (key.escape.clicked) {
				heal(1.0f);
			}
			
			/// MOUSE ///
			eyePos = new Vector2d(x + width / 2, y + height - 0.18F);
			mousePos = new Vector2d(x + (mouse.getX() - GamePanel.width / 2F) / 32F, y - (mouse.getY() - GamePanel.height / 2F) / 32F);
			pointPos = rayCast(eyePos.x, eyePos.y, mousePos.x, mousePos.y, 4.5F);
			
			if (mouse.getButton() == 1) {
				mine((int) Math.floor(pointPos.x), (int) Math.floor(pointPos.y));
			} else {
				miningProgress = 0;
			}
			if (mouse.getButton() == 3) {
				if (placeTimer.time == 0) {
					place((int) Math.floor(pointPos.x), (int) Math.floor(pointPos.y), (int) Math.floor(pointPos.x - (mousePos.x - eyePos.x) / 300f), (int) Math.floor(pointPos.y - (mousePos.y - eyePos.y) / 300f));
				}
			} else {
				placeTimer.reset();
			}
			if (mouse.getScroll() != 0) {
				selectedItemSlot += mouse.getScroll();
				if (selectedItemSlot < 0) selectedItemSlot = 9 + selectedItemSlot;
				if (selectedItemSlot > 8) selectedItemSlot = selectedItemSlot - 9;
				
				miningProgress = 0;
			}
		}
	}
	
	public void render(Graphics2D g, Font font, MouseHandler mouse) {
		List<Image> draw = new ArrayList<>();
		Vector2f drawPos;
		
		/// MINING TILE ///
		if (miningProgress > 0.1f) {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
			g.drawImage(Textures.BREAK_STAGES.get((int) (miningProgress / 0.1f - 1)), (int) (renderOffsetX + (miningX - x) * 32), (int) (renderOffsetY - (miningY - y) * 32 - 32), 32, 32, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		}
		
		/// AIMING TILE ///
		if (world.collisionCheck(Math.floor(pointPos.x), Math.floor(pointPos.y)) != null) {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g.setColor(Color.BLACK);
			g.drawRect((int) (renderOffsetX + (Math.floor(pointPos.x) - x) * 32), (int) (renderOffsetY - (Math.floor(pointPos.y) - y) * 32 - 32), 32, 32);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		}
		
		/// PLAYER + AIM LINE ///
		if (dead == false) {
			g.setColor(Color.ORANGE);
			g.fillRect(renderOffsetX, renderOffsetY - (int) (height * 32), (int) (width * 32), (int) (height * 32));
			g.setColor(Color.WHITE);
			g.drawLine((int) (renderOffsetX + (width / 2) * 32), (int) (renderOffsetY - (height - 0.18F) * 32), (int) (renderOffsetX + (pointPos.x - x) * 32), (int) (renderOffsetY - (pointPos.y - y) * 32));
		}

		/// HOTBAR ///
		g.drawImage(Textures.HOTBAR, GamePanel.width / 2 - 182, GamePanel.height - 44, 364, 44, null);
		g.drawImage(Textures.HOTBAR_SELECTED, GamePanel.width / 2 - 184 + selectedItemSlot * 40, GamePanel.height - 46, 48, 48, null);
		
		for (int i = 0; i < 9; i++) {
			if (getInv().getItems().get(i) != null) {
				getInv().getItems().get(i).render(g, font, new Vector2f(GamePanel.width / 2 - 176 + i * 40, GamePanel.height - 38));
			}
		}
		
		/// XP BAR ///
		g.drawImage(Textures.XP_BAR, GamePanel.width / 2 - 182, GamePanel.height - 58, 364, 10, null);
		
		/// HEALTH ///
		draw.clear();
		drawPos = new Vector2f(GamePanel.width / 2 - 182, GamePanel.height - 78);
		for (int i = 0; i < maxHealth; i++) {
			if (healthFlash) {
				if (i % 2 == 0) draw.add(Textures.HEART_SLOT_FLASH);
			} else {
				if (i % 2 == 0) draw.add(Textures.HEART_SLOT);
			}
		}
		Sprite.drawArray(g, draw, drawPos, 18, 18, 16, 0);
		
		if (healthFlash) {
			draw.clear();
			for (int i = 0; i < Math.ceil(health + healthDamage); i++) {
				if (i % 2 == 1) draw.add(Textures.HEART_FLASH);
				if (i % 2 == 0 && i + 1 == health + healthDamage) draw.add(Textures.HEART_FLASH_HALF);
			}
			Sprite.drawArray(g, draw, drawPos, 18, 18, 16, 0);
		}
		
		draw.clear();
		for (int i = 0; i < Math.ceil(health); i++) {
			if (i % 2 == 1) draw.add(Textures.HEART);
			if (i % 2 == 0 && i + 1 == health) draw.add(Textures.HEART_HALF);
		}
		Sprite.drawArray(g, draw, drawPos, 18, 18, 16, 0);
		
		/// HUNGER ///
		drawPos = new Vector2f(GamePanel.width / 2 + 20, GamePanel.height - 78);
		
		draw.clear();
		for (int i = 0; i < 20; i++) {
			if (i % 2 == 0) draw.add(Textures.FOOD_SLOT);
		}
		Sprite.drawArray(g, draw, drawPos, 18, 18, 16, 0);
		
		draw.clear();
		for (int i = 0; i < Math.ceil(foodLevel); i++) {
			if (i % 2 == 1) draw.add(Textures.FOOD);
			if (i % 2 == 0 && i + 1 == foodLevel) draw.add(Textures.FOOD_HALF);
		}
		Sprite.drawArray(g, draw, drawPos, 18, 18, 16, 0);
		
		/// INVENTORY ///
		if (guiScreen != null) guiScreen.render(g, font, mouse);
	}
	
	private Vector2d rayCast(double x1, double y1, double x2, double y2, double maxLength) {
		double xVector = x2 - x1;
		double yVector = y2 - y1;
		
		Vector2d checkPos = new Vector2d();
		Vector2d checkDist = new Vector2d();

		for (int i = 0; i < 300; i++) {
			checkPos.x = eyePos.x + xVector * (i + 1f) / 300f;
			checkPos.y = eyePos.y + yVector * (i + 1f) / 300f;
			
			checkDist.x = checkPos.x - x1;
			checkDist.y = checkPos.y - y1;
			
			if (Math.sqrt(checkDist.x * checkDist.x + checkDist.y * checkDist.y) > maxLength || world.collisionCheck(checkPos.x, checkPos.y) != null) {
				return checkPos;
			}
		}
		return checkPos;
	}
	
	private void place(int faceX, int faceY, int x, int y) {
		if (world.getTile(faceX, faceY) == null) return;
		if (getSelectedItem() == null) return;
		if (world.placeTile(x, y, Tiles.getById(getSelectedItem().getType().getId()))) {
			getInv().decreaseItemCount(selectedItemSlot);
			placeTimer.setTime(0.2f, 0);
		}
	}
	
	private void mine(int x, int y) {
		if (world.getTile(x, y) == null) return;
		if (x != miningX || y != miningY || miningProgress < 0) miningProgress = 0;
		miningX = x;
		miningY = y;
		
		ItemStack item = null;
		Item tool = null;
		if (getSelectedItem() != null) {
			item = getSelectedItem();
			if (item.getType() instanceof ToolItem) tool = item.getType();
		}

		float miningTime = 0.0f;
		float speedMultiplier = 1.0f;
		
		if (world.getTile(x, y).getHarvestLevel() == 0) {
			miningTime = world.getTile(x, y).getHardness() * 1.5f;
		} else {
			miningTime = world.getTile(x, y).getHardness() * 5.0f;
		}
			
		if (item != null && tool != null) {
			if (tool.getMaterial().getHarvestLevel() >= world.getTile(x, y).getHarvestLevel() - 1) {
				miningTime = world.getTile(x, y).getHardness() * 1.5f;
			}
			
			if (tool.getToolType().getEffectiveOn().contains(world.getTile(x, y).getMaterial())) {
				speedMultiplier = tool.getMaterial().getMiningSpeed();
			}
		}
		
		miningTime /= speedMultiplier;
		
		if (inWater) {
			miningTime *= 5;
		}
		
		if (!onGround) {
			miningTime *= 5;
		}
		
		miningTime *= 60;
		miningProgress += 1.0f / miningTime;
		
		if (miningProgress >= 1.0f) {
			miningProgress = 0;
			if (item != null && tool != null && tool.getMaterial() != null) {
				world.destroyTile(x, y, tool.getMaterial().getHarvestLevel());
			} else {
				world.destroyTile(x, y, 0);
			}	
		}
	}
	
	public void heal(float hp) {
		healthDamage = 0;
		healthFlash = false;
		healthFlashHeal = true;
		healthFlashTimer.setTime(3, 1);
		
		health += hp;
		if (health > maxHealth) {
			health = maxHealth;
		}
	}
	
	public void damage(float hp, DamageType type, boolean ignoreImmunity) {
		if (!ignoreImmunity && damageImmunityTimer.time != 0) return; 
		damageImmunityTimer.setTime(30, 0);
		
		healthDamage = (int) Math.floor(hp);
		healthFlash = false;
		healthFlashHeal = false;
		healthFlashTimer.setTime(9, 5);
		
		health -= hp;
		if (health < 0) {
			health = 0;
		}
		if (health == 0) {
			dead = true;
		}
	}
	
	private void healthFlashUpdate() {
		if (healthFlashTimer.isDoneTime()) {
			if (healthFlashHeal) System.out.println();
			
			if (healthFlashHeal && healthFlashTimer.isDone()) {
				healthFlashTimer.setTime(9, 1);
				healthFlashHeal = false;
			}
			
			if (healthFlash) {
				healthFlash = false;
			} else {
				healthFlash = true;
			}
		}
	}

	public Inventory getInv() {
		return inv;
	}
	
	public HashMap<Integer, ItemStack> getItems() {
		return getInv().getItems();
	}

	public ItemStack getSelectedItem() {
		return getInv().getItems().get(selectedItemSlot);
	}
	
	public float getMaxHealth() {
		return maxHealth;
	}

	public float getHealth() {
		return health;
	}
	
	public boolean isDead() {
		return dead;
	}
	
	public void setDead() {
		dead = true;
	}

	public boolean isOnGround() {
		return onGround;
	}
	
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public double getVX() {
		return vX;
	}
	
	public double getVY() {
		return vY;
	}
	
	public void setVX(float vX) {
		this.vX = vX;
	}
	
	public void setVY(float vY) {
		this.vY = vY;
	}
	
	public float getRenderOffsetX() {
		return renderOffsetX;
	}
	
	public float getRenderOffsetY() {
		return renderOffsetY;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return width;
	}

	public String getName() {
		return name;
	}
}
