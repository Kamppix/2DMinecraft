package com.github.kamppix.twodminecwaft.recipes;

import java.util.List;
import java.util.Map;

import com.github.kamppix.twodminecwaft.inventory.BigCraftingGrid;
import com.github.kamppix.twodminecwaft.inventory.Inventory;
import com.github.kamppix.twodminecwaft.inventory.SmallCraftingGrid;
import com.github.kamppix.twodminecwaft.items.ItemStack;

public class ShapedRecipe extends Recipe {
	
	private List<String> pattern;
	private Map<Character, Object> key;
	private ItemStack result;

	public ShapedRecipe(String group, List<String> pattern, Map<Character, Object> key, ItemStack result) {
		super(group);
		this.pattern = pattern;
		this.key = key;
		this.result = result;
	}

	public boolean canCraft(Inventory inv) {
//		if (inv instanceof SmallCraftingGrid && pattern.size() <= 2) {
//			
//			for (String s : pattern) {
//				if (s.length() > 2) return false;
//				
//				for (int i = 0; i < 2; ) {
//					key.get(s.charAt(i));
//				}
//			}
//			
//			
//		} else if (inv instanceof BigCraftingGrid && pattern.size() <= 3) {
//			
//		}
		
		return false;
	}
	
	public List<String> getPattern() {
		return pattern;
	}

	public Map<Character, Object> getKey() {
		return key;
	}

	public ItemStack getResult() {
		return result;
	}
}
