package com.github.kamppix.twodminecwaft.inventory;

import java.awt.Image;

import com.github.kamppix.twodminecwaft.graphics.Textures;

public class ContainerType {

	public static final ContainerType INVENTORY = new ContainerType(Textures.PLAYER_INVENTORY_GUI);
	public static final ContainerType CRAFTING_TABLE = new ContainerType(Textures.CRAFTING_TABLE_GUI);
	
	private final Image guiImage;
	
	public ContainerType(Image guiImage) {
		this.guiImage = guiImage;
	}
	
	public Image getImage() {
		return guiImage;
	}
	
//	Sprite.drawString(g, font, "Crafting", new Color(63, 63, 63), new Vector2f(GamePanel.width / 2 - getWidth() + 194, GamePanel.height / 2 - getHeight() + 12), 16, 16, 12, 0);

	public int getGuiWidth() {
		return guiImage.getWidth(null);
	}

	public int getGuiHeight() {
		return guiImage.getHeight(null);
	}
}
