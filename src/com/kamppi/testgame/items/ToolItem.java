package com.kamppi.testgame.items;

public class ToolItem extends Item {
	
	private final ToolMaterial material;
	private final ToolType toolType;
	private final float attackDamage;
	private final float attackSpeed;
	
	public ToolItem(String id, String name, ToolMaterial material, ToolType toolType, float attackDamage, float attackSpeed) {
		super(id, name, 1);
		this.material = material;
		this.toolType = toolType;
		this.attackDamage = attackDamage;
		this.attackSpeed = attackSpeed;
	}

	public ToolMaterial getMaterial() {
		return material;
	}

	public ToolType getToolType() {
		return toolType;
	}

	public float getAttackDamage() {
		return attackDamage;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}
}
