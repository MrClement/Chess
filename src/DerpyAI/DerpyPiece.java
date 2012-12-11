package DerpyAI;

import java.awt.Point;

import sharedfiles.Piece;

public class DerpyPiece extends Piece {

	protected Point currentLocation;
	int xMoveConstraint;
	int yMoveConstraint;
	int pvalue; 

	public DerpyPiece(boolean b, String id) {
		super(b, id);
	}

	int toValue(){
		return pvalue; 
	}
	public boolean changeLocation(Point p) {
		if ((int) (p.getX() - currentLocation.getX()) <= xMoveConstraint
				&& (int) (p.getY() - currentLocation.getY()) <= yMoveConstraint) {
			currentLocation = p;
			return true;
		}
		if (this instanceof DerpyKing) {
			currentLocation = p;
			return true;
		} else
			return false;
	}

	public Point getLocation() {
		return currentLocation;
	}

}
