package com.kamppi.testgame.states;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.kamppi.testgame.util.KeyHandler;
import com.kamppi.testgame.util.MouseHandler;

public class GameStateManager {

	ArrayList<GameState> STATES;
	
	public static final int PLAY = 0;
	public static final int GUI = 1;
	public static final int PAUSE = 2;
	public static final int DEAD = 3;
	
	public GameStateManager() {
		STATES = new ArrayList<>();
		
		STATES.add(new PlayState(this));
	}
	
	public void pop(int state) {
		STATES.remove(state);
	}
	
	public void add(int state) {
		if (state == PLAY) {
			STATES.add(new PlayState(this));
		}
	}
	
	public void addAndPop(int state) {
		STATES.remove(0);
		add(state);
	}
	
	public void update() {
		for (GameState s : STATES) {
			s.update();
		}
	}
	
	public void input(MouseHandler mouse, KeyHandler key) {
		key.tick();
		for (GameState s : STATES) {
			s.input(mouse, key);
		}
		mouse.tick();
	}
	
	public void render(Graphics2D g, MouseHandler mouse) {
		for (GameState s : STATES) {
			s.render(g, mouse);
		}
	}
}
