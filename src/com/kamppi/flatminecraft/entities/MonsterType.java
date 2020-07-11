package com.kamppi.testgame.entities;

public class MonsterType extends MobType {

	private final float damage;
	
	public MonsterType(String id, String name, float maxHealth, float damage) {
		super(id, name, maxHealth);
		this.damage = damage;
	}

	public float getDamage() {
		return damage;
	}

}
