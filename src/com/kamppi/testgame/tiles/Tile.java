package com.kamppi.testgame.tiles;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.kamppi.testgame.Player;
import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.world.Chunk;
import com.kamppi.testgame.world.World;

public class Tile {
	
	protected final String id;
	protected final String name;
	protected final CollisionType collision;
	protected final int harvestLevel;
	protected final float hardness;
	protected final Material material;
	protected final ItemStack drop;
	
	protected BufferedImage texture;
	protected Image textureImg;

	public Tile(String id, String name, CollisionType collision, int harvestLevel, float hardness, Material material, ItemStack drop) {
		this.id = id;
		this.name = name;
		this.collision = collision;
		this.harvestLevel = harvestLevel;
		this.hardness = hardness;
		this.material = material;
		this.drop = drop;
		
		prepareTexture();
	}
	
	private void prepareTexture() {
		try {
//			File textureFile = new File("assets/minecraft/textures/block/" + id + ".png");
			File textureFile = new File("res/textures/tile/" + id + ".png");
			texture = ImageIO.read(textureFile);
			textureImg = texture.getScaledInstance(32, 32, Image.SCALE_FAST);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void drop(World world, int harvestLevel) {
		if (this.harvestLevel <= harvestLevel && drop != null) {
			world.player.getInv().addItem(new ItemStack(drop.getType(), drop.getCount()));
		}
	}

	public void update(Chunk chunk, int x, int y) {
		
	}

	public void render(Graphics2D g, Player player, World world, Chunk c, int x, int y) {
		int worldX = c.getX() * 256;
		int renderX = (int) (player.getRenderOffsetX() + (worldX + x - player.getX()) * 32);
		int renderY = (int) (player.getRenderOffsetY() - (y - player.getY()) * 32 - 32);
		
		if (x == 0 && world.isChunkLoaded(c.getX() - 1)
				&& world.getTile(worldX + x - 1, y - 1) != null && world.getTile(worldX + x - 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& world.getTile(worldX + x - 1, y) != null && world.getTile(worldX + x - 1, y).getCollision() == CollisionType.FULL_TILE
				&& world.getTile(worldX + x - 1, y + 1) != null && world.getTile(worldX + x - 1, y + 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y - 1) != null && c.getTile(x, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y + 1) != null && c.getTile(x, y + 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y - 1) != null && c.getTile(x + 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y) != null && c.getTile(x + 1, y).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y + 1) != null && c.getTile(x + 1, y + 1).getCollision() == CollisionType.FULL_TILE) {
			
			drawDarkTile(g, player, c, renderX, renderY);
		} else if (x == 255 && world.isChunkLoaded(c.getX() + 1)
				&& c.getTile(x - 1, y - 1) != null && c.getTile(x - 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x - 1, y) != null && c.getTile(x - 1, y).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x - 1, y + 1) != null && c.getTile(x - 1, y + 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y - 1) != null && c.getTile(x, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y + 1) != null && c.getTile(x, y + 1).getCollision() == CollisionType.FULL_TILE
				&& world.getTile(worldX + x + 1, y - 1) != null && world.getTile(worldX + x + 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& world.getTile(worldX + x + 1, y) != null && world.getTile(worldX + x + 1, y).getCollision() == CollisionType.FULL_TILE
				&& world.getTile(worldX + x + 1, y + 1) != null && world.getTile(worldX + x + 1, y + 1).getCollision() == CollisionType.FULL_TILE) {
			
			drawDarkTile(g, player, c, renderX, renderY);
		} else if (x > 0 && x < 255
				&& c.getTile(x - 1, y - 1) != null && c.getTile(x - 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x - 1, y) != null && c.getTile(x - 1, y).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x - 1, y + 1) != null && c.getTile(x - 1, y + 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y - 1) != null && c.getTile(x, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x, y + 1) != null && c.getTile(x, y + 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y - 1) != null && c.getTile(x + 1, y - 1).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y) != null && c.getTile(x + 1, y).getCollision() == CollisionType.FULL_TILE
				&& c.getTile(x + 1, y + 1) != null && c.getTile(x + 1, y + 1).getCollision() == CollisionType.FULL_TILE) {
			drawDarkTile(g, player, c, renderX, renderY);
		} else {
			drawTexture(g, player, c, renderX, renderY);
		}
	}
	
	private void drawDarkTile(Graphics2D g, Player player, Chunk c, int x, int y) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
	}
	
	private void drawTexture(Graphics2D g, Player player, Chunk c, int x, int y) {
		g.drawImage(textureImg, x, y, null);
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public CollisionType getCollision() {
		return collision;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	public float getHardness() {
		return hardness;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public ItemStack getDrop() {
		return drop;
	}

	public boolean isReplaceable() {
		return false;
	}
}
