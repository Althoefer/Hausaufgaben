package ha09;

import java.util.ArrayList;

/**
 * extends the abstract class Chessman
 * represents a knight and implements the getMoveList() method in an acording way
 * @author Tom Althoefer
 *
 */
public class Knight extends Chessman{

	public Knight(Position p) {
		super(p);
	}

	@Override
	public ArrayList<Position> getMoveList() {
		int x = this.getPosition().getX();
		int y = this.getPosition().getY();
		ArrayList<Position> moveList = new ArrayList<Position>();
		moveList.add(new Position(x+2, y+1));
		moveList.add(new Position(x+2, y-1));
		moveList.add(new Position(x-2, y+1));
		moveList.add(new Position(x-2, y-1));
		moveList.add(new Position(x+1, y+2));
		moveList.add(new Position(x+1, y-2));
		moveList.add(new Position(x-1, y+2));
		moveList.add(new Position(x-1, y-2));
		
		for(int i = 0; i<moveList.size(); i++){
			if(moveList.get(i).isValid()){
				
			}else{
				moveList.remove(i);
				//else we might skip a element the list, because the element at i ist replaced by a new one
				i--;
			}
		}
		return moveList;
	}
	
	public String toString(){
		return "Springer: (" + this.getPosition().toString() + ")";
	}
}
