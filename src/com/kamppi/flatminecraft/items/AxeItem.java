package com.kamppi.testgame.items;

public class AxeItem extends ToolItem {

	public AxeItem(String id, String name, ToolMaterial material, float attackDamage, float attackSpeed) {
		super(id, name, material, ToolType.AXE, attackDamage, attackSpeed);
	}
}
