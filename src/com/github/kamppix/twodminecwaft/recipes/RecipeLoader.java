package com.github.kamppix.twodminecwaft.recipes;

import org.json.*;

import com.github.kamppix.twodminecwaft.items.Item;
import com.github.kamppix.twodminecwaft.items.ItemStack;
import com.github.kamppix.twodminecwaft.items.ItemType;
import com.github.kamppix.twodminecwaft.util.JSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RecipeLoader {
	
	public static void loadRecipes() {
		try (Stream<Path> paths = Files.walk(Paths.get("res/data/recipes"))) {
		    paths
		        .filter(Files::isRegularFile)
		        .forEach(RecipeLoader::createRecipe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void createRecipe(Path path) {
		try {
			JSONObject obj = JSON.pathToObject(path.toString());
			Map<String, Object> jsonMap = JSON.jsonToMap(obj);
			
			String type = (String) jsonMap.get("type");
			if (type.contains(":")) type = type.substring(type.indexOf(58) + 1);
			
			String group = (String) jsonMap.get("group");
			
			if (type.matches("crafting_shapeless")) {
				List<Object> ingredientStrings = (List<Object>) jsonMap.get("ingredients");
				List<Object> ingredients = new ArrayList<>();
				
				for (Object item : ingredientStrings) {
					if (item instanceof ArrayList<?>) {
						List<Item> list = new ArrayList<>();
						
						for (Map<String, String> map : (List<HashMap<String, String>>) item) {
							String itemTypeLong;
							if (map.containsKey("item")) itemTypeLong = (String) map.get("item");
							else return;
							
							String itemType;
							
							if (itemTypeLong.contains(":")) itemType = itemTypeLong.substring(itemTypeLong.indexOf(58) + 1);
							else itemType = itemTypeLong;
							
							if (ItemType.getById(itemType) == null) return;
							list.add(ItemType.getById(itemType));
						}
						
						ingredients.add(list);
					} else {
						Map<String, String> map = (HashMap<String, String>) item;
						String itemTypeLong;
						if (map.containsKey("item")) itemTypeLong = (String) map.get("item");
						else return;
						
						String itemType;
						
						if (itemTypeLong.contains(":")) itemType = itemTypeLong.substring(itemTypeLong.indexOf(58) + 1);
						else itemType = itemTypeLong;
						
						if (ItemType.getById(itemType) == null) return;
						ingredients.add(ItemType.getById(itemType));
					}
					
				}

				Map<String, Object> resultMap = (Map<String, Object>) jsonMap.get("result");
				ItemStack result;
				
				if (resultMap.containsKey("item")) {
					String resultTypeLong = (String) resultMap.get("item");
					String resultType;
					if (resultTypeLong.contains(":")) resultType = resultTypeLong.substring(resultTypeLong.indexOf(58) + 1);
					else resultType = resultTypeLong;
					
					if (resultMap.containsKey("count")) {
						result = new ItemStack(ItemType.getById(resultType), (Integer) resultMap.get("count"));
					} else {
						result = new ItemStack(ItemType.getById(resultType));
					}
					
					if (result.getType() != null) {
						System.out.println("New recipe: " + path.toString());
						Recipe.LIST.add(new ShapelessRecipe(group, ingredients, result));
					}
				}
			} else if (type.matches("crafting_shaped")) {
				List<String> pattern = (List<String>) jsonMap.get("pattern");
				Map<Character, Object> key = (Map<Character, Object>) jsonMap.get("key");
				Map<String, Object> resultMap = (Map<String, Object>) jsonMap.get("result");
				ItemStack result;
				
				if (resultMap.containsKey("item")) {
					String resultTypeLong = (String) resultMap.get("item");
					String resultType;
					if (resultTypeLong.contains(":")) resultType = resultTypeLong.substring(resultTypeLong.indexOf(58) + 1);
					else resultType = resultTypeLong;
					
					if (resultMap.containsKey("count")) {
						result = new ItemStack(ItemType.getById(resultType), (Integer) resultMap.get("count"));
					} else {
						result = new ItemStack(ItemType.getById(resultType));
					}
					
					if (result.getType() != null) {
						System.out.println("New recipe: " + path.toString());
						Recipe.LIST.add(new ShapedRecipe(group, pattern, key, result));
					}
				}
			} else if (type.matches("smelting")) {
			
			} else if (type.matches("blasting")) {
			
			} else if (type.matches("smoking")) {
			
			} else if (type.matches("campfire_cooking")) {
			
			} else if (type.matches("stonecutting")) {
				
			} else if (type.matches("smithing")) {
				
			} else if (type.matches("crafting_special_armordye")) {
			} else if (type.matches("crafting_special_bannerduplicate")) {
			} else if (type.matches("crafting_special_bookcloning")) {
			} else if (type.matches("crafting_special_firework_rocket")) {	
			} else if (type.matches("crafting_special_firework_star")) {
			} else if (type.matches("crafting_special_firework_star_fade")) {
			} else if (type.matches("crafting_special_mapcloning")) {
			} else if (type.matches("crafting_special_mapextending")) {
			} else if (type.matches("crafting_special_repairitem")) {
			} else if (type.matches("crafting_special_shielddecoration")) {
			} else if (type.matches("crafting_special_shulkerboxcoloring")) {
			} else if (type.matches("crafting_special_suspiciousstew")) {
			} else if (type.matches("crafting_special_tippedarrow")) {
			} else {
				System.out.println("ERROR: Failed to load recipe '" + path.toString() + "'");
				System.out.println(type);
			}
			
			
//			if result = new ItemStack(ItemType.getById());
//			result.setCount(jsonObject.getAsJsonArray("result").getAsJsonObject().get("count").getAsInt());
			
//			if () System.out.println(type + " " + result.getType().getName());
//			Recipe.LIST.add(new Recipe(null, group, result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
