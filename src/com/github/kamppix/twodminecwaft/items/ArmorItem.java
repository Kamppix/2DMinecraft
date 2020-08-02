package com.github.kamppix.twodminecwaft.items;

public class ArmorItem extends Item {
	
	private final ArmorType armorType;
	private final int maxDurability;
	private final float defense;
	private final float toughness;
	
	public ArmorItem(String id, String name, ArmorType armorType, int maxDurability, float defense, float toughness) {
		super(id, name, 1);
		this.armorType = armorType;
		this.maxDurability = maxDurability;
		this.defense = defense;
		this.toughness = toughness;
	}

	public ArmorType getArmorType() {
		return armorType;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public float getDefense() {
		return defense;
	}

	public float getToughness() {
		return toughness;
	}
}
