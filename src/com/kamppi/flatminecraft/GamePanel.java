package com.kamppi.testgame;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.kamppi.testgame.graphics.Textures;
import com.kamppi.testgame.states.GameStateManager;
import com.kamppi.testgame.util.KeyHandler;
import com.kamppi.testgame.util.MouseHandler;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable {
	
	public static int width;
	public static int height;
	
	private static Image cursorImg;
	public static Cursor cursor;
	
	private Thread thread;
	private boolean running = false;
	
	private BufferedImage img;
	private Graphics2D g;
	
	private MouseHandler mouse;
	private KeyHandler key;
	
	private GameStateManager gsm;

	@SuppressWarnings("static-access")
	public GamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		setPreferredSize(new Dimension(width, height));
		setFocusable(true);
		requestFocus();
		
		cursorImg = Textures.ICONS.getSubimage(0, 0, 16, 16);
		cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(15, 15), "cross");
	}
	
	public void addNotify() {
		super.addNotify();
		
		if (thread == null) {
			thread = new Thread(this, "GameThread");
			thread.start();
		}
	}
	
	public void init() {
		running = true;
		
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		g = (Graphics2D) img.getGraphics();
		
		mouse = new MouseHandler(this);
		key = new KeyHandler(this);
		
		gsm = new GameStateManager();
	}
	
	public void run() {
		init();
		
		final double GAME_HERTZ = 60;
		final double TBU = 1000000000 / GAME_HERTZ; // Time Before Update
		
		final int MUBR = 1; // Most Updates Before Render
		
		double lastUpdateTime = System.nanoTime();
		double lastRenderTime;
		
		final double TARGET_FPS = 60;
		final double TTBR = 1000000000 / TARGET_FPS; // Total Time Before Render
		
		int frameCount = 0;
		int lastSecondTime = (int) (lastUpdateTime / 1000000000);
		int oldFrameCount = 0;
		
		while (running) {
			double nanoTime = System.nanoTime();
			int updateCount = 0;
			while (((nanoTime - lastUpdateTime) > TBU) && (updateCount < MUBR)) {
				update();
				input(mouse, key);
				lastUpdateTime += TBU;
				updateCount++;
			}
			
			if (nanoTime - lastUpdateTime > TBU) {
				lastUpdateTime = nanoTime - TBU;
			}
			
			render();
			draw();
			lastRenderTime = nanoTime;
			frameCount++;
			
			int thisSecond = (int) (lastUpdateTime / 1000000000);
			if (thisSecond > lastSecondTime) {
				if (frameCount != oldFrameCount) {
//					System.out.println("NEW FPS: " + frameCount);
					oldFrameCount = frameCount;
				}
				frameCount = 0;
				lastSecondTime = thisSecond;
			}
			
			while (nanoTime - lastRenderTime < TTBR && nanoTime - lastUpdateTime < TBU) {
				Thread.yield();
				
				try {
					Thread.sleep(1);
				} catch(Exception e) {
					System.out.println("Failed to yield thread");
				}
				nanoTime = System.nanoTime();
			}
		}
	}
	
	public void update() {
		gsm.update();
	}
	
	public void input(MouseHandler mouse, KeyHandler key) {
		gsm.input(mouse, key);
	}
	
	public void render() {
		gsm.render(g, mouse);
	}
	
	public void draw() {
		Graphics g2 = (Graphics) this.getGraphics();
		g2.drawImage(img, 0, 0, width, height, null);
		g2.dispose();
	}
}
