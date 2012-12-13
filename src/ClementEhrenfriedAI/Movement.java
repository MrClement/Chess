package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

import sharedfiles.Piece;

/**
 * @author Alex Clement
 * 
 * 
 * 
 */
public class Movement {

	private HashMap<Point, ChessSquare> potentialMoves;
	private HashMap<Point, Piece> pieceLocations;

	/**
	 * The default constructor
	 */
	public Movement() {

	}

	/**
	 * @param pieceLocations
	 */
	public Movement(HashMap<Point, Piece> pieceLocations) {
		this.pieceLocations = pieceLocations;
		potentialMoves = new HashMap<Point, ChessSquare>();

	}

	public void findMoves() {

		for (Entry<Point, Piece> e : pieceLocations.entrySet()) {
			Point currentPoint = e.getKey();
			Piece currentPiece = e.getValue();
			switch (currentPiece.toString()) {
				case "BK":
					kingMove(currentPoint, currentPiece);
					break;

				case "WK":
					kingMove(currentPoint, currentPiece);
					break;

				case "BQ":
					rookMove(currentPoint, currentPiece);
					bishopMove(currentPoint, currentPiece);
					break;

				case "WQ":
					rookMove(currentPoint, currentPiece);
					bishopMove(currentPoint, currentPiece);
					break;

				case "BR":
					rookMove(currentPoint, currentPiece);
					break;

				case "WR":
					rookMove(currentPoint, currentPiece);
					break;

				case "BN":
					knightMove(currentPoint, currentPiece);
					break;

				case "WN":
					knightMove(currentPoint, currentPiece);
					break;

				case "BB":
					bishopMove(currentPoint, currentPiece);
					break;

				case "WB":
					bishopMove(currentPoint, currentPiece);
					break;

				case "BP":
					blackPawnMove(currentPoint, currentPiece);
					break;

				case "WP":
					whitePawnMove(currentPoint, currentPiece);
					break;

				case "WX":
					addToMovesLocal(currentPoint, currentPiece, true);
					break;

				default:
					break;
			}
		}

	}

