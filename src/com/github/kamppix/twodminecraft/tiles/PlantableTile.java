package com.github.kamppix.twodminecraft.tiles;

import com.github.kamppix.twodminecraft.items.ItemStack;
public class PlantableTile extends Tile {

	public PlantableTile(String id, String name, CollisionType collisionType, int harvestLevel, float hardness, Material material, ItemStack drop) {
		super(id, name, collisionType, harvestLevel, hardness, material, drop);
	}
	
	public PlantableTile(String id, String name, CollisionType collisionType, int harvestLevel, float hardness, Material material, ItemStack drop, String textureName) {
		super(id, name, collisionType, harvestLevel, hardness, material, drop, textureName);
	}
}
