package com.kamppi.testgame.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;

import com.kamppi.testgame.util.Vector2f;

public class Sprite {

	private BufferedImage SPRITESHEET = null;
	private BufferedImage[][] spriteArray;
	private final int TILE_SIZE = 32;
	public int w;
	public int h;
	private int wSprite;
	private int hSprite;
	
	public Sprite(String file) {
		w = TILE_SIZE;
		h = TILE_SIZE;
		
		System.out.println("Loading: " + file + "...");
		SPRITESHEET = loadSprite(file);

		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getHeight() / h;
		loadSpriteArray();
	}
	
	public Sprite(String file, int w, int h) {
		this.w = w;
		this.h = h;
		
		System.out.println("Loading: " + file + "...");
		SPRITESHEET = loadSprite(file);
		
		wSprite = SPRITESHEET.getWidth() / w;
		hSprite = SPRITESHEET.getHeight() / h;
		loadSpriteArray();
	}
	
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void setWidth(int i) {
		w = i;
		wSprite = SPRITESHEET.getWidth() / w;
	}
	
	public void setHeight(int i) {
		h = i;
		hSprite = SPRITESHEET.getHeight() / h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	private BufferedImage loadSprite(String file) {
		BufferedImage sprite = null;
		try {
			sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		} catch(Exception e) {
			System.out.println("ERROR: Could not load file: " + file);
		}
		
		return sprite;
	}
	
	public void loadSpriteArray() {
		spriteArray = new BufferedImage[wSprite][hSprite];
		
		for (int x = 0; x< wSprite; x++) {
			for (int y = 0; y< hSprite; y++) {
				spriteArray[x][y] = getSprite(x, y);
			}
		}
	}
	
	public BufferedImage getSpriteSheet() {
		return SPRITESHEET;
	}
	
	public BufferedImage getSprite(int x, int y) {
		return SPRITESHEET.getSubimage(x * w, y * h, w, h);
	}
	
	public BufferedImage[] getSpriteArray(int i) {
		return spriteArray[i];
	}
	
	public BufferedImage[][] getSpriteArray() {
		return spriteArray;
	}
	
	public static void drawArray(Graphics2D g, List<Image> img, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		
		for (Image i : img) {
			if (i != null) {
				g.drawImage(i, (int) x, (int) y, width, height, null);
			}
			
			x += xOffset;
			y += yOffset;
		}
	}
	
	public static void drawString(Graphics2D g, Font f, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != 32) {
				g.drawImage(f.getFontChar(word.charAt(i)).getScaledInstance(16, 16, Image.SCALE_FAST), (int) x, (int) y, width, height, null);
			}
			
			x += xOffset;
			y += yOffset;
		}
	}
	
	public static void drawString(Graphics2D g, Font f, String word, Color stringColor, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		float x = pos.x;
		float y = pos.y;
		
		Color color = stringColor;
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) != 32) {
				BufferedImage charImage = f.getFontChar(word.charAt(i));
				for (int xx = 0; xx < charImage.getWidth(); xx++) {
					for (int yy = 0; yy < charImage.getWidth(); yy++) {
						if ((charImage.getRGB(xx, yy) >> 24) != 0x00) charImage.setRGB(xx, yy, color.getRGB());
					}
				}
				g.drawImage(charImage.getScaledInstance(16, 16, Image.SCALE_FAST), (int) x, (int) y, width, height, null);
			}
			
			x += xOffset;
			y += yOffset;
		}
	}
	
	public static void drawString(Graphics2D g, Font f, String word, Color stringColor, Color shadowColor, Vector2f pos, int width, int height, int xOffset, int yOffset) {
		for (int i = 0; i < 2; i++) {
			float x = pos.x;
			float y = pos.y;
			
			Color color;
			if (i == 0) color = shadowColor;
			else color = stringColor;
			
			for (int j = 0; j < word.length(); j++) {
				if (word.charAt(j) != 32) {
					BufferedImage charImage = f.getFontChar(word.charAt(j));
					for (int xx = 0; xx < charImage.getWidth(); xx++) {
						for (int yy = 0; yy < charImage.getWidth(); yy++) {
							if ((charImage.getRGB(xx, yy) >> 24) != 0x00) charImage.setRGB(xx, yy, color.getRGB());
						}
					}
					
					if (i == 0) g.drawImage(charImage.getScaledInstance(16, 16, Image.SCALE_FAST), (int) x + 2, (int) y + 2, width, height, null);
					else g.drawImage(charImage.getScaledInstance(16, 16, Image.SCALE_FAST), (int) x, (int) y, width, height, null);
				}
				
				x += xOffset;
				y += yOffset;
			}
		}
	}
}
