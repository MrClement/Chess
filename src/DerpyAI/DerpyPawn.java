package DerpyAI;
import java.awt.Point; 

public class DerpyPawn extends DerpyPiece {

	private boolean moved;
	
	public DerpyPawn(boolean b, Point p) {
		super(b,"P");
		currentLocation = p; 
		xMoveConstraint = 0;
		yMoveConstraint = 2; //will need to be modified after its first y move
		boolean moved = false; 
	}

	public void firstMoveMade(){
		yMoveConstraint = 1; 
		moved = true; 
	}
	//allows a pawn to take a piece (since piece-taking is diagonal)
	public void allowToTake(){
		xMoveConstraint=1;
	}
	
	public boolean changeLocation(Point p){
		if (moved == false) {
			if ((int)(p.getX()-currentLocation.getX())<=xMoveConstraint && (int)(p.getY()-currentLocation.getY())<=yMoveConstraint) {
				currentLocation = p; 
				firstMoveMade();
				return true; 
			}	
			else return false;
		}
		else if ((int)(p.getX()-currentLocation.getX())<=xMoveConstraint && (int)(p.getY()-currentLocation.getY())<=yMoveConstraint) {
			currentLocation = p; 
			return true; 
		}
		else return false; 
	}
	 
}
