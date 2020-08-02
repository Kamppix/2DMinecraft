package com.github.kamppix.twodminecwaft.entities;

import java.util.ArrayList;
import java.util.List;

public class Entities {

	public static final List<EntityType> ENTITY_REGISTRY = new ArrayList<>();
	
	public static final EntityType ZOMBIE = register(new MonsterType("zombie", "Zombie", 10.0F, 3.0F));
	
	private static EntityType register(EntityType e) {
		ENTITY_REGISTRY.add(e);
		return e;
	}
	
	public static EntityType getById(String id) {
		for (EntityType e : ENTITY_REGISTRY) {
			if (e.getId().equals(id)) return e;
		}
		return null;
	}
	
	public static final List<Entity> ENTITIES = new ArrayList<>();

	public static void addEntity(Entity entity, int index) {
		ENTITIES.add(index, entity);
	}
	
	public static void addEntity(Entity entity) {
		ENTITIES.add(entity);
	}
	
	public static void removeDead() {
		for (Entity e : ENTITIES) {
			if (e.getDead()) {
				ENTITIES.remove(e);
			}
		}
	}
	
	public static PlayerType player() {
		return (PlayerType) ENTITIES.get(0).getType();
	}
}
