package com.github.kamppix.twodminecraft.items;

import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.kamppix.twodminecraft.Game;

public class TileItem extends Item {

	public TileItem(String id, String name, int maxCount) {
		super(id, name, maxCount);
	}
	
	public TileItem(String id, String name, int maxCount, String textureName) {
		super(id, name, maxCount, textureName);
	}

	protected void prepareTexture() {
			try {
				if (textureName == null) textureImg = ImageIO.read(Game.class.getResource("/textures/block/" + id + ".png"));
				else textureImg = ImageIO.read(Game.class.getResource("/textures/block/" + textureName + ".png"));
			} catch (IOException e) {
				System.out.println("ERROR: Could not load item texture '" + id + "'");
			}
	 }
}
