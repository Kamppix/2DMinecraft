package com.github.kamppix.twodminecwaft.items;

import java.util.ArrayList;
import java.util.List;

public class ItemTag {

	public static final List<ItemTag> ITEM_TAG_REGISTRY = new ArrayList<>();
	
	private static ItemTag register(ItemTag t) {
		ITEM_TAG_REGISTRY.add(t);
		return t;
	}
	
	public static ItemTag getById(String id) {
		for (ItemTag t : ITEM_TAG_REGISTRY) {
			if (t.getId().equals(id)) return t;
		}
		return null;
	}
	
	private String id;
	private List<ItemType> items;
	
	public ItemTag(String id, List<ItemType> items) {
		this.id = id;
		this.items = items;
	}
	
	public String getId() {
		return id;
	}
}
