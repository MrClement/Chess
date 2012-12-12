package DerpyAI;

import java.awt.Point;

public class DerpyKing extends DerpyPiece {

	public DerpyKing(boolean b, Point p) {
		super(b, "K");
		currentLocation = p;
		xMoveConstraint = 1;
		yMoveConstraint = 1;
		pvalue = 100; 
	}

}
