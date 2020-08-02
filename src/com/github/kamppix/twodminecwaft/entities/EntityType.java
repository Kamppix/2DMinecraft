package com.github.kamppix.twodminecwaft.entities;

public class EntityType {
	
	private final String id;
	private final String name;

	public EntityType(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
