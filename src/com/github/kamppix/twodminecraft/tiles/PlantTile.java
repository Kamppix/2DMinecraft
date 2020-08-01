package com.github.kamppix.twodminecraft.tiles;

import com.github.kamppix.twodminecraft.items.ItemStack;
import com.github.kamppix.twodminecraft.util.Vector2i;
import com.github.kamppix.twodminecraft.world.Chunk;

public class PlantTile extends Tile {

	public PlantTile(String id, String name, ItemStack drop) {
		super(id, name, CollisionType.PASS_THROUGH, 0, 0.0f, Material.INSTANT, drop);
	}

	@Override
	public void update(Chunk chunk, Vector2i pos) {
		if (chunk.getTile(pos.x, pos.y - 1) == null) {
			chunk.setTile(pos.x, pos.y, null);
		}
	}
	
	@Override
	public boolean isReplaceable() {
		return true;
	}
}
