package com.kamppi.testgame.items;

public class ShearsItem extends ToolItem {

	public ShearsItem(String id, String name, ToolMaterial material, float attackDamage, float attackSpeed) {
		super(id, name, material, ToolType.SHEARS, attackDamage, 4.0f);
	}
}
