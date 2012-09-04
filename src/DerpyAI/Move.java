package DerpyAI;
import java.awt.Point;

import sharedfiles.*;

public class Move {

	public Piece pieceInvolved;
	public Point originalLocation;
	public Point newLocation;

	private boolean pieceWasTaken;
	private Piece pieceTaken;

	public Move(Piece pieceInvolved, Point originalLocation, Point newLocation) {

		this.pieceInvolved = pieceInvolved;
		this.originalLocation = originalLocation;
		this.newLocation = newLocation;
	}

	public void setPieceWasTaken(Piece pieceTaken) {

		this.pieceTaken = pieceTaken;
		this.pieceWasTaken = true;

	}

	public boolean pieceWasTaken() {
		return pieceWasTaken;
	}

	public Piece getPieceTaken() {
		return pieceTaken;
	}

	public void setPieceTaken(Piece pieceTaken) {
		this.pieceTaken = pieceTaken;
	}



}
