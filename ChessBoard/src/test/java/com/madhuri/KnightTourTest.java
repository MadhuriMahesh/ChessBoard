package com.madhuri;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class KnightTourTest {

	private KnightTour knightTour;
	private Board board;

	@Test
	public void verifyKnightTour() throws Exception {
		board = new Board(8);
		knightTour = new KnightTour(board);

		boolean traverseStatus = knightTour.traverse();
		// Traverse status check
		assertTrue("Failed to traverse", traverseStatus);

		int[][] result = board.getChessBoard();
		// Assert first position is 0
		assertEquals(0, result[0][0]);

		Set<Integer> uniqueValue = new HashSet<Integer>();
		// Find if there are any duplicate move positions
		for (int i = 0; i < board.getBoardSize(); i++) {
			for (int j = 0; j < board.getBoardSize(); j++) {
				assertTrue("Duplicate move positions",
						uniqueValue.add(board.getChessBoard()[i][j]));
			}
		}

		// Verify all positions are moved corretly
		ArrayList<Integer> resultPos = new ArrayList<Integer>(uniqueValue);
		Collections.sort(resultPos);
		for (int i = 0; i < board.getBoardSize(); i++) {
			assertEquals("Move positions are incorrect", i, resultPos.get(i)
					.intValue());
		}
		knightTour.displayResults();
	}

	@Test
	public void failedToGenerateForSmallBoards() throws Exception {
		board = new Board(4);
		knightTour = new KnightTour(board);

		boolean traverseStatus = knightTour.traverse();
		// Traverse status check
		assertFalse("Board is correct and traversing.", traverseStatus);

	}
}
