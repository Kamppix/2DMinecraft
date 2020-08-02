package com.github.kamppix.twodminecwaft.tiles;

public class CollisionType {
	
	public static final CollisionType PASS_THROUGH = new CollisionType(false);
	public static final CollisionType FULL_TILE = new CollisionType(true);
	
	private final boolean solid;
	
	public CollisionType(boolean solid) {
		this.solid = solid;
	}
	
	public boolean isSolid() {
		return solid;
	}
}
