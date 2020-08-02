package com.github.kamppix.twodminecwaft.inventory;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;

import com.github.kamppix.twodminecwaft.graphics.Font;
import com.github.kamppix.twodminecwaft.util.Vector2f;

public class ItemSlot {

	private final ItemSlotType type;
	private final int index;
	
	private Vector2f pos;
	private boolean highlighted;
	
	public ItemSlot(ItemSlotType type, int index, Vector2f pos) {
		this.type = type;
		this.index = index;
		this.pos = pos;
	}

	public void update(int x, int y) {
		pos.x += x;
		pos.y += y;
	}
	
	public void render(Graphics2D g, Font font, int x, int y, boolean drawIcon) {
		if (type.getImage() != null && drawIcon) g.drawImage(type.getImage(), (int) pos.x + x, (int) pos.y + y, null);
		
		if (highlighted) {
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
			g.setColor(new Color(255, 255, 255));
			g.fillRect((int) pos.x + x, (int) pos.y + y, 32, 32);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
		}
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public ItemSlotType getType() {
		return type;
	}

	public int getIndex() {
		return index;
	}

	public int getX() {
		return (int) pos.x;
	}

	public int getY() {
		return (int) pos.y;
	}
}
