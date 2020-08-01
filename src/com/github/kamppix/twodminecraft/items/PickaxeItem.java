package com.github.kamppix.twodminecraft.items;

public class PickaxeItem extends ToolItem {

	public PickaxeItem(String id, String name, ToolMaterial material, float attackDamage) {
		super(id, name, material, ToolType.PICKAXE, attackDamage, 1.2f);
	}
}
