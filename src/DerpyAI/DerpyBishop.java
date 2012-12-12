package DerpyAI;
import java.awt.Point; 

public class DerpyBishop extends DerpyPiece {

	public DerpyBishop(boolean b, Point p) {
		super(b,"B");
		currentLocation = p; 
		xMoveConstraint = 8; 
		yMoveConstraint = 8; 
		pvalue = 3; 
	}


}
