package com.kamppi.testgame.tiles;

import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.world.Chunk;

public class PlantTile extends Tile {

	public PlantTile(String id, String name, ItemStack drop) {
		super(id, name, CollisionType.PASS_THROUGH, 0, 0.0f, Material.INSTANT, drop);
	}

	@Override
	public void update(Chunk chunk, int x, int y) {
		if (chunk.getTile(x, y - 1) == null) {
			chunk.setTile(x, y, null);
		}
	}
	
	@Override
	public boolean isReplaceable() {
		return true;
	}
}
