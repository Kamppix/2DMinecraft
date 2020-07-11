package com.kamppi.testgame.inventory;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kamppi.testgame.GamePanel;
import com.kamppi.testgame.Player;
import com.kamppi.testgame.graphics.Font;
import com.kamppi.testgame.items.ArmorType;
import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.util.KeyHandler;
import com.kamppi.testgame.util.MouseHandler;
import com.kamppi.testgame.util.Vector2f;

public class ContainerScreen {
	
	private final Player player;
	private Inventory inv;
	private final ContainerType type;

	private HashMap<Integer, ItemStack> ITEMS;
	private HashMap<Integer, ItemSlot> SLOTS;
	private List<ItemSlot> SLOT_LIST;
	
	private Vector2f pos;
	
	private int clickSlot;
	private int cursorSlot;
	private boolean hasCursorItem;
	private ItemStack cursorItem;
	
	public ContainerScreen(Player player, Inventory inv, ContainerType type) {
		this.player = player;
		this.inv = inv;
		this.type = type;
		
		pos = new Vector2f(GamePanel.width / 2 - getWidth(), GamePanel.height / 2 - getHeight());
		
		updateSlots();
	}
	
	private void updateSlots() {

		ITEMS = new HashMap<>();
		SLOTS = new HashMap<>();
		SLOT_LIST = new ArrayList<>();
		
		if (inv instanceof CraftingGrid) {
			for (ItemSlot slot : inv.getSlotList()) {
				addSlot(slot.getIndex(), slot);
				addItem(slot.getIndex(), inv.getItems().get(slot.getIndex()));
			}
			
			for (ItemSlot slot : player.getInv().getSlotList()) {
				addSlot(slot.getIndex(), slot);
				addItem(slot.getIndex(), player.getInv().getItems().get(slot.getIndex()));
			}
		} else {
			for (ItemSlot slot : inv.getSlotList()) {
				addSlot(slot.getIndex(), slot);
				addItem(slot.getIndex(), inv.getItems().get(slot.getIndex()));
			}
			
			for (int i = 0; i < 36; i++) {
				addSlot(i, player.getInv().getSlotList().get(i));
			}
			
			for (int i = 0; i < 36; i++) {
				addItem(i, player.getInv().getItems().get(i));
			}
		}
	}
	
	private void addSlot(int index, ItemSlot slot) {
		SLOT_LIST.add(slot);
		SLOTS.put(index, slot);
	}
	
	public void addItem(int index, ItemStack item) {
		ITEMS.put(index, item);
	}
	
	public void update() {
		pos.x = GamePanel.width / 2 - getWidth();
		pos.y = GamePanel.height / 2 - getHeight();
		
		updateSlots();
	}

	public void input(KeyHandler key, MouseHandler mouse) {
		Point cursor = new Point(mouse.getX(), mouse.getY());
		cursorSlot = -1;
		
		for (ItemSlot slot : SLOT_LIST) {
			if (new Rectangle((int) pos.x + slot.getX() - 2, (int) pos.y + slot.getY() - 2, 36, 36).contains(cursor)) {
				
				slot.setHighlighted(true);
				cursorSlot = slot.getIndex();
				
			} else slot.setHighlighted(false);
		}
		
		if (key.drop.clicked && cursorItem == null && cursorSlot != -1 && ITEMS.get(cursorSlot) != null) {
			if (key.sneak.down) setItemCount(cursorSlot, 0);
			else decreaseItemCount(cursorSlot);
		}
		
		if (mouse.pressed()) {
			clickSlot = cursorSlot;
			
			if (cursorSlot != -1 && !hasCursorItem) {
				cursorItem = ITEMS.get(cursorSlot);
				removeItem(cursorSlot);
			}
		}
		
		if (mouse.released() && hasCursorItem) {
			if (clickSlot == cursorSlot) {
				if (cursorSlot == -1) {
					dropCursor();
				} else {
					if (!(SLOTS.get(cursorSlot).getType() == ItemSlotType.ARMOR_HELMET && cursorItem.getType().getArmorType() != ArmorType.HEAD
							|| SLOTS.get(cursorSlot).getType() == ItemSlotType.ARMOR_CHESTPLATE && cursorItem.getType().getArmorType() != ArmorType.CHEST
							|| SLOTS.get(cursorSlot).getType() == ItemSlotType.ARMOR_LEGGINGS && cursorItem.getType().getArmorType() != ArmorType.LEGS
							|| SLOTS.get(cursorSlot).getType() == ItemSlotType.ARMOR_BOOTS && cursorItem.getType().getArmorType() != ArmorType.FEET)) {
						ItemStack temp = ITEMS.get(cursorSlot);
						putItem(cursorSlot, cursorItem);
						cursorItem = temp;
					}
				}
			}
		}
		
		if (mouse.getButton() == -1) {
			if (cursorItem == null) hasCursorItem = false;
			else hasCursorItem = true;
		}
	}

	public void render(Graphics2D g, Font font, MouseHandler mouse) {
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
		g.setColor(new Color(15, 15, 15));
		g.fillRect(0, 0, GamePanel.width, GamePanel.height);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		
		g.drawImage(type.getImage(), (int) pos.x, (int) pos.y, getWidth() * 2, getHeight() * 2, null);
		
		for (ItemSlot slot : SLOT_LIST) {
			
			if (ITEMS.get(slot.getIndex()) == null) {
				slot.render(g, font, (int) pos.x, (int) pos.y, true);
			} else {
				ITEMS.get(slot.getIndex()).render(g, font, new Vector2f(slot.getX() + pos.x, slot.getY() + pos.y));
				slot.render(g, font, (int) pos.x, (int) pos.y, false);
			}
		}
		
		if (cursorItem != null) cursorItem.render(g, font, new Vector2f(mouse.getX() - 16, mouse.getY() - 16));
	}
	
	private void removeItem(int slot) {
		if (slot > -7 && slot < 36) player.getInv().getItems().remove(slot);
		else inv.getItems().remove(slot);
	}
	
	private void putItem(int slot, ItemStack item) {
		System.out.println(slot);
		if (slot > -7 && slot < 36) player.getInv().getItems().put(slot, item);
		else inv.getItems().put(slot, item);
	}

	public void dropCursor() {
		if (cursorItem != null) cursorItem = null;
	}
	
	public void decreaseItemCount(int i) {
		ITEMS.get(i).decreaseCount();
		if (ITEMS.get(i).getCount() <= 0) ITEMS.remove(i);
	}
	
	public void setItemCount(int i, int count) {
		ITEMS.get(i).setCount(count);
		if (ITEMS.get(i).getCount() <= 0) ITEMS.remove(i);
	}
	
	private int getWidth() {
		return type.getGuiWidth();
	}
	
	private int getHeight() {
		return type.getGuiHeight();
	}
	
	public HashMap<Integer, ItemStack> getItems() {
		return ITEMS;
	}
	
	public HashMap<Integer, ItemSlot> getSlots() {
		return SLOTS;
	}
	
	public void setItems(HashMap<Integer, ItemStack> ITEMS) {
		this.ITEMS = ITEMS;
	}
}
