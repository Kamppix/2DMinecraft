package com.kamppi.testgame.world;

import java.util.Random;

import com.kamppi.testgame.tiles.Tiles;

public class WorldGenerator {
	
	private Random rng;
	
	private float smAmpl = 1.1f;
	private float smLength = 30f;
	private float medAmpl = 5f;
	private float medLengthA = 100f;
	private float medLengthB = 19.5f;
	private float lgAmpl = 20f;
	private float lgLength = 500f;
	
	public WorldGenerator(int seed) {
		this.rng = new Random(seed);
	}
	
	public void generateChunk(World world, Chunk chunk) {

		int worldX = chunk.getX() * 256;
		Random tileRng = new Random((long) (2 * smAmpl * Math.sin((worldX + worldX)/smLength)
				+ 2 * medAmpl * Math.sin((worldX + worldX)/medLengthA) * Math.sin((worldX + worldX)/medLengthB)
				+ 2 * lgAmpl * Math.sin((worldX + worldX)/lgLength)));
		
		for (int chunkX = 0; chunkX < 256; chunkX++) {
			
			int y = (int) (64f + 
					+ 2 * smAmpl * Math.sin((worldX + chunkX)/smLength)
					+ 2 * medAmpl * Math.sin((worldX + chunkX)/medLengthA) * Math.sin((worldX + chunkX)/medLengthB)
					+ 2 * lgAmpl * Math.sin((worldX + chunkX)/lgLength)
					);
			
			groundLayer(world, chunk, chunkX, y);
			
			if (tileRng.nextFloat() < 0.5) {
				foliage(world, chunk, worldX, chunkX, y);
			}
		}
	}
	
	public void groundLayer(World world, Chunk chunk, int x, int y) {
		chunk.setTile(x, 0, Tiles.BEDROCK);
		
		if (rng.nextFloat() < 0.9) chunk.setTile(x, 1, Tiles.BEDROCK);
			else chunk.setTile(x, 1, Tiles.STONE);
		if (rng.nextFloat() < 0.6) chunk.setTile(x, 2, Tiles.BEDROCK);
			else chunk.setTile(x, 2, Tiles.STONE);
		if (rng.nextFloat() < 0.5) chunk.setTile(x, 3, Tiles.BEDROCK);
			else chunk.setTile(x, 3, Tiles.STONE);
		if (rng.nextFloat() < 0.4) chunk.setTile(x, 4, Tiles.BEDROCK);
			else chunk.setTile(x, 4, Tiles.STONE);
		
		for (int i = y; i > 4; i--) {
			if (i == y) chunk.setTile(x, i, Tiles.GRASS_BLOCK);
			else if (i == y - 1) chunk.setTile(x, i, Tiles.DIRT);
			else if (i == y - 2) chunk.setTile(x, i, Tiles.DIRT);
			else if (i == y - 3) chunk.setTile(x, i, Tiles.DIRT);
			else chunk.setTile(x, i, Tiles.STONE);
		}
	}
	
	public void foliage(World world, Chunk chunk, int worldX, int x, int y) {
		int i = (int) ( 
				+ 2 * smAmpl * Math.sin((worldX + x)/smLength)
				+ 2 * medAmpl * Math.sin((worldX + x)/medLengthA) * Math.sin((worldX + x)/medLengthB)
				+ 2 * lgAmpl * Math.sin((worldX + x)/lgLength)
				);
//		System.out.println(i);
		if (i < 0) chunk.setTile(x, y + 1, Tiles.GRASS);
		else {
			chunk.setTile(x, y + 1, Tiles.TALL_GRASS_BOTTOM);
			chunk.setTile(x, y + 2, Tiles.TALL_GRASS_TOP);
		}
	}
	
	public void tree(World world, Chunk chunk, int x, int y) {
		chunk.setTile(x, y, Tiles.DIRT);
		int i = rng.nextInt(6);
		if (i == 0) oakTree(world, chunk, x, y);
		if (i == 1) birchTree(world, chunk, x, y);
		if (i == 2) spruceTree(world, chunk, x, y);
		if (i == 3) jungleTree(world, chunk, x, y);
		if (i == 4) oakTree(world, chunk, x, y);
		if (i == 5) birchTree(world, chunk, x, y);
	}
	
	public void oakTree(World world, Chunk chunk, int x, int y) {
		int trunkHeight = rng.nextInt(3) + 4;
		for (int i = trunkHeight; i > 0; i--) {
			chunk.setTile(x, y + i, Tiles.OAK_LOG);
		}
		chunk.setTile(x - 2, y + trunkHeight - 2, Tiles.OAK_LEAVES);
		chunk.setTile(x - 2, y + trunkHeight - 1, Tiles.OAK_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 2, Tiles.OAK_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 1, Tiles.OAK_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight, Tiles.OAK_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight + 1, Tiles.OAK_LEAVES);
		chunk.setTile(x, y + trunkHeight + 1, Tiles.OAK_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 2, Tiles.OAK_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 1, Tiles.OAK_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight, Tiles.OAK_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight + 1, Tiles.OAK_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 2, Tiles.OAK_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 1, Tiles.OAK_LEAVES);
	}
	
	public void birchTree(World world, Chunk chunk, int x, int y) {
		int trunkHeight = rng.nextInt(3) + 5;
		for (int i = trunkHeight; i > 0; i--) {
			chunk.setTile(x, i + y, Tiles.BIRCH_LOG);
		}
		chunk.setTile(x - 2, y + trunkHeight - 2, Tiles.BIRCH_LEAVES);
		chunk.setTile(x - 2, y + trunkHeight - 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 2, Tiles.BIRCH_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight, Tiles.BIRCH_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight + 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x, y + trunkHeight + 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 2, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight + 1, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 2, Tiles.BIRCH_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 1, Tiles.BIRCH_LEAVES);
	}
	
	public void spruceTree(World world, Chunk chunk, int x, int y) {
		int trunkHeight = rng.nextInt(1) + 4;
		for (int i = trunkHeight; i > 0; i--) {
			chunk.setTile(x, i + y, Tiles.SPRUCE_LOG);
		}
		chunk.setTile(x - 2, y + trunkHeight - 2, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 2, y + trunkHeight, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 2, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 1, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight + 1, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight + 3, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x, y + trunkHeight + 1, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x, y + trunkHeight + 2, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x, y + trunkHeight + 3, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight + 3, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight + 1, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 1, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 2, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight, Tiles.SPRUCE_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 2, Tiles.SPRUCE_LEAVES);
	}
	
	public void jungleTree(World world, Chunk chunk, int x, int y) {
		int trunkHeight = rng.nextInt(7) + 6;
		for (int i = trunkHeight; i > 0; i--) {
			chunk.setTile(x, i + y, Tiles.JUNGLE_LOG);
		}
		chunk.setTile(x - 2, y + trunkHeight - 2, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x - 2, y + trunkHeight - 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 2, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight - 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x - 1, y + trunkHeight + 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x, y + trunkHeight + 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 2, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight - 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 1, y + trunkHeight + 1, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 2, Tiles.JUNGLE_LEAVES);
		chunk.setTile(x + 2, y + trunkHeight - 1, Tiles.JUNGLE_LEAVES);
	}
}
