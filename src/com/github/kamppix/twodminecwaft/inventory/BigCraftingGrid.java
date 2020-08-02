package com.github.kamppix.twodminecwaft.inventory;

import com.github.kamppix.twodminecwaft.util.Vector2f;

public class BigCraftingGrid extends Inventory {

	public BigCraftingGrid() {
		super(9);
	}

	protected void initSlots() {

		addSlot(36, ItemSlotType.RESULT, new Vector2f(308, 56));
		addSlot(37, ItemSlotType.GENERIC, new Vector2f(196, 36));
		addSlot(38, ItemSlotType.GENERIC, new Vector2f(232, 36));
		addSlot(39, ItemSlotType.GENERIC, new Vector2f(196, 72));
		addSlot(40, ItemSlotType.GENERIC, new Vector2f(232, 72));
	}
}
