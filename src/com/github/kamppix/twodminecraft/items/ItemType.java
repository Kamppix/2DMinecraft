package com.github.kamppix.twodminecraft.items;

import java.util.ArrayList;
import java.util.List;

public class ItemType {

	public static final List<Item> ITEM_REGISTRY = new ArrayList<>();
	
	/// MISCELLANEOUS ///
	public static final Item COAL = register(new Item("coal", "Coal", 64));
	public static final Item CHARCOAL = register(new Item("charcoal", "Charcoal", 64));
	public static final Item DIAMOND = register(new Item("diamond", "Diamond", 64));
	public static final Item IRON_INGOT = register(new Item("iron_ingot", "Iron Ingot", 64));
	public static final Item GOLD_INGOT = register(new Item("gold_ingot", "Gold Ingot", 64));
	public static final Item NETHERITE_INGOT = register(new Item("netherite_ingot", "Netherite Ingot", 64));
	public static final Item NETHERITE_SCRAP = register(new Item("netherite_scrap", "Netherite Scrap", 64));
	public static final Item STICK = register(new Item("stick", "Stick", 64));
	public static final Item STRING = register(new Item("string", "String", 64));
	public static final Item FEATHER = register(new Item("feather", "Stick", 64));
	public static final Item GUNPOWDER = register(new Item("gunpowder", "Gunpowder", 64));
	public static final Item WHEAT = register(new Item("wheat", "Wheat", 64));
	public static final Item FLINT = register(new Item("flint", "Flint", 64));
	public static final Item LEATHER = register(new Item("leather", "Leather", 64));
	public static final Item BRICK = register(new Item("brick", "Brick", 64));
	public static final Item CLAY_BALL = register(new Item("clay_ball", "Clay Ball", 64));
	public static final Item PAPER = register(new Item("paper", "Paper", 64));
	public static final Item BOOK = register(new Item("book", "Book", 64));
	public static final Item SLIME_BALL = register(new Item("slime_ball", "Slimeball", 64));
	public static final Item GLOWSTONE_DUST = register(new Item("glowstone_dust", "Glowstone Dust", 64));
	public static final Item BONE = register(new Item("bone", "Bone", 64));
	public static final Item SUGAR = register(new Item("sugar", "Sugar", 64));
	public static final Item BLAZE_ROD = register(new Item("blaze_rod", "Blaze Rod", 64));
	public static final Item GOLD_NUGGET = register(new Item("gold_nugget", "Gold Nugget", 64));
	public static final Item FIRE_CHARGE = register(new Item("fire_charge", "Fire Charge", 64));
	public static final Item EMERALD = register(new Item("emerald", "Emerald", 64));
	public static final Item NETHER_STAR = register(new Item("nether_star", "Nether Star", 64));
	public static final Item NETHER_BRICK = register(new Item("nether_brick", "Nether Brick", 64));
	public static final Item QUARTZ = register(new Item("quartz", "Nether Quartz", 64));
	public static final Item PRISMARINE_SHARD = register(new Item("prismarine_shard", "Prismarine Shard", 64));
	public static final Item PRISMARINE_CRYSTALS = register(new Item("prismarine_crystals", "Prismarine Crystals", 64));
	public static final Item RABBIT_HIDE = register(new Item("rabbit_hide", "Rabbit Hide", 64));
	public static final Item POPPED_CHORUS_FRUIT = register(new Item("popped_chorus_fruit", "Popped Chorus Fruit", 64));
	public static final Item SHULKER_SHELL = register(new Item("shulker_shell", "Shulker Shell", 64));
	public static final Item IRON_NUGGET = register(new Item("iron_nugget", "Iron Nugget", 64));
	public static final Item NAUTILUS_SHELL = register(new Item("nautilus_shell", "Nautilus Shell", 64));
	public static final Item HEART_OF_THE_SEA = register(new Item("heart_of_the_sea", "Heart of the Sea", 64));
	public static final Item HONEYCOMB = register(new Item("honeycomb", "Honeycomb", 64));

	/// COMBAT ///
	public static final Item ARROW = register(new Item("arrow", "Arrow", 64));
	public static final Item SPECTRAL_ARROW = register(new Item("spectral_arrow", "Spectral Arrow", 64));
	
