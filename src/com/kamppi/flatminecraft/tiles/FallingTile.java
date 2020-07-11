package com.kamppi.testgame.tiles;

import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.world.Chunk;

public class FallingTile extends Tile {

	public FallingTile(String id, String name, CollisionType collision, int harvestLevel, float hardness, Material material, ItemStack drop) {
		super(id, name, collision, harvestLevel, hardness, material, drop);
	}

	public void update(Chunk chunk, int x, int y) {
		if (chunk.getTile(x, y - 1) == null || chunk.getTile(x, y - 1) instanceof PlantTile) {
			chunk.setTile(x, y, null);
			
			for (int yy = y - 1; yy >= 0; yy--) {
				if (chunk.getTile(x, yy - 1) != null && chunk.getTile(x, yy - 1).getCollision() != CollisionType.PASS_THROUGH && !(chunk.getTile(x, yy - 1) instanceof PlantTile)) {
					chunk.setTile(x, yy, this);
					break;
				}
			}
		}
	}
}
