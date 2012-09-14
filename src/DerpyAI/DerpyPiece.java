package DerpyAI;

import java.awt.Point;
import sharedfiles.Piece;

public class DerpyPiece extends Piece {

	protected Point currentLocation;
	int xMoveConstraint; 
	int yMoveConstraint;
	
	public DerpyPiece(boolean b, String id) {
		super(b, id);
	}

	public boolean changeLocation(Point p) {
		if ((int)(p.getX()-currentLocation.getX())<=xMoveConstraint && (int)(p.getY()-currentLocation.getY())<=yMoveConstraint){
			currentLocation = p; 
			return true; 
		}
		else return false; 
	}
	
	public Point getLocation(){
		return currentLocation; 
	}
	
	

}
