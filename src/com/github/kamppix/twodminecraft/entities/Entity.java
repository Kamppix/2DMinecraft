package com.github.kamppix.twodminecraft.entities;

public class Entity {

	private final EntityType type;
	private float x;
	private float y;
	private boolean dead;

	public Entity(EntityType type, float x, float y) {
		this.type = type;
		this.x = x;
		this.y = y;
		dead = false;
	}

	public EntityType getType() {
		return type;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
	public boolean getDead() {
		return dead;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
}
