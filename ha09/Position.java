package ha09;

/**
 * Represents a Position on a chessfield
 * the final attributes can be set and never changed agains
 * @author tom Althöfer
 *
 */
public class Position {
	//final attributes for the position
	private final int x;
	private final int y;

	/**
	 * sets the coordinates for the Position
	 * @param xPos
	 * @param yPos
	 */
	public Position(int xPos, int yPos) {
		this.x = xPos;
		this.y = yPos;
	}


	/**
	 * geter-method for the x-corrdinate
	 * @return
	 * 		x-coordinate of the Positio n
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * getter-method for the y-coordinate
	 * @return
	 * 		x-coordinate of the Positio n
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * checks, if two Positions are the same
	 * @param p
	 * 		Position, to be compared with this
	 * @return
	 * 		true, if  the Positions are equal
	 * 		false, if this is not the case
	 */
	public boolean equals(Position p) {
		if(p.getX() == this.x && p.getY() == this.y) {
			return true; 
		} else {
			return false;
		}
	}
	
	/**
	 * checks, if the Position is on the chessfield, both coordinates have to be between 1 and 8 (inklusive)
	 * @return
	 * 		true, if it is a valid position
	 * 		false, if the Position is not on the chessfield
	 */
	public boolean isValid(){
		if(this.x > 0 && this.x < 9){
			if(this.y > 0 && this.y < 9){
				return true;
			} else{
				return false;
			}
		} else{
			return false;
		}
	}
	
	/**
	 * @return
	 * 		x/y as a representation of the Position
	 */
	public String toString(){
		return this.x + "/" + this.y;
	}
}
