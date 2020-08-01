package com.github.kamppix.twodminecraft.entities;

public class PlayerType extends MobType {

	@SuppressWarnings("unused")
	private int score;
	
	public PlayerType(String name, float maxHealth) {
		super("player", "Player", 20.0F);
		score = 0;
	}
}