package com.github.kamppix.twodminecraft.inventory;

import java.awt.Image;

import com.github.kamppix.twodminecraft.graphics.Textures;

public class ItemSlotType {

	public static final ItemSlotType GENERIC = new ItemSlotType(null);
	public static final ItemSlotType OFFHAND = new ItemSlotType(Textures.SLOT_OFFHAND);
	public static final ItemSlotType ARMOR_HELMET = new ItemSlotType(Textures.SLOT_HELMET);
	public static final ItemSlotType ARMOR_CHESTPLATE = new ItemSlotType(Textures.SLOT_CHESTPLATE);
	public static final ItemSlotType ARMOR_LEGGINGS = new ItemSlotType(Textures.SLOT_LEGGINGS);
	public static final ItemSlotType ARMOR_BOOTS = new ItemSlotType(Textures.SLOT_BOOTS);
	
	public static final ItemSlotType RESULT = new ItemSlotType(null);

	public final Image img;
	
	public ItemSlotType(Image img) {
		this.img = img;
	}
	
	public Image getImage() {
		return img;
	}
}
