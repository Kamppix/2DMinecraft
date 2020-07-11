package com.kamppi.testgame.items;

import java.awt.Color;
import java.awt.Graphics2D;

import com.kamppi.testgame.graphics.Font;
import com.kamppi.testgame.graphics.Sprite;
import com.kamppi.testgame.inventory.ItemSlot;
import com.kamppi.testgame.util.Vector2f;

public class ItemStack {

	private Item type;
	private int count;
	private ItemSlot slot = null;

	public ItemStack(Item type, int count, ItemSlot slot) {
		this.type = type;
		this.count = count;
		this.slot = slot;
	}

	public ItemStack(Item type, int count) {
		this.type = type;
		this.count = count;
	}

	public ItemStack(Item type) {
		this.type = type;
		this.count = 1;
	}

	public void render(Graphics2D g, Font font, Vector2f pos) {
		g.drawImage(type.getTexture(), (int) pos.x, (int) pos.y, 32, 32, null);
		
		if (count > 1) {
			if (count > 9) {
				Sprite.drawString(g, font, Integer.toString(count), new Color(255, 255, 255), new Color(63, 63, 63), new Vector2f(pos.x + 10, pos.y + 18), 16, 16, 12, 0);
			} else {
				Sprite.drawString(g, font, Integer.toString(count), new Color(255, 255, 255), new Color(63, 63, 63), new Vector2f(pos.x + 22, pos.y + 18), 16, 16, 0, 0);
			}
		}
	}

	public Item getType() {
		return type;
	}

	public void setType(Item type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public void decreaseCount() {
		count--;
	}

	public ItemSlot getSlot() {
		return slot;
	}

	public ItemStack setSlot(ItemSlot slot) {
		this.slot = slot;
		return this;
	}
}