	private void whitePawnMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		if (((int) currentPoint.getY() == 6 && currentPiece.getColor())) {
			whitePawnMoveFirst(currentPoint, currentPiece);
		}
		Point targetPoint = pieceMove(currentPoint, 0, -1);
		if (isOpen(targetPoint)) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, -1);
		if (isEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, -1);
		if (isEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}

	}

	private void blackPawnMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		if (((int) currentPoint.getY() == 1 && !currentPiece.getColor())) {
			blackPawnMoveFirst(currentPoint, currentPiece);
		}
		Point targetPoint = pieceMove(currentPoint, 0, 1);
		if (isOpen(targetPoint)) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, 1);
		if (isEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, 1);
		if (isEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}

	}

	private void whitePawnMoveFirst(Point currentPoint, Piece currentPiece) {
		Point targetPoint = pieceMove(currentPoint, 0, -2);
		if (isOpen(targetPoint)) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
	}

	private void blackPawnMoveFirst(Point currentPoint, Piece currentPiece) {
		Point targetPoint = pieceMove(currentPoint, 0, 2);
		if (isOpen(targetPoint)) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
	}

	private void kingMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		Point targetPoint = pieceMove(currentPoint, 1, 0);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 0, 1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, 0);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 0, -1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, 1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, -1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, -1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, 1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
	}

	private void rookMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		for (int i = 0; i < 4; i++) {
			rookMoveRecursive(currentPoint, currentPiece, i, currentPoint);
		}

	}

	private void rookMoveRecursive(Point currentPoint, Piece currentPiece, int direction, Point originPoint) {
		switch (direction) {
			case 0:
				Point targetPoint = pieceMove(currentPoint, 1, 0);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						rookMoveRecursive(targetPoint, currentPiece, 0, originPoint);
				}

				break;

			case 1:
				targetPoint = pieceMove(currentPoint, 0, 1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						rookMoveRecursive(targetPoint, currentPiece, 1, originPoint);
				}

				break;
			case 2:

				targetPoint = pieceMove(currentPoint, -1, 0);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						rookMoveRecursive(targetPoint, currentPiece, 2, originPoint);
				}

				break;

			case 3:

				targetPoint = pieceMove(currentPoint, 0, -1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						rookMoveRecursive(targetPoint, currentPiece, 3, originPoint);
				}

				break;
		}

	}

	private void bishopMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		for (int i = 0; i < 4; i++) {
			bishopMoveRecursive(currentPoint, currentPiece, i, currentPoint);
		}

	}

	private void bishopMoveRecursive(Point currentPoint, Piece currentPiece, int direction, Point originPoint) {
		switch (direction) {
			case 0:
				Point targetPoint = pieceMove(currentPoint, 1, 1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						bishopMoveRecursive(targetPoint, currentPiece, 0, originPoint);
				}

				break;

			case 1:
				targetPoint = pieceMove(currentPoint, -1, 1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						bishopMoveRecursive(targetPoint, currentPiece, 1, originPoint);
				}

				break;
			case 2:

				targetPoint = pieceMove(currentPoint, -1, -1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						bishopMoveRecursive(targetPoint, currentPiece, 2, originPoint);
				}

				break;

			case 3:

				targetPoint = pieceMove(currentPoint, 1, -1);
				if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
					addToMovesTo(targetPoint, currentPiece, originPoint);
					if (isOpen(targetPoint))
						bishopMoveRecursive(targetPoint, currentPiece, 3, originPoint);
				}

				break;
		}

	}

	private void knightMove(Point currentPoint, Piece currentPiece) {
		addToMovesLocal(currentPoint, currentPiece);
		Point targetPoint = pieceMove(currentPoint, 2, 1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 2, -1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -2, 1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -2, -1);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, -2);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, -2);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, -1, 2);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
		targetPoint = pieceMove(currentPoint, 1, 2);
		if (isOpenOrEnemy(targetPoint, currentPiece.getColor())) {
			addToMovesTo(targetPoint, currentPiece, currentPoint);
		}
	}

	public void addToMovesLocal(Point where, Piece what) {

		if (potentialMoves.get(where) == null) {
			potentialMoves.put(where, new ChessSquare(where, what));
		} else {
			potentialMoves.get(where).setLocalPiece(what);
		}

	}

	public void addToMovesLocal(Point where, Piece what, boolean color) {

		if (potentialMoves.get(where) == null) {
			potentialMoves.put(where, new ChessSquare(where, what, color));
		} else {
			potentialMoves.get(where).setLocalPiece(what);
		}

	}

	public void addToMovesTo(Point destination, Piece what, Point origin) {

		if (potentialMoves.get(destination) == null) {
			ChessSquare temp = new ChessSquare();
			temp.inbound.put(origin, what);
			potentialMoves.put(destination, temp);
		} else {
			potentialMoves.get(destination).inbound.put(origin, what);
		}

	}

	public boolean isOpenOrEnemy(Point pieceMove, boolean color) {
		return (pieceLocations.get(pieceMove) != null && (pieceLocations.get(pieceMove).toString().equals("WX") || pieceLocations
				.get(pieceMove).getColor() != color));
	}

	public boolean isOpen(Point pieceMove) {
		return (pieceLocations.get(pieceMove) != null && pieceLocations.get(pieceMove).toString().equals("WX"));
	}

	private boolean isEnemy(Point pieceMove, boolean color) {
		return (pieceLocations.get(pieceMove) != null && pieceLocations.get(pieceMove).getColor() != color && !pieceLocations
				.get(pieceMove).toString().equals("WX"));
	}

	public Point pieceMove(Point p, int x, int y) {
		Point temp = (Point) p.clone();
		temp.translate(x, y);
		return temp;
	}

	public HashMap<Point, ChessSquare> getPotentialMoves() {
		return potentialMoves;
	}

	public void setPotentialMoves(HashMap<Point, ChessSquare> potentialMoves) {
		this.potentialMoves = potentialMoves;
	}

	public Point findPiece(boolean color, String type) {

		Point p = null;
		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			if (e.getValue().getLocalPiece().toString().equals((color ? "W" : "B").concat(type))) {

				p = e.getKey();

			}
		}
		return p;
	}

	public HashMap<Integer, Move> getMoves(Point p) {
		HashMap<Integer, Move> moves = new HashMap<Integer, Move>();
		int counter = 0;
		Move m;
		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			for (Entry<Point, Piece> f : e.getValue().getInbound().entrySet()) {
				if (f.getKey().equals(p)) {
					m = new Move(f.getKey(), e.getKey(), f.getValue());
					moves.put(counter++, m);
				}

			}

		}

		return moves;

	}

}
