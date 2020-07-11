package com.kamppi.testgame.inventory;

import com.kamppi.testgame.util.Vector2f;

public class CraftingGrid extends Inventory {

	public CraftingGrid() {
		super(36);
	}

	protected void initSlots() {
		
		addSlot(36, ItemSlotType.GENERIC, new Vector2f(196, 36));
		addSlot(37, ItemSlotType.GENERIC, new Vector2f(232, 36));
		addSlot(38, ItemSlotType.GENERIC, new Vector2f(196, 72));
		addSlot(39, ItemSlotType.GENERIC, new Vector2f(232, 72));
		addSlot(40, ItemSlotType.RESULT, new Vector2f(308, 56));
	}
}
