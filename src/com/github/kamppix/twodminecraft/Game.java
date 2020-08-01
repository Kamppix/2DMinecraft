package com.github.kamppix.twodminecraft;

import com.github.kamppix.twodminecraft.graphics.Textures;
import com.github.kamppix.twodminecraft.recipes.RecipeLoader;

public class Game {
	
	Player player;
	
	public Game() {

		Textures.load();
		RecipeLoader.loadRecipes();
		new Window();
	}

	public static void main(String[] args) {

		new Game();
	}
}