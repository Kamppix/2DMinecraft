package com.github.kamppix.twodminecraft.entities;

public class MobType extends EntityType {

	private final float maxHealth;
	private float health;
	
	public MobType(String id, String name, float maxHealth) {
		super(id, name);
		this.maxHealth = maxHealth;
		this.health = this.maxHealth;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(float health) {
		this.health = health;
	}

	public float getMaxHealth() {
		return maxHealth;
	}

}
