package com.madhuri;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Madhuri on 23/10/2016.
 */
public class KnightTour {

	private final Board board;
	private int route = 0;
	private final List<Move> moves = Arrays.asList(Move.values());

	KnightTour(Board board) {
		this.board = board;
	}

	public boolean traverse() {
		return jump(0, new Point(0, 0));
	}

	private boolean jump(int index, Point point) {
		int boardSize = board.getBoardSize();
		if (!board.isPointCalculated(point)) {
			return false;
		}

		board.updatePoint(point, route++);

		if (index == boardSize * boardSize - 1) {
			return true;
		}

		for (Move move : moves) {
			int x = point.getX() + (move.getX());
			int y = point.getY() + (move.getY());

			Point newPoint = new Point(x, y);
			if (newPoint.isValid(boardSize) && jump(index + 1, newPoint)) {
				return true;
			}
		}
		board.updatePoint(point, 0);
		route--;
		return false;
	}

	public void displayResults() {
		System.out.println("\n................BORARD MOVES............\n");
		DecimalFormat twodigits = new DecimalFormat("00");
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				System.out.print("   "
						+ twodigits.format(board.getChessBoard()[i][j]));
			}
			System.out.println();
		}
		System.out.println("\n.........................................\n");
	}

	public static void main(String[] args) {
		int boardSize = 8;
		KnightTour tour = new KnightTour(new Board(boardSize));
		if (tour.traverse()) {
			tour.displayResults();
		} else {
			System.out.println("FAILED TO FIND");
		}
	}
}
