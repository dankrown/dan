

public class PuzzlePiece {

	private final int pieceIndex;
	
	// Sides of Puzzle;
	private int northSide;
	private int eastSide;
	private int southSide;
	private int westSide;
	private int orientation;
	
    // Kinds of interlocks
    public final static int EXT_DIAMOND = 0;
    public final static int EXT_CLUB    = 1;
    public final static int EXT_HEART   = 2;
    public final static int EXT_SPADE   = 3;
    public final static int IN_DIAMOND  = 4;
    public final static int IN_CLUB     = 5;
    public final static int IN_HEART    = 6;
    public final static int IN_SPADE    = 7;
    
    // Orientation of Puzzle Piece
    public final static int rotated_0_CW 	= 0;
    public final static int rotated_90_CW 	= 1;
    public final static int rotated_180_CW	= 2;
    public final static int rotated_270_CW 	= 3;
    
    public PuzzlePiece(int index, int orientation, int northSide, int eastSide, int southSide, int westSide) {
        assert isValidPiece(northSide, eastSide, southSide, westSide);
        this.northSide 	= northSide;
        this.eastSide	= eastSide;
        this.southSide	= southSide;
        this.westSide	= westSide;
        this.pieceIndex = index;
        this.orientation = orientation;
    }

    public void rotate90DegreesCW () {
    	int temp = 0;
    	orientation = (orientation + 1) % 4;
    	temp = getNorthSide();    	
    	setNorthSide(getWestSide());
    	setWestSide(getSouthSide());
    	setSouthSide(getEastSide());
    	setEastSide(temp);
    }
    
    public void rotate180Degrees () {
    	int temp1 = 0, temp2 = 0;
    	orientation = (orientation + 2) % 4;
    	temp1 = getNorthSide();
    	temp2 = getWestSide();
    	setNorthSide(getSouthSide());
    	setWestSide(getEastSide());
    	setSouthSide(temp1);
    	setEastSide(temp2);
    }
    
    public void rotate270DegreesCW () {
    	int temp = 0;
    	orientation = (orientation + 3) % 4;
    	temp = getNorthSide();    	
    	setNorthSide(getEastSide());
    	setEastSide(getSouthSide());
    	setSouthSide(getWestSide());
    	setWestSide(temp);
    }
    
	private boolean isValidPiece(int northSide, int eastSide, int southSide, int westSide) {

		// TODO Auto-generated method stub
		//0011
		if ((northSide<4)&&(eastSide<4)&&(southSide>=4)&&(westSide>=4)) {
			return true;
		} 
		//0101
		else if ((northSide<4)&&(eastSide>=4)&&(southSide<4)&&(westSide>=4)) {
			return true;
		} 
		//0110
		else if ((northSide<4)&&(eastSide>=4)&&(southSide>=4)&&(westSide<4)) {
			return true;
		} 
		//1001
		else if ((northSide>=4)&&(eastSide<4)&&(southSide<4)&&(westSide>=4)) {
			return true;
		} 
		//1010
		else if ((northSide>=4)&&(eastSide<4)&&(southSide>=4)&&(westSide<4)) {
			return true;
		}
		//1100
		else if ((northSide>=4)&&(eastSide>=4)&&(southSide<4)&&(westSide<4)) {
			return true;
		} 
		else {
			return false;
		}
	}

	
	/**
	 * @return the northSide
	 */
	public int getNorthSide() {
	
		return northSide;
	}

	
	/**
	 * @param northSide the northSide to set
	 */
	public void setNorthSide(int northSide) {
	
		this.northSide = northSide;
	}

	
	/**
	 * @return the eastSide
	 */
	public int getEastSide() {
	
		return eastSide;
	}

	
	/**
	 * @param eastSide the eastSide to set
	 */
	public void setEastSide(int eastSide) {
	
		this.eastSide = eastSide;
	}

	
	/**
	 * @return the southSide
	 */
	public int getSouthSide() {
	
		return southSide;
	}

	
	/**
	 * @param southSide the southSide to set
	 */
	public void setSouthSide(int southSide) {
	
		this.southSide = southSide;
	}

	
	/**
	 * @return the westSide
	 */
	public int getWestSide() {
	
		return westSide;
	}

	
	/**
	 * @param westSide the westSide to set
	 */
	public void setWestSide(int westSide) {
	
		this.westSide = westSide;
	}

	
	/**
	 * @return the orientation
	 */
	public int getOrientation() {
	
		return orientation;
	}
	
	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(int orientation) {
	
		this.orientation = orientation;
	}

	/**
	 * @return the pieceIndex
	 */
	public int getPieceIndex() {
	
		return pieceIndex;
	}
	
	public static String interlockToString(int interlock) {
        switch (interlock) {
        case EXT_DIAMOND:
            return "Diamond Figure";
        case EXT_CLUB:
            return " Club Figure  ";
        case EXT_HEART:
            return " Heart Figure ";
        case EXT_SPADE:
            return " Spade Figure ";
        case IN_DIAMOND:
            return " Diamond Hole ";
        case IN_CLUB:
            return "   Club Hole  ";
        case IN_HEART:
            return "  Heart Hole  ";
        case IN_SPADE:
            return "  Spade Hole  ";
        default:
            return null;
        }
    }
}