	/// BREWING ///
	public static final Item GHAST_TEAR = register(new Item("ghast_tear", "Ghast Tear", 64));
	public static final Item FERMENTED_SPIDER_EYE = register(new Item("fermented_spider_eye", "Fermented Spider Eye", 64));
	public static final Item BLAZE_POWDER = register(new Item("blaze_powder", "Blaze Powder", 64));
	public static final Item MAGMA_CREAM = register(new Item("magma_cream", "Magma Cream", 64));
	public static final Item GLISTERING_MELON_SLICE = register(new Item("glistering_melon_slice", "Glistering Melon Slice", 64));
	public static final Item RABBIT_FOOT = register(new Item("rabbit_foot", "Rabbit's Foot", 64));
	public static final Item DRAGON_BREATH = register(new Item("dragon_breath", "Dragon's Breath", 64));
	public static final Item PHANTOM_MEMBRANE = register(new Item("phantom_membrane", "Phantom Membrane", 64));
	
	/// TRANSPORTATION ///
	public static final Item ELYTRA = register(new ArmorItem("elytra", "Elytra", ArmorType.CHEST, 432, 0.0f, 0.0f));

	/// TILES ///
	public static final Item GRASS_BLOCK = register(new TileItem("grass_block", "Grass Block", 64, "grass_block_side"));
	public static final Item DIRT = register(new TileItem("dirt", "Dirt", 64));
	public static final Item SAND = register(new TileItem("sand", "Sand", 64));
	public static final Item GRAVEL = register(new TileItem("gravel", "Gravel", 64));
	public static final Item STONE = register(new TileItem("stone", "Stone", 64));
	public static final Item GRANITE = register(new TileItem("granite", "Granite", 64));
	public static final Item DIORITE = register(new TileItem("diorite", "Diorite", 64));
	public static final Item ANDESITE = register(new TileItem("andesite", "Andesite", 64));
	public static final Item BEDROCK = register(new TileItem("bedrock", "Bedrock", 64));
	public static final Item COBBLESTONE = register(new TileItem("cobblestone", "Cobblestone", 64));
	public static final Item NETHERRACK = register(new TileItem("netherrack", "Netherrack", 64));
	public static final Item OBSIDIAN = register(new TileItem("obsidian", "Obsidian", 64));
	public static final Item CRYING_OBSIDIAN = register(new TileItem("crying_obsidian", "Crying Obsidian", 64));
	public static final Item ANCIENT_DEBRIS = register(new TileItem("ancient_debris", "Ancient Debris", 64, "ancient_debris_side"));
	public static final Item NETHERITE_BLOCK = register(new TileItem("netherite_block", "Block of Netherite", 64));
	public static final Item DIAMOND_BLOCK = register(new TileItem("diamond_block", "Block of Diamond", 64));
	public static final Item EMERALD_BLOCK = register(new TileItem("emerald_block", "Block of Emerald", 64));
	public static final Item LAPIS_BLOCK = register(new TileItem("lapis_block", "Lapis Lazuli Block", 64));
	public static final Item REDSTONE_BLOCK = register(new TileItem("redstone_block", "Block of Redstone", 64));
	public static final Item GOLD_BLOCK = register(new TileItem("gold_block", "Block of Gold", 64));
	public static final Item IRON_BLOCK = register(new TileItem("iron_block", "Block of Iron", 64));
	public static final Item COAL_BLOCK = register(new TileItem("coal_block", "Block of Coal", 64));
	public static final Item QUARTZ_BLOCK = register(new TileItem("quartz_block", "Block of Quartz", 64, "quartz_block_side"));
	
	public static final Item OAK_SAPLING = register(new TileItem("oak_sapling", "Oak Sapling", 64));
	public static final Item OAK_LOG = register(new TileItem("oak_log", "Oak Log", 64));
	public static final Item OAK_LEAVES = register(new TileItem("oak_leaves", "Oak Leaves", 64));
	public static final Item OAK_PLANKS = register(new TileItem("oak_planks", "Oak Planks", 64));
	
