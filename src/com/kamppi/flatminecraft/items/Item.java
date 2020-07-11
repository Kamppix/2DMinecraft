package com.kamppi.testgame.items;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Item {
	
	protected final String id;
	protected final String name;
	protected final int maxCount;

	protected Image textureImg;

	public Item(String id, String name, int maxCount) {
		this.id = id;
		this.name = name;
		this.maxCount = maxCount;
		
		prepareTexture();
	}
	
	protected void prepareTexture() {
		try {
//			File textureFile = new File("assets/minecraft/textures/item/" + id + ".png");
			File textureFile = new File("res/textures/item/" + id + ".png");
			textureImg = ImageIO.read(textureFile);
		} catch (IOException e) {
			System.out.println("Error loading texture file: " + id);
		}
	}
	
	public Image getTexture() {
		return textureImg;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public int getMaxCount() {
		return maxCount;
	}
	
	public ToolMaterial getMaterial() {
		return null;
	}
	
	public float getAttackDamage() {
		return 0.0f;
	}
	
	public float getAttackSpeed() {
		return 4.0f;
	}

	public ToolType getToolType() {
		return null;
	}

	public ArmorType getArmorType() {
		return null;
	}
}
