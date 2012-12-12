package DerpyAI;
import java.awt.Point; 

public class DerpyQueen extends DerpyPiece {

	public DerpyQueen(boolean b, Point p) {
		super(b,"Q");
		currentLocation = p; 
		xMoveConstraint = 8; 
		yMoveConstraint = 8; 
		pvalue = 10; 
	}


}
