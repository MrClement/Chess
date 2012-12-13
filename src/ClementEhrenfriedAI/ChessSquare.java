package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

import sharedfiles.Piece;

public class ChessSquare {

	protected HashMap<Point, Piece> inbound;
	private Piece localPiece;
	private Point location;
	private boolean isBlank;

	public ChessSquare() {
		inbound = new HashMap<Point, Piece>();
		isBlank = false;

	}

	public ChessSquare(Point where, Piece what) {
		localPiece = what;
		location = where;
		inbound = new HashMap<Point, Piece>();
		isBlank = false;
	}

	public ChessSquare(Point where, Piece what, boolean color) {
		localPiece = what;
		location = where;
		inbound = new HashMap<Point, Piece>();
		isBlank = color;
	}

	public HashMap<Point, Piece> getInbound() {
		return inbound;
	}

	public HashMap<Point, Piece> getInbound(boolean color) {
		HashMap<Point, Piece> temp = new HashMap<Point, Piece>();
		for (Entry<Point, Piece> e : inbound.entrySet()) {
			if (e.getValue().getColor() == color)
				temp.put(e.getKey(), e.getValue());

		}
		return temp;
	}

	public Piece getLocalPiece() {
		return localPiece;
	}

	public Point getLocation() {
		return location;
	}

	public void setInbound(HashMap<Point, Piece> inbound) {
		this.inbound = inbound;
	}

	public void setLocalPiece(Piece localPiece) {
		this.localPiece = localPiece;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public boolean isBlank() {
		return isBlank;
	}

	public void setBlank(boolean isBlank) {
		this.isBlank = isBlank;
	}

}
