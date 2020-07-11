package com.kamppi.testgame.tiles;

import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.world.Chunk;

public class TallPlantTile extends PlantTile {
	
	private final boolean topHalf;

	public TallPlantTile(String id, String name, ItemStack drop, boolean topHalf) {
		super(id, name, drop);
		this.topHalf = topHalf;
	}

	@Override
	public void update(Chunk chunk, int x, int y) {
		if (topHalf) {
			if (chunk.getTile(x, y - 1) != Tiles.TALL_GRASS_BOTTOM) {
				chunk.setTile(x, y, null);
			}
		} else {
			if (chunk.getTile(x, y + 1) != Tiles.TALL_GRASS_TOP) {
				chunk.setTile(x, y, null);
			}
			if (chunk.getTile(x, y - 1) == null) {
				chunk.setTile(x, y, null);
			}
		}
	}
}
