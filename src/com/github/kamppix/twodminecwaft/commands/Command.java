package com.github.kamppix.twodminecwaft.commands;

import com.github.kamppix.twodminecwaft.Player;
import com.github.kamppix.twodminecwaft.items.ItemStack;
import com.github.kamppix.twodminecwaft.items.ItemType;
import com.github.kamppix.twodminecwaft.tiles.Tiles;
import com.github.kamppix.twodminecwaft.world.World;

public class Command {
	
	World world;
	Player player;
	
	public Command(World world, Player player) {
		this.world = world;
		this.player = player;
	}
	
	public void handle(String input) {
		String command = null;
		String args = null;
		
		if (input.startsWith("/")) {
			if (input.contains(" ")) {
				command = input.substring(0, input.indexOf(" "));
				if (input.indexOf(" ") != input.length()) {
					args = input.substring(input.indexOf(" ") + 1, input.length());
				}
			} else command = input.substring(0, input.length());
		} else return;
		
		if (command.matches("/give")) {
			giveCommand(args);
			return;
		}
		if (command.matches("/clear")) {
			clearCommand(args);
			return;
		}
		if (command.matches("/settile")) {
			setTileCommand(args);
			return;
		}
		System.out.println("Invalid command '" + command + "'");
	}
	
	private void giveCommand(String args) {
		String id = null;
		int count = 1;
		
		if (args == null || args.isEmpty()) {
			System.out.println("Usage: '/give <item> [<count>]'");
			return;
		}
		
		if (args.contains(" ")) {
			id = args.substring(0, args.indexOf(32));
			
			if (isNNInteger(args.substring(args.indexOf(32) + 1))) {
				count = Integer.parseInt(args.substring(args.indexOf(32) + 1));
			} else {
				System.out.println("Expected non-negative integer for field 'count'");
				return;
			}
		} else {
			id = args;
		}
		
		if (ItemType.getById(id) != null) {
			player.getInv().addItem(new ItemStack(ItemType.getById(id), count));
			System.out.println("Gave " + count + " [" + ItemType.getById(id).getName() + "] to " + player.getName());
		} else {
			System.out.println("Unknown item '" + id + "'");
		}
	}
	
	private void clearCommand(String args) {
		String id = null;
		int count = 0;
		int maxCount = -1;
		
		if (args == null || args.isEmpty()) {
			for (int i = 0; i < 36; i++) {
				if (player.getInv().getItems().get(i) != null) {
					count += player.getInv().getItems().get(i).getCount();
					player.getInv().setItemCount(i, 0);
				}
			}
		}
		
		if (args != null && !args.isEmpty() && args.contains(" ")) {
			id = args.substring(0, args.indexOf(32));
			
			if (isNNInteger(args.substring(args.indexOf(32) + 1))) {
				maxCount = Integer.parseInt(args.substring(args.indexOf(32) + 1));
			} else {
				System.out.println("Expected non-negative integer for field 'maxCount'");
				return;
			}
		} else {
			id = args;
		}
		
		if (id != null && !id.isEmpty() && ItemType.getById(id) != null) {
			for (int i = 0; i < 36; i++) {
				if (player.getInv().getItems().get(i) != null && player.getInv().getItems().get(i).getType() == ItemType.getById(id)) {
					if (maxCount == -1) {
						count += player.getInv().getItems().get(i).getCount();
						player.getInv().setItemCount(i, 0);
					} else {
						for (;;) {
							if (count < maxCount && player.getInv().getItems().get(i) != null) {
								player.getInv().decreaseItemCount(i);
								count++;
							} else break;
						}
					}
				}
			}
		} else {
			if (id != null && !id.isEmpty()) {
				System.out.println("Unknown item '" + id + "'");
				return;
			}
		}
		
		if (count > 0) {
			System.out.println("Removed " + count + " items from player " + player.getName());
		} else {
			System.out.println("No items were found on player " + player.getName());
		}
	}
	
	private void setTileCommand(String args) {
		if (args == null || args.isEmpty() || !args.contains(" ")) {
			System.out.println("Usage: '/settile <x> <y> <tile>'");
			return;
		}
		
		int x;
		int y;
		
		if (isInteger(args.substring(0, args.indexOf(32)))) {
			x = Integer.parseInt(args.substring(0, args.indexOf(32)));
			System.out.println(x);
		} else {
			System.out.println("Expected integer for field 'x'");
			return;
		}
		
		args = args.replaceFirst(args.substring(0, args.indexOf(32) + 1), "");
		System.out.println(args);
		
		if (isInteger(args.substring(0, args.indexOf(32)))) {
			y = Integer.parseInt(args.substring(0, args.indexOf(32)));
			System.out.println(y);
		} else {
			System.out.println("Expected integer for field 'y'");
			return;
		}
		
		args = args.replaceFirst(args.substring(0, args.indexOf(32) + 1), "");
		
		String id = args;
		System.out.println(id);
		
		if (id.contains(" ")) {
			if (id.indexOf(32) != id.length() - 1) {
				System.out.println("Usage: '/settile <x> <y> <tile>'");
				return;
			} else {
				id.replace(" ", "");
			}
		}
		
		if (Tiles.getById(id) != null) {
			world.setTile(x, y, Tiles.getById(id), false);
			System.out.println("Changed the tile at " + x + ", " + y);
		} else {
			System.out.println("Unknown tile type '" + id + "'");
		}
	}
	
	public boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
	
	public boolean isNNInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    for (int i = 0; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}
}
