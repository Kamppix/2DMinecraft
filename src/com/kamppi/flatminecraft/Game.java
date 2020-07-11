package com.kamppi.testgame;

import com.kamppi.testgame.graphics.Textures;

public class Game {
	
	Player player;
	
	public Game() {

		Textures.load();
		new Window();
	}

	public static void main(String[] args) {

		new Game();
	}
}