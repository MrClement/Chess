package DerpyAI;
import java.awt.Point; 

public class DerpyPawn extends DerpyPiece {

	public DerpyPawn(boolean b, Point p) {
		super(b,"P");
		currentLocation = p; 
		xMoveConstraint = 0;
		yMoveConstraint = 2; //will need to be modified after its first y move
		pvalue = 1; 
	}
	 
}
