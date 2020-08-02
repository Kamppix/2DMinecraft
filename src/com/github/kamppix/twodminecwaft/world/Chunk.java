package com.github.kamppix.twodminecwaft.world;

import java.util.ArrayList;
import java.util.List;

import com.github.kamppix.twodminecwaft.entities.Entity;
import com.github.kamppix.twodminecwaft.tiles.Tile;

public class Chunk {
	private final int x;
	private final World world;
	
	public Chunk(int x, World world) {
		this.x = x;
		this.world = world;
	}

	private Tile[] TILES = new Tile[65536];
	
	public void setTile(int x, int y, Tile tile) {
		if (y < 0 || y > 255) return;
		if (x < 0 || x > 255) {
			world.setTile(this.x * 256 + x, y, tile, false);
		}
		int i = x + y * 256;
		TILES[i] = tile;
	}
	
	public Tile getTile(int x, int y) {
		if (y < 0 || y > 255) return null;
		if (x < 0 || x > 255) {
			world.getTile(this.x * 256 + x, y, false);
		}
		int i = x + y * 256;
		return TILES[i];
	}

	private Tile[] WALL_TILES = new Tile[65536];
	
	public void setWallTile(int x, int y, Tile tile) {
		if (y < 0 || y > 255) return;
		if (x < 0 || x > 255) {
			world.setTile(this.x * 256 + x, y, tile, true);
		}
		int i = x + y * 256;
		WALL_TILES[i] = tile;
	}
	
	public Tile getWallTile(int x, int y) {
		if (y < 0 || y > 255) return null;
		if (x < 0 || x > 255) {
			world.getTile(this.x * 256 + x, y, true);
		}
		int i = x + y * 256;
		return WALL_TILES[i];
	}
	
	public int getX() {
		return x;
	}
	
	private List<Entity> ENTITIES = new ArrayList<>();
	
	public void addEntity(Entity entity) {
		ENTITIES.add(entity);
	}
	
	public void removeDeadEntities() {
		for (Entity e : ENTITIES) {
			if (e.getDead()) {
				ENTITIES.remove(e);
			}
		}
	}
}
