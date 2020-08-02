package com.github.kamppix.twodminecwaft.inventory;

import com.github.kamppix.twodminecwaft.util.Vector2f;

public class PlayerInventory extends Inventory {

	public PlayerInventory() {
		super(36);
	}

	protected void initSlots() {
		for (int i = 0; i < 9; i++) {
			addSlot(i, ItemSlotType.GENERIC, new Vector2f(16 + i * 36, 284));
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlot(9 * (i + 1) + j, ItemSlotType.GENERIC, new Vector2f(16 + j * 36, 168 + i * 36));
			}
		}
		
		addSlot(-2, ItemSlotType.OFFHAND, new Vector2f(154, 124));
		
		addSlot(-3, ItemSlotType.ARMOR_BOOTS, new Vector2f(16, 124));
		addSlot(-4, ItemSlotType.ARMOR_LEGGINGS, new Vector2f(16, 88));
		addSlot(-5, ItemSlotType.ARMOR_CHESTPLATE, new Vector2f(16, 52));
		addSlot(-6, ItemSlotType.ARMOR_HELMET, new Vector2f(16, 16));
	}
}
