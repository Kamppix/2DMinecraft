package com.github.kamppix.twodminecwaft.tiles;

import java.util.ArrayList;
import java.util.List;

import com.github.kamppix.twodminecwaft.items.ItemStack;
import com.github.kamppix.twodminecwaft.items.ItemType;

public class Tiles {

	public static final List<Tile> TILE_REGISTRY = new ArrayList<>();

	public static final Tile GRASS_BLOCK = register(new PlantableTile("grass_block", "Grass Block", CollisionType.FULL_TILE, 0, 0.6F, Material.GROUND, new ItemStack(ItemType.DIRT), "grass_block_side"));
	public static final Tile DIRT = register(new PlantableTile("dirt", "Dirt", CollisionType.FULL_TILE, 0, 0.5F, Material.GROUND, new ItemStack(ItemType.DIRT)));
	public static final Tile STONE = register(new Tile("stone", "Stone", CollisionType.FULL_TILE, 1, 1.5F, Material.ROCK, new ItemStack(ItemType.COBBLESTONE)));
	public static final Tile GRANITE = register(new Tile("granite", "Granite", CollisionType.FULL_TILE, 1, 1.5F, Material.ROCK, new ItemStack(ItemType.GRANITE)));
	public static final Tile DIORITE = register(new Tile("diorite", "Diorite", CollisionType.FULL_TILE, 1, 1.5F, Material.ROCK, new ItemStack(ItemType.DIORITE)));
	public static final Tile ANDESITE = register(new Tile("andesite", "Andesite", CollisionType.FULL_TILE, 1, 1.5F, Material.ROCK, new ItemStack(ItemType.ANDESITE)));
	public static final Tile SAND = register(new FallingTile("sand", "Sand", CollisionType.FULL_TILE, 0, 0.5f, Material.GROUND, new ItemStack(ItemType.SAND)));
	public static final Tile GRAVEL = register(new FallingTile("gravel", "Gravel", CollisionType.FULL_TILE, 0, 0.6f, Material.GROUND, new ItemStack(ItemType.GRAVEL)));
	public static final Tile BEDROCK = register(new Tile("bedrock", "Bedrock", CollisionType.FULL_TILE, 0, -1.0f, Material.UNBREAKABLE, new ItemStack(ItemType.BEDROCK)));
	public static final Tile COBBLESTONE = register(new Tile("cobblestone", "Cobblestone", CollisionType.FULL_TILE, 1, 2.0f, Material.ROCK, new ItemStack(ItemType.COBBLESTONE)));
	public static final Tile NETHERRACK = register(new Tile("netherrack", "Netherrack", CollisionType.FULL_TILE, 1, 0.4f, Material.ROCK, new ItemStack(ItemType.NETHERRACK)));
	public static final Tile OBSIDIAN = register(new Tile("obsidian", "Obsidian", CollisionType.FULL_TILE, 3, 50.0f, Material.ROCK, new ItemStack(ItemType.OBSIDIAN)));
	public static final Tile CRYING_OBSIDIAN = register(new Tile("crying_obsidian", "Crying Obsidian", CollisionType.FULL_TILE, 3, 50.0f, Material.ROCK, new ItemStack(ItemType.CRYING_OBSIDIAN)));
	public static final Tile ANCIENT_DEBRIS = register(new Tile("ancient_debris", "Ancient Debris", CollisionType.FULL_TILE, 3, 30.0f, Material.METAL, new ItemStack(ItemType.ANCIENT_DEBRIS), "ancient_debris_side"));
	public static final Tile NETHERITE_BLOCK = register(new Tile("netherite_block", "Block of Netherite", CollisionType.FULL_TILE, 3, 50.0f, Material.METAL, new ItemStack(ItemType.NETHERITE_BLOCK)));
	public static final Tile DIAMOND_BLOCK = register(new Tile("diamond_block", "Block of Diamond", CollisionType.FULL_TILE, 2, 5.0f, Material.METAL, new ItemStack(ItemType.DIAMOND_BLOCK)));
	public static final Tile EMERALD_BLOCK = register(new Tile("emerald_block", "Block of Emerald", CollisionType.FULL_TILE, 2, 5.0f, Material.METAL, new ItemStack(ItemType.EMERALD_BLOCK)));
	public static final Tile LAPIS_BLOCK = register(new Tile("lapis_block", "Lapis Lazuli Block", CollisionType.FULL_TILE, 1, 3.0f, Material.METAL, new ItemStack(ItemType.LAPIS_BLOCK)));
	public static final Tile REDSTONE_BLOCK = register(new Tile("redstone_block", "Block of Redstone", CollisionType.FULL_TILE, 0, 5.0f, Material.METAL, new ItemStack(ItemType.REDSTONE_BLOCK)));
	public static final Tile GOLD_BLOCK = register(new Tile("gold_block", "Block of Gold", CollisionType.FULL_TILE, 2, 3.0f, Material.METAL, new ItemStack(ItemType.GOLD_BLOCK)));
	public static final Tile IRON_BLOCK = register(new Tile("iron_block", "Block of Iron", CollisionType.FULL_TILE, 1, 5.0f, Material.METAL, new ItemStack(ItemType.IRON_BLOCK)));
	public static final Tile COAL_BLOCK = register(new Tile("coal_block", "Block of Coal", CollisionType.FULL_TILE, 0, 5.0f, Material.METAL, new ItemStack(ItemType.COAL_BLOCK)));
	public static final Tile QUARTZ_BLOCK = register(new Tile("quartz_block", "Block of Quartz", CollisionType.FULL_TILE, 0, 0.8f, Material.METAL, new ItemStack(ItemType.QUARTZ_BLOCK), "quartz_block_side"));
	
