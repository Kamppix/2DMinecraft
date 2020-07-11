package com.kamppi.testgame.tiles;

import com.kamppi.testgame.items.ItemStack;
public class PlantableTile extends Tile {

	public PlantableTile(String id, String name, CollisionType collisionType, int harvestLevel, float hardness, Material material, ItemStack drop) {
		super(id, name, collisionType, harvestLevel, hardness, material, drop);
	}
	
}
