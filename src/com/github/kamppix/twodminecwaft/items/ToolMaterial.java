package com.github.kamppix.twodminecwaft.items;

public class ToolMaterial {

	public static final ToolMaterial WOOD = new ToolMaterial(59, 0, 2.0F);
	public static final ToolMaterial STONE = new ToolMaterial(131, 1, 4.0F);
	public static final ToolMaterial IRON = new ToolMaterial(250, 2, 6.0F);
	public static final ToolMaterial GOLD = new ToolMaterial(32, 0, 12.0F);
	public static final ToolMaterial DIAMOND = new ToolMaterial(1561, 3, 8.0F);
	public static final ToolMaterial NETHERITE = new ToolMaterial(2031, 3, 9.0F);
	
	public static final ToolMaterial SHEARS = new ToolMaterial(238, 0, 1.5F);

	private final int maxUses;
	private final int harvestLevel;
	private final float miningSpeed;
	
	public ToolMaterial(int maxUses, int harvestLevel, float miningSpeed) {
		this.maxUses = maxUses;
		this.harvestLevel = harvestLevel;
		this.miningSpeed = miningSpeed;
	}

	public int getMaxUses() {
		return maxUses;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	public float getMiningSpeed() {
		return miningSpeed;
	}
}
