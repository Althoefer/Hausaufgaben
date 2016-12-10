package ha09;

import java.util.ArrayList;

/**
 * extends the abstract class Chessman represents a rook and implements the
 * getMoveList() method in an acording way
 * 
 * @author Tom Althoefer
 *
 */
public class Rook extends Chessman {

	public Rook(Position p) {
		super(p);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		ArrayList<Position> moveList = new ArrayList<Position>();
		for(int i = 1; i<=8; i++){
			if(i != y){
				moveList.add(new Position(x, i));
			}
		}
		for(int i = 1; i<=8; i++){
			if(i !=x){
				moveList.add(new Position(i, y));
			}
		}
		return moveList;
	}

	public String toString() {
		return "Turm: (" + this.getPosition().toString() + ")";
	}
}
