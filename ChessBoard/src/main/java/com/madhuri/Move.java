package com.madhuri;

/**
 * Created by SYSTEM on 23/10/2016.
 */
public enum Move {

	DOWNLEFT(2, -1), DOWNRIGHT(2, 1), LEFTDOWN(1, -2), RIGHTDOWN(1, 2), LEFTUP(
			-1, -2), RIGHTUP(-1, 2), UPLEFT(-2, -1), UPRIGHT(-2, 1);

	private int x;
	private int y;

	Move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
