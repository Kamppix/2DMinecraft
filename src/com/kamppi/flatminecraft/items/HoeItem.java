package com.kamppi.testgame.items;

public class HoeItem extends ToolItem {

	public HoeItem(String id, String name, ToolMaterial material, float attackSpeed) {
		super(id, name, material, ToolType.HOE, 1.0f, attackSpeed);
	}
}