	public static final Tile GRASS = register(new PlantTile("grass", "Grass", null));
	public static final Tile TALL_GRASS_TOP = register(new TallPlantTile("tall_grass_top", "Tall Grass", null, true));
	public static final Tile TALL_GRASS_BOTTOM = register(new TallPlantTile("tall_grass_bottom", "Tall Grass", null, false));
	public static final Tile FERN = register(new PlantTile("fern", "Fern", null));
	public static final Tile LARGE_FERN_TOP = register(new TallPlantTile("large_fern_top", "Large Fern", null, true));
	public static final Tile LARGE_FERN_BOTTOM = register(new TallPlantTile("large_fern_bottom", "Large Fern", null, false));
	
	public static final Tile OAK_SAPLING = register(new SaplingTile("oak_sapling", "Oak Sapling", new ItemStack(ItemType.OAK_SAPLING)));
	public static final Tile OAK_LOG = register(new LogTile("oak_log", "Oak Log", new ItemStack(ItemType.OAK_LOG)));
	public static final Tile OAK_LEAVES = register(new LeavesTile("oak_leaves", "Oak Leaves", new ItemStack(ItemType.OAK_LEAVES)));
	public static final Tile OAK_PLANKS = register(new Tile("oak_planks", "Oak Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.OAK_PLANKS)));
	
	public static final Tile BIRCH_SAPLING = register(new SaplingTile("birch_sapling", "Birch Sapling", new ItemStack(ItemType.BIRCH_SAPLING)));
	public static final Tile BIRCH_LOG = register(new LogTile("birch_log", "Birch Log", new ItemStack(ItemType.BIRCH_LOG)));
	public static final Tile BIRCH_LEAVES = register(new LeavesTile("birch_leaves", "Birch Leaves", new ItemStack(ItemType.BIRCH_LEAVES)));
	public static final Tile BIRCH_PLANKS = register(new Tile("birch_planks", "Birch Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.BIRCH_PLANKS)));
	
	public static final Tile SPRUCE_SAPLING = register(new SaplingTile("spruce_sapling", "Spruce Sapling", new ItemStack(ItemType.SPRUCE_SAPLING)));
	public static final Tile SPRUCE_LOG = register(new LogTile("spruce_log", "Spruce Log", new ItemStack(ItemType.SPRUCE_LOG)));
	public static final Tile SPRUCE_LEAVES = register(new LeavesTile("spruce_leaves", "Spruce Leaves", new ItemStack(ItemType.SPRUCE_LEAVES)));
	public static final Tile SPRUCE_PLANKS = register(new Tile("spruce_planks", "Spruce Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.SPRUCE_PLANKS)));
	
	public static final Tile JUNGLE_SAPLING = register(new SaplingTile("jungle_sapling", "Jungle Sapling", new ItemStack(ItemType.JUNGLE_SAPLING)));
	public static final Tile JUNGLE_LOG = register(new LogTile("jungle_log", "Jungle Log", new ItemStack(ItemType.JUNGLE_LOG)));
	public static final Tile JUNGLE_LEAVES = register(new LeavesTile("jungle_leaves", "Jungle Leaves", new ItemStack(ItemType.JUNGLE_LEAVES)));
	public static final Tile JUNGLE_PLANKS = register(new Tile("jungle_planks", "Jungle Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.JUNGLE_PLANKS)));
	
	public static final Tile ACACIA_SAPLING = register(new SaplingTile("acacia_sapling", "Acacia Sapling", new ItemStack(ItemType.ACACIA_SAPLING)));
	public static final Tile ACACIA_LOG = register(new LogTile("acacia_log", "Acacia Log", new ItemStack(ItemType.ACACIA_LOG)));
	public static final Tile ACACIA_LEAVES = register(new LeavesTile("acacia_leaves", "Acacia Leaves", new ItemStack(ItemType.ACACIA_LEAVES)));
	public static final Tile ACACIA_PLANKS = register(new Tile("acacia_planks", "Acacia Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.ACACIA_PLANKS)));
	
	public static final Tile DARK_OAK_SAPLING = register(new SaplingTile("dark_oak_sapling", "Dark Oak Sapling", new ItemStack(ItemType.DARK_OAK_SAPLING)));
	public static final Tile DARK_OAK_LOG = register(new LogTile("dark_oak_log", "Dark Oak Log", new ItemStack(ItemType.DARK_OAK_LOG)));
	public static final Tile DARK_OAK_LEAVES = register(new LeavesTile("dark_oak_leaves", "Dark Oak Leaves", new ItemStack(ItemType.DARK_OAK_LEAVES)));
	public static final Tile DARK_OAK_PLANKS = register(new Tile("dark_oak_planks", "Dark Oak Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(ItemType.DARK_OAK_PLANKS)));
	
	private static Tile register(Tile t) {
		TILE_REGISTRY.add(t);
		return t;
	}
	
	public static Tile getById(String id) {
		for (Tile t : TILE_REGISTRY) {
			if (t.getId().equals(id)) return t;
		}
		return null;
	}
}
