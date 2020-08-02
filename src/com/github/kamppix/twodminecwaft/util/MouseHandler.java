 package com.github.kamppix.twodminecwaft.util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.event.MouseInputAdapter;

import com.github.kamppix.twodminecwaft.GamePanel;

public class MouseHandler extends MouseInputAdapter {

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	private static int scroll = 0;
	private static boolean pressed = false;
	private static boolean released = false;
	
	public MouseHandler(GamePanel game) {
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
		game.addMouseWheelListener(this);
	}
	
	public int getX() {
		return mouseX;
	}
	
	public int getY() {
		return mouseY;
	}
	
	public int getButton() {
		return mouseB;
	}
	
	public int getScroll() {
		return scroll;
	}
	
	public void tick() {
		scroll = 0;
		pressed = false;
		released = false;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		scroll += e.getWheelRotation();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
		released = true;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	public boolean pressed() {
		return pressed;
	}

	public boolean released() {
		return released;
	}
}
