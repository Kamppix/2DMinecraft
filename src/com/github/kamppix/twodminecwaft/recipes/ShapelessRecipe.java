package com.github.kamppix.twodminecwaft.recipes;

import java.util.ArrayList;
import java.util.List;

import com.github.kamppix.twodminecwaft.inventory.BigCraftingGrid;
import com.github.kamppix.twodminecwaft.inventory.Inventory;
import com.github.kamppix.twodminecwaft.inventory.SmallCraftingGrid;
import com.github.kamppix.twodminecwaft.items.Item;
import com.github.kamppix.twodminecwaft.items.ItemStack;

public class ShapelessRecipe extends Recipe {
	
	private List<Object> ingredients;
	private ItemStack result;

	public ShapelessRecipe(String group, List<Object> ingredients, ItemStack result) {
		super(group);
		this.ingredients = ingredients;
		this.result = result;
	}

	public List<Object> getIngredients() {
		return ingredients;
	}

	public ItemStack getResult() {
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public boolean canCraft(Inventory inv) {
		if (inv instanceof SmallCraftingGrid && ingredients.size() < 5) {
			
			List<ItemStack> slotItems = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				if (inv.getItems().get(37 + i) != null) {
					slotItems.add(inv.getItems().get(37 + i));
				}
			}
			
			notPossible:
			for (Object obj : ingredients) {
				if (obj instanceof Item) {
					if (!removeItem(slotItems, obj)) break;
				} else if (obj instanceof ArrayList<?>) {
					List<Item> list = (ArrayList<Item>) obj;
					for (Item item : list) {
						if (removeItem(slotItems, item)) break;
						else if (list.indexOf(item) == list.size() - 1) break notPossible;
					}
				}
				
				if (ingredients.indexOf(obj) == ingredients.size() - 1 && slotItems.size() == 0) return true;
			}
			
		} else if (inv instanceof BigCraftingGrid && ingredients.size() < 10) {
			
		}
		
		return false;
	}

	private boolean removeItem(List<ItemStack> slotItems, Object obj) {
		for (ItemStack item : slotItems) {
			if (item.getType() == obj) {
				slotItems.remove(item);
				return true;
			}
		}
		return false;
	}
}
