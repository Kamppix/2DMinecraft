package com.kamppi.testgame.items;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileItem extends Item {
	
	public TileItem(String id, String name, int maxCount) {
		super(id, name, maxCount);
	}

	protected void prepareTexture() {
			try {
//				File textureFile = new File("assets/minecraft/textures/tile/" + id + ".png");
				File textureFile = new File("res/textures/tile/" + id + ".png");
				textureImg = ImageIO.read(textureFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
}
