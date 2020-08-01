package com.github.kamppix.twodminecraft.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.kamppix.twodminecraft.inventory.Inventory;
import com.github.kamppix.twodminecraft.items.ItemStack;

public class Recipe {
	
	public static List<Recipe> LIST = new ArrayList<>();

	public static List<Recipe> getList() {
		return LIST;
	}
	
	private final String group;
	
	public Recipe(String group) {
		this.group = group;
		LIST.add(this);
	}

	public String getGroup() {
		return group;
	}

	public ItemStack getResult() {
		return null;
	}

	public List<Object> getIngredients() {
		return null;
	}

	public List<String> getPattern() {
		return null;
	}

	public Map<Character, Object> getKey() {
		return null;
	}

	public ItemStack getBase() {
		return null;
	}

	public ItemStack getAddition() {
		return null;
	}

	public ItemStack getIngredient() {
		return null;
	}

	public int getCount() {
		return 1;
	}

	public double getExperience() {
		return 0;
	}

	public int getCookingTime() {
		return 0;
	}

	public boolean canCraft(Inventory inv) {
		return false;
	}
}
