package com.kamppi.testgame.graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Font {

	private BufferedImage lettersImg = null;
	private BufferedImage[][] letterArray;
	private final int tileSize = 8;
	public int w = tileSize;
	public int h = tileSize;
	private int wLetter;
	private int hLetter;
	
	public Font(String file) {
		lettersImg = loadFont(file);
		wLetter = lettersImg.getWidth() / w;
		hLetter = lettersImg.getHeight() / h;
		loadLetterArray();
	}
	
	public Font(String file, int w, int h) {
		this.w = w;
		this.h = h;
		
		lettersImg = loadFont(file);
		wLetter = lettersImg.getWidth() / w;
		hLetter = lettersImg.getHeight() / h;
		loadLetterArray();
	}
	
	public void setSize(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	
	public void setWidth(int i) {
		w = i;
		wLetter = lettersImg.getWidth() / w;
	}
	
	public void setHeight(int i) {
		h = i;
		hLetter = lettersImg.getHeight() / h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public int getHeight() {
		return h;
	}
	
	private BufferedImage loadFont(String file) {
		BufferedImage fontImg = null;
		try {
			fontImg = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fontImg;
	}
	
	public void loadLetterArray() {
		letterArray = new BufferedImage[wLetter][hLetter];
		
		for (int x = 0; x < wLetter; x++) {
			for (int y = 0; y < hLetter; y++) {
				letterArray[x][y] = getCharImg(x, y);
			}
		}
	}
	
	public BufferedImage getLettersImg() {
		return lettersImg;
	}
	
	public BufferedImage getCharImg(int x, int y) {
		return lettersImg.getSubimage(x * w, y * h, w, h);
	}
	
	public BufferedImage getFontChar(char c) {
		int value = c;
		int x = value % wLetter;
		int y = value / wLetter;
//		System.out.println(x + ", " + y);
		return getCharImg(x, y);
	}
}
