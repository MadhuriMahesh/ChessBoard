package com.madhuri;

/**
 * Created by SYSTEM on 23/10/2016.
 */
public class Point {

	private final int x;
	private final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isValid(int boradSize) {
		return (x >= 0 && y >= 0 && x < boradSize && y < boradSize);
	}

}
