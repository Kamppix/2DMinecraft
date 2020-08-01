package com.github.kamppix.twodminecraft.util;

public class Vector2d {

	public double x;
	public double y;
	
	public static double worldX;
	public static double worldY;
	
	public Vector2d() {
		x = 0;
		y = 0;
	}
	
	public Vector2d(Vector2d vec) {
		new Vector2d(vec.x, vec.y);
	}

	public Vector2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void addX(double f) {x += f;}
	public void addY(double f) {y += f;}

	public void setX(double f) {x = f;}
	public void setY(double f) {y = f;}
	
	public void setVector(Vector2d vec) {
		this.x  = vec.x;
		this.y  = vec.y;
	}
	
	public void setVector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return x + ", " + y;
	}
}
