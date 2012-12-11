package DerpyAI;
import java.awt.Point; 

public class DerpyRook extends DerpyPiece {

	public DerpyRook(boolean b, Point p) {
		super(b,"R");
		currentLocation = p; 
		xMoveConstraint = 8; 
		yMoveConstraint = 8; 
		pvalue = 5; 
	}


}
