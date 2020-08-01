package com.github.kamppix.twodminecraft.graphics;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.github.kamppix.twodminecraft.Game;

public class Textures {
	
	public static BufferedImage ICONS;
	public static Image HEART_SLOT;
	public static Image HEART_SLOT_FLASH;
	public static Image HEART;
	public static Image HEART_HALF;
	public static Image HEART_FLASH;
	public static Image HEART_FLASH_HALF;
	public static Image FOOD_SLOT;
	public static Image FOOD;
	public static Image FOOD_HALF;
	public static Image XP_BAR;
	
	public static BufferedImage WIDGETS;
	public static Image HOTBAR;
	public static Image HOTBAR_SELECTED;
	public static Image OFFHAND_SLOT;
	
	public static Image FADE;
	
	public static List<Image> BREAK_STAGES = new ArrayList<>();
	static Image BREAK_0;
	static Image BREAK_1;
	static Image BREAK_2;
	static Image BREAK_3;
	static Image BREAK_4;
	static Image BREAK_5;
	static Image BREAK_6;
	static Image BREAK_7;
	static Image BREAK_8;
	static Image BREAK_9;
	
	private static BufferedImage PLAYER_INVENTORY_GUI_IMAGE;
	public static Image PLAYER_INVENTORY_GUI;
	public static Image PLAYER_INVENTORY_EFFECT;
	public static Image PLAYER_INVENTORY_RECIPE_BOOK;
	public static Image PLAYER_INVENTORY_RECIPE_BOOK_BLUE;
	
	private static BufferedImage CRAFTING_TABLE_GUI_IMAGE;
	public static Image CRAFTING_TABLE_GUI;

	public static Image SLOT_OFFHAND;
	public static Image SLOT_HELMET;
	public static Image SLOT_CHESTPLATE;
	public static Image SLOT_LEGGINGS;
	public static Image SLOT_BOOTS;
	
	public static void load() {
		try {
			ICONS = ImageIO.read(Game.class.getResource("/textures/gui/icons.png"));
			HEART_SLOT = ICONS.getSubimage(16, 0, 9, 9);
			HEART_SLOT_FLASH = ICONS.getSubimage(25, 0, 9, 9);
			HEART = ICONS.getSubimage(52, 0, 9, 9);
			HEART_HALF = ICONS.getSubimage(61, 0, 9, 9);
			HEART_FLASH = ICONS.getSubimage(70, 0, 9, 9);
			HEART_FLASH_HALF = ICONS.getSubimage(79, 0, 9, 9);
			FOOD_SLOT = ICONS.getSubimage(16, 27, 9, 9);
			FOOD = ICONS.getSubimage(52, 27, 9, 9);
			FOOD_HALF = ICONS.getSubimage(61, 27, 9, 9);
			XP_BAR = ICONS.getSubimage(0, 64, 182, 5);
	
			WIDGETS = ImageIO.read(Game.class.getResource("/textures/gui/widgets.png"));
			HOTBAR = WIDGETS.getSubimage(0, 0, 182, 22);
			HOTBAR_SELECTED = WIDGETS.getSubimage(0, 22, 24, 24);
			OFFHAND_SLOT = WIDGETS.getSubimage(24, 23, 22, 22);
			
			FADE = ImageIO.read(Game.class.getResource("/textures/block/fade.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			
			toList(BREAK_0 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_0.png")), BREAK_STAGES);
			toList(BREAK_1 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_1.png")), BREAK_STAGES);
			toList(BREAK_2 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_2.png")), BREAK_STAGES);
			toList(BREAK_3 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_3.png")), BREAK_STAGES);
			toList(BREAK_4 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_4.png")), BREAK_STAGES);
			toList(BREAK_5 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_5.png")), BREAK_STAGES);
			toList(BREAK_6 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_6.png")), BREAK_STAGES);
			toList(BREAK_7 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_7.png")), BREAK_STAGES);
			toList(BREAK_8 = ImageIO.read(Game.class.getResource("/textures/block/destroy_stage_8.png")), BREAK_STAGES);
			
			PLAYER_INVENTORY_GUI_IMAGE = ImageIO.read(Game.class.getResource("/textures/gui/container/inventory.png"));
			PLAYER_INVENTORY_GUI = PLAYER_INVENTORY_GUI_IMAGE.getSubimage(0, 0, 176, 166);
			PLAYER_INVENTORY_EFFECT = PLAYER_INVENTORY_GUI_IMAGE.getSubimage(0, 166, 120, 31);
			PLAYER_INVENTORY_RECIPE_BOOK = PLAYER_INVENTORY_GUI_IMAGE.getSubimage(178, 0, 20, 18);
			PLAYER_INVENTORY_RECIPE_BOOK_BLUE = PLAYER_INVENTORY_GUI_IMAGE.getSubimage(178, 19, 20, 18);
			
			CRAFTING_TABLE_GUI_IMAGE = ImageIO.read(Game.class.getResource("/textures/gui/container/crafting_table.png"));
			CRAFTING_TABLE_GUI = CRAFTING_TABLE_GUI_IMAGE.getSubimage(0, 0, 176, 166);

			SLOT_OFFHAND = ImageIO.read(Game.class.getResource("/textures/item/empty_armor_slot_shield.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			SLOT_HELMET = ImageIO.read(Game.class.getResource("/textures/item/empty_armor_slot_helmet.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			SLOT_CHESTPLATE = ImageIO.read(Game.class.getResource("/textures/item/empty_armor_slot_chestplate.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			SLOT_LEGGINGS = ImageIO.read(Game.class.getResource("/textures/item/empty_armor_slot_leggings.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			SLOT_BOOTS = ImageIO.read(Game.class.getResource("/textures/item/empty_armor_slot_boots.png")).getScaledInstance(32, 32, Image.SCALE_FAST);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void toList(Image img, List<Image> list) {
		list.add(img);
	}
}
