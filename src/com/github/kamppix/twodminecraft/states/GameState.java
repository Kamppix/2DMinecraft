package com.github.kamppix.twodminecraft.states;

import java.awt.Graphics2D;

import com.github.kamppix.twodminecraft.graphics.Font;
import com.github.kamppix.twodminecraft.util.KeyHandler;
import com.github.kamppix.twodminecraft.util.MouseHandler;

public abstract class GameState {

	Font font;
	
	@SuppressWarnings("unused")
	private GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
		font = new Font("textures/font/ascii.png");
	}
	
	public abstract void update();
	public abstract void input(MouseHandler mouse, KeyHandler key);
	public abstract void render(Graphics2D g, MouseHandler mouse);
	
}
