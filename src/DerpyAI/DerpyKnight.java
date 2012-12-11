package DerpyAI;
import java.awt.Point; 

public class DerpyKnight extends DerpyPiece {

	public DerpyKnight(boolean b, Point p) {
		super(b,"N");
		currentLocation = p; 
		xMoveConstraint = 2;
		yMoveConstraint = 2;
		pvalue = 3; 
	}
	
	

}
