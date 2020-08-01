package com.github.kamppix.twodminecraft.items;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.kamppix.twodminecraft.Game;

public class Item {
	
	protected final String id;
	protected final String name;
	protected final int maxCount;
	protected final String textureName;

	protected Image textureImg;
	
	public Item(String id, String name, int maxCount) {
		this.id = id;
		this.name = name;
		this.maxCount = maxCount;
		this.textureName = null;
		
		prepareTexture();
	}
	
	public Item(String id, String name, int maxCount, String textureName) {
		this.id = id;
		this.name = name;
		this.maxCount = maxCount;
		this.textureName = textureName;
		
		prepareTexture();
	}
	
	protected void prepareTexture() {
		try {
			if (textureName == null) textureImg = ImageIO.read(Game.class.getResource("/textures/item/" + id + ".png"));
			else textureImg = ImageIO.read(Game.class.getResource("/textures/item/" + textureName + ".png"));
		} catch (IOException e) {
			System.out.println("ERROR: Could not load item texture '" + id + "'");
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
