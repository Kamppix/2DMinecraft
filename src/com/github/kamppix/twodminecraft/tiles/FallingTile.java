package com.github.kamppix.twodminecraft.tiles;

import com.github.kamppix.twodminecraft.items.ItemStack;
import com.github.kamppix.twodminecraft.util.Vector2i;
import com.github.kamppix.twodminecraft.world.Chunk;

public class FallingTile extends Tile {

	public FallingTile(String id, String name, CollisionType collision, int harvestLevel, float hardness, Material material, ItemStack drop) {
		super(id, name, collision, harvestLevel, hardness, material, drop);
	}

	public void update(Chunk chunk, Vector2i pos) {
		if (chunk.getTile(pos.x, pos.y - 1) == null || chunk.getTile(pos.x, pos.y - 1) instanceof PlantTile) {
			chunk.setTile(pos.x, pos.y, null);
			
			for (int yy = pos.y - 1; yy >= 0; yy--) {
				if (chunk.getTile(pos.x, yy - 1) != null && chunk.getTile(pos.x, yy - 1).getCollision() != CollisionType.PASS_THROUGH && !(chunk.getTile(pos.x, yy - 1) instanceof PlantTile)) {
					chunk.setTile(pos.x, yy, this);
					break;
				}
			}
		}
	}
}
