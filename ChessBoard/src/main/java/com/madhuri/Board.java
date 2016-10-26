package com.madhuri;

public class Board {

	private final int boardSize;
	private final int[][] chessBoard;

	Board(int size) {
		boardSize = size;
		chessBoard = new int[getBoardSize()][getBoardSize()];
	}

	public int[][] getChessBoard() {
		return chessBoard;
	}

	public boolean isPointCalculated(Point point) {
		return (chessBoard[point.getX()][point.getY()] == 0);
	}

	public void updatePoint(Point point, int value) {
		chessBoard[point.getX()][point.getY()] = value;
	}

	public int getBoardSize() {
		return boardSize;
	}

}
