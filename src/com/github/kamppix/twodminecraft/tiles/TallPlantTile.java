package com.github.kamppix.twodminecraft.tiles;

import com.github.kamppix.twodminecraft.items.ItemStack;
import com.github.kamppix.twodminecraft.util.Vector2i;
import com.github.kamppix.twodminecraft.world.Chunk;

public class TallPlantTile extends PlantTile {
	
	private final boolean topHalf;

	public TallPlantTile(String id, String name, ItemStack drop, boolean topHalf) {
		super(id, name, drop);
		this.topHalf = topHalf;
	}

	@Override
	public void update(Chunk chunk, Vector2i pos) {
		if (topHalf) {
			if (chunk.getTile(pos.x, pos.y - 1) != Tiles.TALL_GRASS_BOTTOM) {
				chunk.setTile(pos.x, pos.y, null);
			}
		} else {
			if (chunk.getTile(pos.x, pos.y + 1) != Tiles.TALL_GRASS_TOP) {
				chunk.setTile(pos.x, pos.y, null);
			}
			if (chunk.getTile(pos.x, pos.y - 1) == null) {
				chunk.setTile(pos.x, pos.y, null);
			}
		}
	}
}
