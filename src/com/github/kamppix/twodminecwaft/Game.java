package com.github.kamppix.twodminecwaft;

import com.github.kamppix.twodminecwaft.graphics.Textures;
import com.github.kamppix.twodminecwaft.recipes.RecipeLoader;

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