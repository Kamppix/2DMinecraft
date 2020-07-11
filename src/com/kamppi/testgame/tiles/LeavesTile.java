package com.kamppi.testgame.tiles;

import com.kamppi.testgame.items.ItemStack;

public class LeavesTile extends Tile {

	public LeavesTile(String id, String name, ItemStack drop) {
		super(id, name, CollisionType.PASS_THROUGH, 0, 0.2f, Material.LEAVES, drop);
	}

}