	public static final Item BIRCH_SAPLING = register(new TileItem("birch_sapling", "Birch Sapling", 64));
	public static final Item BIRCH_LOG = register(new TileItem("birch_log", "Birch Log", 64));
	public static final Item BIRCH_LEAVES = register(new TileItem("birch_leaves", "Birch Leaves", 64));
	public static final Item BIRCH_PLANKS = register(new TileItem("birch_planks", "Birch Planks", 64));
	
	public static final Item SPRUCE_SAPLING = register(new TileItem("spruce_sapling", "Spruce Sapling", 64));
	public static final Item SPRUCE_LOG = register(new TileItem("spruce_log", "Spruce Log", 64));
	public static final Item SPRUCE_LEAVES = register(new TileItem("spruce_leaves", "Spruce Leaves", 64));
	public static final Item SPRUCE_PLANKS = register(new TileItem("spruce_planks", "Spruce Planks", 64));
	
	public static final Item JUNGLE_SAPLING = register(new TileItem("jungle_sapling", "Jungle Sapling", 64));
	public static final Item JUNGLE_LOG = register(new TileItem("jungle_log", "Jungle Log", 64));
	public static final Item JUNGLE_LEAVES = register(new TileItem("jungle_leaves", "Jungle Leaves", 64));
	public static final Item JUNGLE_PLANKS = register(new TileItem("jungle_planks", "Jungle Planks", 64));
	
	public static final Item ACACIA_SAPLING = register(new TileItem("acacia_sapling", "Acacia Sapling", 64));
	public static final Item ACACIA_LOG = register(new TileItem("acacia_log", "Acacia Log", 64));
	public static final Item ACACIA_LEAVES = register(new TileItem("acacia_leaves", "Acacia Leaves", 64));
	public static final Item ACACIA_PLANKS = register(new TileItem("acacia_planks", "Acacia Planks", 64));
	
	public static final Item DARK_OAK_SAPLING = register(new TileItem("dark_oak_sapling", "Dark Oak Sapling", 64));
	public static final Item DARK_OAK_LOG = register(new TileItem("dark_oak_log", "Dark Oak Log", 64));
	public static final Item DARK_OAK_LEAVES = register(new TileItem("dark_oak_leaves", "Dark Oak Leaves", 64));
	public static final Item DARK_OAK_PLANKS = register(new TileItem("dark_oak_planks", "Dark Oak Planks", 64));
	
	/// TOOLS ///
	public static final Item WOODEN_SWORD = register(new SwordItem("wooden_sword", "Wooden Sword", ToolMaterial.WOOD, 4.0f));
	public static final Item STONE_SWORD = register(new SwordItem("stone_sword", "Stone Sword", ToolMaterial.STONE, 4.0f));
	public static final Item IRON_SWORD = register(new SwordItem("iron_sword", "Iron Sword", ToolMaterial.IRON, 5.0f));
	public static final Item GOLDEN_SWORD = register(new SwordItem("golden_sword", "Golden Sword", ToolMaterial.GOLD, 6.0f));
	public static final Item DIAMOND_SWORD = register(new SwordItem("diamond_sword", "Diamond Sword", ToolMaterial.DIAMOND, 7.0f));
	public static final Item NETHERITE_SWORD = register(new SwordItem("netherite_sword", "Netherite Sword", ToolMaterial.NETHERITE, 8.0f));
	
	public static final Item WOODEN_PICKAXE = register(new PickaxeItem("wooden_pickaxe", "Wooden Pickaxe", ToolMaterial.WOOD, 2.0f));
	public static final Item STONE_PICKAXE = register(new PickaxeItem("stone_pickaxe", "Stone Pickaxe", ToolMaterial.STONE, 3.0f));
	public static final Item IRON_PICKAXE = register(new PickaxeItem("iron_pickaxe", "Iron Pickaxe", ToolMaterial.IRON, 4.0f));
	public static final Item GOLDEN_PICKAXE = register(new PickaxeItem("golden_pickaxe", "Golden Pickaxe", ToolMaterial.GOLD, 2.0f));
	public static final Item DIAMOND_PICKAXE = register(new PickaxeItem("diamond_pickaxe", "Diamond Pickaxe", ToolMaterial.DIAMOND, 5.0f));
	public static final Item NETHERITE_PICKAXE = register(new PickaxeItem("netherite_pickaxe", "Netherite Pickaxe", ToolMaterial.NETHERITE, 6.0f));
	
