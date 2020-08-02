package com.github.kamppix.twodminecwaft.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import com.github.kamppix.twodminecwaft.GamePanel;

public class KeyHandler implements KeyListener {

	public static List<Key> KEYS = new ArrayList<>();
	
	public class Key {
		public int presses, absorbs;
		public boolean down, clicked;
		
		public Key() {
			KEYS.add(this);
		}
		
		public void toggle(boolean pressed) {
			if (pressed != down) {
				down = pressed;
			}
			if (pressed) {
				presses++;
			}
		}
		
		public void tick() {
			if (absorbs < presses) {
				absorbs++;
				clicked = true;
			} else {
				clicked = false;
			}
		}
	}
	
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();
	public Key sprint = new Key();
	public Key jump = new Key();
	public Key sneak = new Key();
	public Key drop = new Key();
	public Key inventory = new Key();
	public Key enter = new Key();
	public Key escape = new Key();
	public Key layerSwap = new Key();

	public void toggle(KeyEvent e, boolean pressed) {
		if (e.getKeyCode() == KeyEvent.VK_W) up.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_A) left.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_SHIFT) sprint.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_SPACE) jump.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_CONTROL) sneak.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_Q) drop.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_E) inventory.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_ENTER) enter.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) escape.toggle(pressed);
		if (e.getKeyCode() == KeyEvent.VK_ALT) layerSwap.toggle(pressed);
	}
	
	public KeyHandler(GamePanel game) {
		game.addKeyListener(this);
	}
	
	public void releaseAll() {
		for (Key k : KEYS) {
			k.down = false;
		}
	}
	
	public void tick() {
		for (Key k : KEYS) {
			k.tick();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggle(e, true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggle(e, false);
	}

}
