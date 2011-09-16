import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ToughPuzzle {

	public PuzzlePiece[] piece;
	private List<String> permutations = new ArrayList<String>();
	private List<String> truthTable = new ArrayList<String>();
	
	public ToughPuzzle() {
		
		piece = new PuzzlePiece[9];
		piece[0] = new PuzzlePiece(0, 0, PuzzlePiece.EXT_DIAMOND, PuzzlePiece.IN_SPADE, PuzzlePiece.IN_HEART, PuzzlePiece.EXT_SPADE);
		piece[1] = new PuzzlePiece(1, 0, PuzzlePiece.EXT_DIAMOND, PuzzlePiece.IN_DIAMOND, PuzzlePiece.IN_HEART, PuzzlePiece.EXT_HEART);
		piece[2] = new PuzzlePiece(2, 0, PuzzlePiece.EXT_DIAMOND, PuzzlePiece.IN_HEART, PuzzlePiece.IN_DIAMOND, PuzzlePiece.EXT_SPADE);
		piece[3] = new PuzzlePiece(3, 0, PuzzlePiece.EXT_HEART, PuzzlePiece.IN_SPADE, PuzzlePiece.IN_HEART, PuzzlePiece.EXT_CLUB);
		piece[4] = new PuzzlePiece(4, 0, PuzzlePiece.EXT_HEART, PuzzlePiece.IN_DIAMOND, PuzzlePiece.IN_CLUB, PuzzlePiece.EXT_CLUB);
		piece[5] = new PuzzlePiece(5, 0, PuzzlePiece.EXT_CLUB, PuzzlePiece.IN_CLUB, PuzzlePiece.IN_DIAMOND, PuzzlePiece.EXT_DIAMOND);
		piece[6] = new PuzzlePiece(6, 0, PuzzlePiece.EXT_DIAMOND, PuzzlePiece.IN_CLUB, PuzzlePiece.IN_CLUB, PuzzlePiece.EXT_HEART);
		piece[7] = new PuzzlePiece(7, 0, PuzzlePiece.EXT_SPADE, PuzzlePiece.IN_HEART, PuzzlePiece.IN_CLUB, PuzzlePiece.EXT_SPADE);
		piece[8] = new PuzzlePiece(8, 0, PuzzlePiece.EXT_SPADE, PuzzlePiece.IN_SPADE, PuzzlePiece.IN_CLUB, PuzzlePiece.EXT_HEART);
		
		perm1(permutations, "012345678");
		perm3(truthTable, this.piece.length);
	}
	
	public static void main(String[] args) {

		ToughPuzzle puzzle = new ToughPuzzle();
    	System.out.println("Possible Permutations: \n");
    	Iterator<String> permutationIterations = puzzle.permutations.iterator();
    			
    	while (permutationIterations.hasNext()){
    		String temp = permutationIterations.next();
    		Iterator<String> puzzleRowVariants = puzzle.truthTable.iterator();
    		while (puzzleRowVariants.hasNext()){
        		String puzRowVariant = puzzleRowVariants.next();
        		if (puzRowVariant.equals("111")){
        			continue;
        		}
        		puzzle.adjustRowPuzzle(temp, puzRowVariant);
	        	Iterator<String> puzzleColVariants = puzzle.truthTable.iterator();
	        	while (puzzleColVariants.hasNext()){
	        		String puzColVariant = puzzleColVariants.next();
	        		if (puzColVariant.equals("111")){
	        			continue;
	        		}
	        		puzzle.adjustColPuzzle(temp, puzColVariant, puzRowVariant);
	        		String solution = "";
	        		
	        		solution = puzzle.solvePuzzle(temp);
	        		

		    		if (solution.matches("111111111")) {
		        		System.out.print("Permutation: " + temp + ", puzzle row variant: " + puzRowVariant + ", puzzle col variant: " + puzColVariant);
		        		System.out.println(", is a Solution!!!!! ('" + solution + "')");
		        	} 
		        	else if (solution.matches(".*1.*1.*1.*1.*1.*1.*1.*1.*")){
		        		System.out.print("Permutation: " + temp + ", puzzle row variant: " + puzRowVariant + ", puzzle col variant: " + puzColVariant);
		        		System.out.println(", is not a solution ('" + solution + "')");
		        	}
//		        	else {
//		        		System.out.print("Permutation: " + temp + ", puzzle row variant: " + puzRowVariant + ", puzzle col variant: " + puzColVariant);
//		        		System.out.println(", is not a solution ('" + solution + "')");
//		        	}
		        	puzzle.adjustColPuzzleBack(temp, puzColVariant, puzRowVariant);
	        	}
	        	puzzle.adjustRowPuzzleBack(temp, puzRowVariant);
	       	}
    	}
	}
	public void perm1(List<String> permutations,String s) { 
    	perm1(permutations, "", s);
    }
    
	protected void perm1(List<String> permutations, String prefix, String s) {
        int N = s.length();
       
        if (N == 0) {
        	permutations.add(prefix);        	
        }
        else {
            for (int i = 0; i < N; i++)
               perm1(permutations, prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
        }
    }
    
    protected void adjustColPuzzleBack(String pieceIteration, String puzColVariant, String puzRowVariant) {
    	for (int i = 0; i < this.piece.length; i++){
			if (puzColVariant.charAt(i%3)=='1' && puzRowVariant.charAt(i/3)=='1'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate270DegreesCW();
			}
			else if (puzColVariant.charAt(i%3)=='1' && puzRowVariant.charAt(i/3)=='0'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate90DegreesCW();
			}
		}
		
	}

    protected void adjustColPuzzle(String pieceIteration, String puzColVariant, String puzRowVariant) {
		for (int i = 0; i < this.piece.length; i++){
			if (puzColVariant.charAt(i%3)=='1' && puzRowVariant.charAt(i/3)=='1'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate90DegreesCW();
			}
			else if (puzColVariant.charAt(i%3)=='1' && puzRowVariant.charAt(i/3)=='0'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate270DegreesCW();
			}
		}
	}

	protected void adjustRowPuzzle(String pieceIteration, String puzRowVariant) {
		for (int i = 0; i < this.piece.length; i++){
			if (puzRowVariant.charAt(i/3)=='1'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate90DegreesCW();
			}
		}
	}
	
	protected void adjustRowPuzzleBack(String pieceIteration, String puzRowVariant) {
		for (int i = 0; i < this.piece.length; i++){
			if (puzRowVariant.charAt(i/3)=='1'){
				this.piece[Character.getNumericValue(pieceIteration.charAt(i))].rotate270DegreesCW();
			}
		}
	}

	protected void perm3(List<String> truthTable, int puzzleLength) {
		int variables = (int) Math.sqrt(puzzleLength);
		perm3(truthTable, "", variables);		
	}

	protected void perm3(List<String> truthTable, String prefix, int variables) {
		if (variables==0){
			truthTable.add(prefix); 
		} else {
			variables--;
			perm3(truthTable, prefix + "0",variables);
			perm3(truthTable, prefix + "1",variables);
		}
	}
	
	/**
	 * Checks validity of pieces to the right of pieceStartingPoint (pieceBesideStartingPiece) and below pieceStartingPoint (pieceBelowStartingPiece)
	 * @param pieceStartingPoint
	 * @param pieceBesideStartingPiece
	 * @param pieceBelowStartingPiece
	 * @return
	 */
	public boolean checkPosition0 (PuzzlePiece pieceStartingPoint, PuzzlePiece pieceBesideStartingPiece, PuzzlePiece pieceBelowStartingPiece){
		
    	if ((pieceStartingPoint.getEastSide()%4)==pieceBesideStartingPiece.getWestSide()%4){
    		if ((pieceStartingPoint.getSouthSide()%4)==pieceBelowStartingPiece.getNorthSide()%4){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Checks the validity of the piece below pieceStartingPoint (pieceBelowStartingPiece)
     * @param pieceStartingPoint
     * @param pieceBelowStartingPiece
     * @return
     */
    public boolean checkPosition1 (PuzzlePiece pieceStartingPoint, PuzzlePiece pieceBelowStartingPiece) {
    	
    	if ((pieceStartingPoint.getSouthSide()%4)==(pieceBelowStartingPiece.getNorthSide()%4)){
    		return true;
    	}
    	return false;
    }
    
    /**
     * Checks the validity of the piece to the right of pieceStartingPoint (pieceBesideStartingPoint)
     * @param pieceStartingPoint
     * @param pieceBesideStartingPoint
     * @return
     */
    public boolean checkPosition2 (PuzzlePiece pieceStartingPoint, PuzzlePiece pieceBesideStartingPoint) {
   
    	if ((pieceStartingPoint.getEastSide()%4)==(pieceBesideStartingPoint.getWestSide()%4)){
    		return true;
    	}
    	return false;
    }
    
    public String solvePuzzle (String pieceIteration){
    	
    	String solution = "";
    	boolean[] pieceFit = {false, false, false, false, false,
    						false, false, false, false};
    	for (int i=0;i<this.piece.length;i++){
			if (i+3<this.piece.length){
				if (i%3<2){
					pieceFit[i]=checkPosition0(this.piece[Character.getNumericValue(pieceIteration.charAt(i))], this.piece[Character.getNumericValue(pieceIteration.charAt(i+1))], this.piece[Character.getNumericValue(pieceIteration.charAt(i+3))]);
				} else {
					pieceFit[i]=checkPosition1(this.piece[Character.getNumericValue(pieceIteration.charAt(i))], this.piece[Character.getNumericValue(pieceIteration.charAt(i+3))]);
				}
			}
			else if (i%3<2) {
				pieceFit[i] = checkPosition2(this.piece[Character.getNumericValue(pieceIteration.charAt(i))], this.piece[Character.getNumericValue(pieceIteration.charAt(i+1))]);
			}
			else {
				pieceFit[i] = true;
			}
			if (pieceFit[i]){
				solution = solution + "1";
			} else {
				solution = solution + "0";
			}
		}
    	return solution;
    }
}
