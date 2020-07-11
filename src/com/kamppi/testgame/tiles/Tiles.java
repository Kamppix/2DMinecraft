package com.kamppi.testgame.tiles;

import java.util.ArrayList;
import java.util.List;

import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.items.Items;

public class Tiles {

	public static final List<Tile> TILE_REGISTRY = new ArrayList<>();

	public static final Tile GRASS_BLOCK = register(new PlantableTile("grass_block", "Grass Block", CollisionType.FULL_TILE, 0, 0.6F, Material.GROUND, new ItemStack(Items.DIRT)));
	public static final Tile DIRT = register(new PlantableTile("dirt", "Dirt", CollisionType.FULL_TILE, 0, 0.5F, Material.GROUND, new ItemStack(Items.DIRT)));
	public static final Tile STONE = register(new Tile("stone", "Stone", CollisionType.FULL_TILE, 1, 1.5F, Material.ROCK, new ItemStack(Items.COBBLESTONE)));
	public static final Tile SAND = register(new FallingTile("sand", "Sand", CollisionType.FULL_TILE, 0, 0.5f, Material.GROUND, new ItemStack(Items.SAND)));
	public static final Tile GRAVEL = register(new FallingTile("gravel", "Gravel", CollisionType.FULL_TILE, 0, 0.6f, Material.GROUND, new ItemStack(Items.GRAVEL)));
	public static final Tile BEDROCK = register(new Tile("bedrock", "Bedrock", CollisionType.FULL_TILE, 0, -1.0f, Material.UNBREAKABLE, new ItemStack(Items.BEDROCK)));

	public static final Tile COBBLESTONE = register(new Tile("cobblestone", "Cobblestone", CollisionType.FULL_TILE, 1, 2.0f, Material.ROCK, new ItemStack(Items.COBBLESTONE)));
	
	public static final Tile GRASS = register(new PlantTile("grass", "Grass", null));
	public static final Tile TALL_GRASS_TOP = register(new TallPlantTile("tall_grass_top", "Tall Grass", null, true));
	public static final Tile TALL_GRASS_BOTTOM = register(new TallPlantTile("tall_grass_bottom", "Tall Grass", null, false));
	public static final Tile FERN = register(new PlantTile("fern", "Fern", null));
	public static final Tile LARGE_FERN_TOP = register(new TallPlantTile("large_fern_top", "Large Fern", null, true));
	public static final Tile LARGE_FERN_BOTTOM = register(new TallPlantTile("large_fern_bottom", "Large Fern", null, false));
	
	public static final Tile OAK_SAPLING = register(new SaplingTile("oak_sapling", "Oak Sapling", new ItemStack(Items.OAK_SAPLING)));
	public static final Tile OAK_LOG = register(new LogTile("oak_log", "Oak Log", new ItemStack(Items.OAK_LOG)));
	public static final Tile OAK_LEAVES = register(new LeavesTile("oak_leaves", "Oak Leaves", new ItemStack(Items.OAK_LEAVES)));
	public static final Tile OAK_PLANKS = register(new Tile("oak_planks", "Oak Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.OAK_PLANKS)));
	
	public static final Tile BIRCH_SAPLING = register(new SaplingTile("birch_sapling", "Birch Sapling", new ItemStack(Items.BIRCH_SAPLING)));
	public static final Tile BIRCH_LOG = register(new LogTile("birch_log", "Birch Log", new ItemStack(Items.BIRCH_LOG)));
	public static final Tile BIRCH_LEAVES = register(new LeavesTile("birch_leaves", "Birch Leaves", new ItemStack(Items.BIRCH_LEAVES)));
	public static final Tile BIRCH_PLANKS = register(new Tile("birch_planks", "Birch Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.BIRCH_PLANKS)));
	
	public static final Tile SPRUCE_SAPLING = register(new SaplingTile("spruce_sapling", "Spruce Sapling", new ItemStack(Items.SPRUCE_SAPLING)));
	public static final Tile SPRUCE_LOG = register(new LogTile("spruce_log", "Spruce Log", new ItemStack(Items.SPRUCE_LOG)));
	public static final Tile SPRUCE_LEAVES = register(new LeavesTile("spruce_leaves", "Spruce Leaves", new ItemStack(Items.SPRUCE_LEAVES)));
	public static final Tile SPRUCE_PLANKS = register(new Tile("spruce_planks", "Spruce Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.SPRUCE_PLANKS)));
	
	public static final Tile JUNGLE_SAPLING = register(new SaplingTile("jungle_sapling", "Jungle Sapling", new ItemStack(Items.JUNGLE_SAPLING)));
	public static final Tile JUNGLE_LOG = register(new LogTile("jungle_log", "Jungle Log", new ItemStack(Items.JUNGLE_LOG)));
	public static final Tile JUNGLE_LEAVES = register(new LeavesTile("jungle_leaves", "Jungle Leaves", new ItemStack(Items.JUNGLE_LEAVES)));
	public static final Tile JUNGLE_PLANKS = register(new Tile("jungle_planks", "Jungle Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.JUNGLE_PLANKS)));
	
	public static final Tile ACACIA_SAPLING = register(new SaplingTile("acacia_sapling", "Acacia Sapling", new ItemStack(Items.ACACIA_SAPLING)));
	public static final Tile ACACIA_LOG = register(new LogTile("acacia_log", "Acacia Log", new ItemStack(Items.ACACIA_LOG)));
	public static final Tile ACACIA_LEAVES = register(new LeavesTile("acacia_leaves", "Acacia Leaves", new ItemStack(Items.ACACIA_LEAVES)));
	public static final Tile ACACIA_PLANKS = register(new Tile("acacia_planks", "Acacia Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.ACACIA_PLANKS)));
	
	public static final Tile DARK_OAK_SAPLING = register(new SaplingTile("dark_oak_sapling", "Dark Oak Sapling", new ItemStack(Items.DARK_OAK_SAPLING)));
	public static final Tile DARK_OAK_LOG = register(new LogTile("dark_oak_log", "Dark Oak Log", new ItemStack(Items.DARK_OAK_LOG)));
	public static final Tile DARK_OAK_LEAVES = register(new LeavesTile("dark_oak_leaves", "Dark Oak Leaves", new ItemStack(Items.DARK_OAK_LEAVES)));
	public static final Tile DARK_OAK_PLANKS = register(new Tile("dark_oak_planks", "Dark Oak Planks", CollisionType.FULL_TILE, 0, 2.0f, Material.WOOD, new ItemStack(Items.DARK_OAK_PLANKS)));
	
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
