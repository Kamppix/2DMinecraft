package com.github.kamppix.twodminecwaft.tiles;

import com.github.kamppix.twodminecwaft.items.ItemStack;

public class LogTile extends Tile {

	public LogTile(String id, String name, ItemStack drop) {
		super(id, name, CollisionType.PASS_THROUGH, 0, 2.0f, Material.WOOD, drop);
	}
	
}
