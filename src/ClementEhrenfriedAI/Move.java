package ClementEhrenfriedAI;

import java.awt.Point;

import sharedfiles.Piece;

public class Move {

	private Piece pieceToMove;
	private Point destination;
	private Point origin;

	public Move(Point origin, Point destination, Piece pieceToMove) {
		this.destination = destination;
		this.origin = origin;
		this.pieceToMove = pieceToMove;
	}

	public Piece getPieceToMove() {
		return pieceToMove;
	}

	public Point getDestination() {
		return destination;
	}

	public void setPieceToMove(Piece pieceToMove) {
		this.pieceToMove = pieceToMove;
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}

	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		String out = "Origin: ";
		out = out.concat("(" + (int) origin.getX() + ", " + (int) origin.getY() + ")" + '\t');
		out = out.concat("Destination: (" + (int) destination.getX() + ", " + (int) destination.getY() + ")" + '\t');
		out = out.concat("Piece: " + pieceToMove.toString());
		return out;

	}

}