	public static final Item WOODEN_SHOVEL = register(new ShovelItem("wooden_shovel", "Wooden Shovel", ToolMaterial.WOOD, 2.5f));
	public static final Item STONE_SHOVEL = register(new ShovelItem("stone_shovel", "Stone Shovel", ToolMaterial.STONE, 3.5f));
	public static final Item IRON_SHOVEL = register(new ShovelItem("iron_shovel", "Iron Shovel", ToolMaterial.IRON, 4.5f));
	public static final Item GOLDEN_SHOVEL = register(new ShovelItem("golden_shovel", "Golden Shovel", ToolMaterial.GOLD, 2.5f));
	public static final Item DIAMOND_SHOVEL = register(new ShovelItem("diamond_shovel", "Diamond Shovel", ToolMaterial.DIAMOND, 5.5f));
	public static final Item NETHERITE_SHOVEL = register(new ShovelItem("netherite_shovel", "Netherite Shovel", ToolMaterial.NETHERITE, 6.5f));
	
	public static final Item WOODEN_AXE = register(new AxeItem("wooden_axe", "Wooden Axe", ToolMaterial.WOOD, 7.0f, 0.8f));
	public static final Item STONE_AXE = register(new AxeItem("stone_axe", "Stone Axe", ToolMaterial.STONE, 9.0f, 0.8f));
	public static final Item IRON_AXE = register(new AxeItem("iron_axe", "Iron Axe", ToolMaterial.IRON, 9.0f, 0.9f));
	public static final Item GOLDEN_AXE = register(new AxeItem("golden_axe", "Golden Axe", ToolMaterial.GOLD, 7.0f, 1.0f));
	public static final Item DIAMOND_AXE = register(new AxeItem("diamond_axe", "Diamond Axe", ToolMaterial.DIAMOND, 9.0f, 1.0f));
	public static final Item NETHERITE_AXE = register(new AxeItem("netherite_axe", "Netherite Axe", ToolMaterial.NETHERITE, 10.0f, 1.0f));
	
	public static final Item WOODEN_HOE = register(new HoeItem("wooden_hoe", "Wooden Hoe", ToolMaterial.WOOD, 1.0f));
	public static final Item STONE_HOE = register(new HoeItem("stone_hoe", "Stone Hoe", ToolMaterial.STONE, 2.0f));
	public static final Item IRON_HOE = register(new HoeItem("iron_hoe", "Iron Hoe", ToolMaterial.IRON, 3.0f));
	public static final Item GOLDEN_HOE = register(new HoeItem("golden_hoe", "Golden Hoe", ToolMaterial.GOLD, 1.0f));
	public static final Item DIAMOND_HOE = register(new HoeItem("diamond_hoe", "Diamond Hoe", ToolMaterial.DIAMOND, 4.0f));
	public static final Item NETHERITE_HOE = register(new HoeItem("netherite_hoe", "Netherite Hoe", ToolMaterial.NETHERITE, 4.0f));
	
	/// ARMOR ///
	public static final Item LEATHER_HELMET = register(new ArmorItem("leather_helmet", "Leather Cap", ArmorType.HEAD, 55, 1.0f, 0.0f));
	public static final Item LEATHER_CHESTPLATE = register(new ArmorItem("leather_chestplate", "Leather Tunic", ArmorType.CHEST, 80, 3.0f, 0.0f));
	public static final Item LEATHER_LEGGINGS = register(new ArmorItem("leather_leggings", "Leather Pants", ArmorType.LEGS, 75, 2.0f, 0.0f));
	public static final Item LEATHER_BOOTS = register(new ArmorItem("leather_boots", "Leather Boots", ArmorType.FEET, 65, 1.0f, 0.0f));
	
