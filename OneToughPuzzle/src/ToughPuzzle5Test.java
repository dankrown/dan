import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class ToughPuzzle5Test {

	ToughPuzzle5 puzzle;
	@Before
	public void setUp() throws Exception {
		puzzle = new ToughPuzzle5();
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
	public void testCheckPosition0() {

		fail("Not yet implemented");
	}

	@Test
	public void testCheckPosition1() {

		fail("Not yet implemented");
	}

	@Test
	public void testCheckPosition2() {

		fail("Not yet implemented");
	}

	@Test
	public void testSolvePuzzle() {

		fail("Not yet implemented");
	}

}
