package com.kamppi.testgame.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kamppi.testgame.items.ItemStack;
import com.kamppi.testgame.util.Vector2f;

public class Inventory {

	private HashMap<Integer, ItemStack> ITEMS;
	private final HashMap<Integer, ItemSlot> SLOTS;
	private final List<ItemSlot> SLOT_LIST;
	
	private final int size;
	
	public Inventory(int size) {
		this.size = size;
		
		ITEMS = new HashMap<>();
		SLOTS = new HashMap<>();
		SLOT_LIST = new ArrayList<>();
		
		initSlots();
	}
	
	protected void initSlots() {

	}
	
	protected void addSlot(int index, ItemSlotType type, Vector2f pos) {
		ItemSlot slot = new ItemSlot(type, index, pos);
		SLOT_LIST.add(slot);
		SLOTS.put(index, slot);
	}
	
	public void addItem(ItemStack item, int slot) {
		ITEMS.put(slot, item.setSlot(SLOTS.get(slot)));
	}
	
	public void addItem(ItemStack item) {
		int startIndex = SLOT_LIST.get(0).getIndex();
		int maxCount = item.getType().getMaxCount();
		
		for (int i = startIndex; i < startIndex + size; i++) {
			if (ITEMS.containsKey(i)) {
				if (ITEMS.get(i).getType() == item.getType() && ITEMS.get(i).getCount() < maxCount) {
					
					item.setCount(item.getCount() - maxCount + ITEMS.get(i).getCount());
					ITEMS.get(i).setCount(maxCount);
					
					if (item.getCount() < 0) {
						ITEMS.get(i).setCount(ITEMS.get(i).getCount() + item.getCount());
					}
				}
			}
		}
		
		if (item.getCount() <= 0) {
			return;
		}
		
		for (;;) {
			if (item.getCount() > maxCount) {
				item.setCount(item.getCount() - maxCount);
				addItem(new ItemStack(item.getType(), maxCount));
			} else break;	
		}
		
		for (int i = startIndex; i < startIndex + size; i++) {
			if (ITEMS.get(i) == null) {
				ITEMS.put(i, item.setSlot(SLOTS.get(i)));
				break;
			}
		}
	}
	
	public void decreaseItemCount(int i) {
		ITEMS.get(i).decreaseCount();
		if (ITEMS.get(i).getCount() <= 0) ITEMS.remove(i);
	}
	
	public void setItemCount(int i, int count) {
		ITEMS.get(i).setCount(count);
		if (ITEMS.get(i).getCount() <= 0) ITEMS.remove(i);
	}
	
	public HashMap<Integer, ItemStack> getItems() {
		return ITEMS;
	}
	
	public HashMap<Integer, ItemSlot> getSlots() {
		return SLOTS;
	}

	public List<ItemSlot> getSlotList() {
		return SLOT_LIST;
	}
	
	public void setItems(HashMap<Integer, ItemStack> ITEMS) {
		this.ITEMS = ITEMS;
	}
}
