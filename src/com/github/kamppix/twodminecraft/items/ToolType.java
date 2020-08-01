package com.github.kamppix.twodminecraft.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.github.kamppix.twodminecraft.tiles.Material;

public class ToolType {

	public static final ToolType SWORD = new ToolType(Arrays.asList(Material.WEB, Material.BAMBOO));
	public static final ToolType PICKAXE = new ToolType(Arrays.asList(Material.ICE, Material.METAL, Material.PISTON, Material.CONDUIT, Material.SHULKER_BOX, Material.RAIL, Material.ROCK));
	public static final ToolType SHOVEL = new ToolType(Arrays.asList(Material.GROUND, Material.SNOW));
	public static final ToolType AXE = new ToolType(Arrays.asList(Material.PLANTS, Material.WOOD));
	public static final ToolType HOE = new ToolType(Arrays.asList(Material.LEAVES, Material.LIVING));
	public static final ToolType SHEARS = new ToolType(Arrays.asList(Material.LEAVES, Material.WEB, Material.WOOL));
	
	private final List<Material> effectiveOn;
	
	public ToolType(List<Material> effectiveOn) {
		this.effectiveOn = new ArrayList<>();
		this.effectiveOn.addAll(effectiveOn);
	}
	
	public List<Material> getEffectiveOn() {
		return effectiveOn;
	}
}