	public static final Item GOLDEN_HELMET = register(new ArmorItem("golden_helmet", "Golden Helmet", ArmorType.HEAD, 77, 2.0f, 0.0f));
	public static final Item GOLDEN_CHESTPLATE = register(new ArmorItem("golden_chestplate", "Golden Chestplate", ArmorType.CHEST, 112, 5.0f, 0.0f));
	public static final Item GOLDEN_LEGGINGS = register(new ArmorItem("golden_leggings", "Golden Leggings", ArmorType.LEGS, 105, 3.0f, 0.0f));
	public static final Item GOLDEN_BOOTS = register(new ArmorItem("golden_boots", "Golden Boots", ArmorType.FEET, 91, 1.0f, 0.0f));
	
	public static final Item CHAINMAIL_HELMET = register(new ArmorItem("chainmail_helmet", "Chainmail Helmet", ArmorType.HEAD, 165, 2.0f, 0.0f));
	public static final Item CHAINMAIL_CHESTPLATE = register(new ArmorItem("chainmail_chestplate", "Chainmail Chestplate", ArmorType.CHEST, 240, 5.0f, 0.0f));
	public static final Item CHAINMAIL_LEGGINGS = register(new ArmorItem("chainmail_leggings", "Chainmail Leggings", ArmorType.LEGS, 225, 4.0f, 0.0f));
	public static final Item CHAINMAIL_BOOTS = register(new ArmorItem("chainmail_boots", "Chainmail Boots", ArmorType.FEET, 195, 1.0f, 0.0f));
	
	public static final Item IRON_HELMET = register(new ArmorItem("iron_helmet", "Iron Helmet", ArmorType.HEAD, 165, 2.0f, 0.0f));
	public static final Item IRON_CHESTPLATE = register(new ArmorItem("iron_chestplate", "Iron Chestplate", ArmorType.CHEST, 240, 6.0f, 0.0f));
	public static final Item IRON_LEGGINGS = register(new ArmorItem("iron_leggings", "Iron Leggings", ArmorType.LEGS, 225, 5.0f, 0.0f));
	public static final Item IRON_BOOTS = register(new ArmorItem("iron_boots", "Iron Boots", ArmorType.FEET, 195, 2.0f, 0.0f));
	
	public static final Item DIAMOND_HELMET = register(new ArmorItem("diamond_helmet", "Diamond Helmet", ArmorType.HEAD, 363, 3.0f, 2.0f));
	public static final Item DIAMOND_CHESTPLATE = register(new ArmorItem("diamond_chestplate", "Diamond Chestplate", ArmorType.CHEST, 528, 8.0f, 2.0f));
	public static final Item DIAMOND_LEGGINGS = register(new ArmorItem("diamond_leggings", "Diamond Leggings", ArmorType.LEGS, 495, 6.0f, 2.0f));
	public static final Item DIAMOND_BOOTS = register(new ArmorItem("diamond_boots", "Diamond Boots", ArmorType.FEET, 429, 3.0f, 2.0f));
	
	public static final Item NETHERITE_HELMET = register(new ArmorItem("netherite_helmet", "Netherite Helmet", ArmorType.HEAD, 407, 3.0f, 3.0f));
	public static final Item NETHERITE_CHESTPLATE = register(new ArmorItem("netherite_chestplate", "Netherite Chestplate", ArmorType.CHEST, 592, 8.0f, 3.0f));
	public static final Item NETHERITE_LEGGINGS = register(new ArmorItem("netherite_leggings", "Netherite Leggings", ArmorType.LEGS, 555, 6.0f, 3.0f));
	public static final Item NETHERITE_BOOTS = register(new ArmorItem("netherite_boots", "Netherite Boots", ArmorType.FEET, 481, 3.0f, 3.0f));
	
	public static final Item TURTLE_HELMET = register(new ArmorItem("turtle_helmet", "Turtle Shell", ArmorType.HEAD, 275, 2.0f, 0.0f));
	
	private static Item register(Item i) {
		ITEM_REGISTRY.add(i);
		return i;
	}
	
	public static Item getById(String id) {
		for (Item i : ITEM_REGISTRY) {
			if (i.getId().equals(id)) return i;
		}
		return null;
	}
}
