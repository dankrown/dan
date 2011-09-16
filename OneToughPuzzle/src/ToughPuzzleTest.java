import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ToughPuzzleTest {

	ToughPuzzle puzzle;
	
	@Before
	public void setUp() throws Exception {
		puzzle = new ToughPuzzle();
	}
	
	private void assertPieceIsRotated(PuzzlePiece puzzlePiece, int orientation) {

		assertEquals("Puzzle piece is not rotated correctly: " + puzzlePiece.getPieceIndex(), 
				orientation, puzzlePiece.getOrientation());		
	}
	
	@Test
	public void testAdjustRowPuzzle() {

		puzzle.adjustRowPuzzle("012345678", "001");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 0);
		assertPieceIsRotated(puzzle.piece[3], 0);
		assertPieceIsRotated(puzzle.piece[4], 0);
		assertPieceIsRotated(puzzle.piece[5], 0);
		assertPieceIsRotated(puzzle.piece[6], 1);
		assertPieceIsRotated(puzzle.piece[7], 1);
		assertPieceIsRotated(puzzle.piece[8], 1);
		
	}

	

	@Test
	public void testAdjustRowPuzzleBack() {

		puzzle.adjustRowPuzzle("012345678", "011");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 0);
		assertPieceIsRotated(puzzle.piece[3], 1);
		assertPieceIsRotated(puzzle.piece[4], 1);
		assertPieceIsRotated(puzzle.piece[5], 1);
		assertPieceIsRotated(puzzle.piece[6], 1);
		assertPieceIsRotated(puzzle.piece[7], 1);
		assertPieceIsRotated(puzzle.piece[8], 1);
		puzzle.adjustRowPuzzleBack("012345678", "011");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 0);
		assertPieceIsRotated(puzzle.piece[3], 0);
		assertPieceIsRotated(puzzle.piece[4], 0);
		assertPieceIsRotated(puzzle.piece[5], 0);
		assertPieceIsRotated(puzzle.piece[6], 0);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 0);
	}
	
	@Test
	public void testAdjustColPuzzle1() {

		puzzle.adjustColPuzzle("012345678", "001", "000");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 3);
		assertPieceIsRotated(puzzle.piece[3], 0);
		assertPieceIsRotated(puzzle.piece[4], 0);
		assertPieceIsRotated(puzzle.piece[5], 3);
		assertPieceIsRotated(puzzle.piece[6], 0);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 3);
	}
	
	@Test
	public void testAdjustColPuzzle2() {

		puzzle.adjustColPuzzle("012345678", "101", "000");
		assertPieceIsRotated(puzzle.piece[0], 3);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 3);
		assertPieceIsRotated(puzzle.piece[3], 3);
		assertPieceIsRotated(puzzle.piece[4], 0);
		assertPieceIsRotated(puzzle.piece[5], 3);
		assertPieceIsRotated(puzzle.piece[6], 3);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 3);

	}
	
	@Test
	public void testAdjustColPuzzle3() {

		puzzle.adjustRowPuzzle("012345678", "010");
		puzzle.adjustColPuzzle("012345678", "101", "010");
		assertPieceIsRotated(puzzle.piece[0], 3);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 3);
		assertPieceIsRotated(puzzle.piece[3], 2);
		assertPieceIsRotated(puzzle.piece[4], 1);
		assertPieceIsRotated(puzzle.piece[5], 2);
		assertPieceIsRotated(puzzle.piece[6], 3);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 3);
	}
	
	@Test
	public void testAdjustColPuzzleBack() {

		puzzle.adjustRowPuzzle("012345678", "010");
		puzzle.adjustColPuzzle("012345678", "101", "010");
		puzzle.adjustColPuzzleBack("012345678", "101", "010");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 0);
		assertPieceIsRotated(puzzle.piece[3], 1);
		assertPieceIsRotated(puzzle.piece[4], 1);
		assertPieceIsRotated(puzzle.piece[5], 1);
		assertPieceIsRotated(puzzle.piece[6], 0);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 0);
	}

	@Test
	public void testAdjustColAndRowPuzzleBack() {

		puzzle.adjustRowPuzzle("012345678", "010");
		puzzle.adjustColPuzzle("012345678", "101", "010");
		puzzle.adjustColPuzzleBack("012345678", "101", "010");
		puzzle.adjustRowPuzzleBack("012345678", "010");
		assertPieceIsRotated(puzzle.piece[0], 0);
		assertPieceIsRotated(puzzle.piece[1], 0);
		assertPieceIsRotated(puzzle.piece[2], 0);
		assertPieceIsRotated(puzzle.piece[3], 0);
		assertPieceIsRotated(puzzle.piece[4], 0);
		assertPieceIsRotated(puzzle.piece[5], 0);
		assertPieceIsRotated(puzzle.piece[6], 0);
		assertPieceIsRotated(puzzle.piece[7], 0);
		assertPieceIsRotated(puzzle.piece[8], 0);
	}
	
	@Test
	public void testCheckPosition0ForValidPieces() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade, and the South side is an internal heart, 
		PuzzlePiece piece1 = puzzle.piece[2]; //West side is an external spade (should fit)
		PuzzlePiece piece2 = puzzle.piece[4]; //North side is an external heart (should fit)
		assertTrue(puzzle.checkPosition0(piece0, piece1, piece2));
	}

	@Test
	public void testCheckPosition0ForInvalidPieces1() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade, and the South side is an internal heart, 
		PuzzlePiece piece1 = puzzle.piece[2]; //West side is an external spade (should fit)
		PuzzlePiece piece2 = puzzle.piece[5]; //North side is an external club (should not fit)
		assertFalse(puzzle.checkPosition0(piece0, piece1, piece2));
	}
	
	@Test
	public void testCheckPosition0ForInvalidPieces2() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade, and the South side is an internal heart, 
		PuzzlePiece piece1 = puzzle.piece[1]; //West side is an external heart (should not fit)
		PuzzlePiece piece2 = puzzle.piece[4]; //North side is an external heart (should fit)
		assertFalse(puzzle.checkPosition0(piece0, piece1, piece2));
	}
	
	@Test
	public void testCheckPosition0ForInvalidPieces3() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade, and the South side is an internal heart, 
		PuzzlePiece piece1 = puzzle.piece[1]; //West side is an external heart (should not fit)
		PuzzlePiece piece2 = puzzle.piece[5]; //North side is an external club (should not fit)
		assertFalse(puzzle.checkPosition0(piece0, piece1, piece2));
	}
	
	@Test
	public void testCheckPosition1ForValidPieces() {

		PuzzlePiece piece0 = puzzle.piece[2]; //South side is an internal diamond
		PuzzlePiece piece1 = puzzle.piece[0]; //North side is an external diamond (should fit)
		assertTrue(puzzle.checkPosition1(piece0, piece1));
	}

	@Test
	public void testCheckPosition1ForInvalidPieces() {

		PuzzlePiece piece0 = puzzle.piece[1]; //South side is an internal heart
		PuzzlePiece piece1 = puzzle.piece[0]; //North side is an external diamond (should not fit)
		assertFalse(puzzle.checkPosition1(piece0, piece1));
	}
	
	@Test
	public void testCheckPosition2ForValidPieces() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade
		PuzzlePiece piece1 = puzzle.piece[2]; //West side is an external spade (should fit)
		assertTrue(puzzle.checkPosition2(piece0, piece1));
	}

	@Test
	public void testCheckPosition2ForInvalidPieces() {

		PuzzlePiece piece0 = puzzle.piece[0]; //East side is an internal spade
		PuzzlePiece piece1 = puzzle.piece[1]; //West side is an external heart (should not fit)
		assertFalse(puzzle.checkPosition2(piece0, piece1));
	}
	
	@Test
	public void testSolvePuzzle() {

		String solution = "710538642";
		String rowVariant = "000";
		String colVariant = "001";
		puzzle.adjustRowPuzzle(solution, rowVariant);
		puzzle.adjustColPuzzle(solution, colVariant, rowVariant);
		String solutionOutput = puzzle.solvePuzzle(solution);
		assertTrue(solutionOutput.matches("111111111"));
	}

}
