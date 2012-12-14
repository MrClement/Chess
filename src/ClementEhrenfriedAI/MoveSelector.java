package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import sharedfiles.Bishop;
import sharedfiles.Pawn;
import sharedfiles.Piece;
import sharedfiles.Queen;
import sharedfiles.Rook;

public class MoveSelector {

	private HashMap<Point, ChessSquare> potentialMoves;

	private Movement howToMove;

	public MoveSelector(Movement m) {
		potentialMoves = m.getPotentialMoves();
		howToMove = m;

	}

	public HashMap<Point, ChessSquare> getPotentialMoves() {
		return potentialMoves;
	}

	public boolean isThreatened(Point p) {
		return !potentialMoves.get(p).getInbound().isEmpty();
	}

	public Move optimalMove(boolean color) {
		return defendMyKing(color);
	}

	public Move defendMyKing(boolean color) {

		Move m = null;
		Random r = new Random();
		Point p = howToMove.findPiece(color, "K");
		if (p != null) {
			if (isThreatened(p)) {
				HashMap<Integer, Move> temp = howToMove.getMoves(p);
				m = temp.get(r.nextInt(temp.size()));
				// System.out.println(m.toString());
				return m;
			}
		}
		return findAndTakeKing(color);

	}

	public Move findAndTakeKing(boolean color) {

		Move m = null;
		Point p = howToMove.findPiece(!color, "K");

		if (p != null) {
			ChessSquare e = potentialMoves.get(p);
			for (Entry<Point, Piece> f : e.getInbound().entrySet()) {
				m = new Move(f.getKey(), p, f.getValue());
				// System.out.println(m.toString());
				return m;

			}
		}

		return promoteSelf(color);
	}

	public Move promoteSelf(boolean color) {

		Move m = null;

		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			if (e.getKey().getY() == 0 && color) {

				for (Entry<Point, Piece> f : e.getValue().getInbound(color).entrySet()) {
					if (f.getValue().toString().equals("WP")) {
						m = new Move(f.getKey(), e.getKey(), new Queen(color));
						// System.out.println(m.toString());
						return m;
					}

				}
			}

			if (e.getKey().getY() == 7 && !color) {

				for (Entry<Point, Piece> f : e.getValue().getInbound(color).entrySet()) {
					if (f.getValue().toString().equals("BP")) {
						m = new Move(f.getKey(), e.getKey(), new Queen(color));
						// System.out.println(m.toString());
						return m;
					}

				}
			}

		}

		return prioritizedAggressiveMove(color);
	}

	public Move prioritizedAggressiveMove(boolean color) {

		HashMap<Piece, Move> tempMoves = new HashMap<Piece, Move>();

		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			for (Entry<Point, Piece> f : e.getValue().getInbound(color).entrySet()) {
				if (!e.getValue().getLocalPiece().toString().equals("WX")) {
					Move p = null;
					p = new Move(f.getKey(), e.getKey(), f.getValue());
					tempMoves.put(e.getValue().getLocalPiece(), p);

				}

			}

		}
		for (Entry<Piece, Move> e : tempMoves.entrySet()) {
			if (e.getKey().toString().equals(new Queen(!color).toString())) {
				return e.getValue();
			}
		}
		for (Entry<Piece, Move> e : tempMoves.entrySet()) {
			if (e.getKey().toString().equals(new Rook(!color).toString())) {
				return e.getValue();
			}
		}
		for (Entry<Piece, Move> e : tempMoves.entrySet()) {
			if (e.getKey().toString().equals(new Bishop(!color).toString())) {
				return e.getValue();
			}
		}
		for (Entry<Piece, Move> e : tempMoves.entrySet()) {
			if (e.getKey().toString().equals(new Pawn(!color).toString())) {
				return e.getValue();
			}
		}

		return aggressiveMove(color);
	}

	public Move aggressiveMove(boolean color) {

		Move m = null;

		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			for (Entry<Point, Piece> f : e.getValue().getInbound(color).entrySet()) {
				if (!e.getValue().getLocalPiece().toString().equals("WX")) {
					m = new Move(f.getKey(), e.getKey(), f.getValue());
					// System.out.println(m.toString());
					return m;
				}

			}

		}

		return randomMove(color);
	}

	public Move randomMove(boolean color) {

		HashMap<Integer, Entry<Point, ChessSquare>> numberedMovesList = new HashMap<Integer, Entry<Point, ChessSquare>>();
		HashMap<Integer, Entry<Point, Piece>> numberedMoves = new HashMap<Integer, Entry<Point, Piece>>();

		int listCounter = 0;
		int counter = 0;

		Random r = new Random();

		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {
			numberedMovesList.put(listCounter, e);
			listCounter++;
		}
		int moveIndex;
		while (true) {
			moveIndex = r.nextInt(numberedMovesList.size());
			if (!numberedMovesList.get(moveIndex).getValue().getInbound(color).isEmpty())
				break;
		}

		Set<Entry<Point, Piece>> tempEntrySet = numberedMovesList.get(moveIndex).getValue().getInbound(color)
				.entrySet();
		for (Entry<Point, Piece> e : tempEntrySet) {
			numberedMoves.put(counter, e);
			counter++;

		}
		int moveIndex2 = r.nextInt(numberedMoves.size());

		numberedMoves.get(moveIndex2).getKey();

		Move m = new Move(numberedMoves.get(moveIndex2).getKey(), numberedMovesList.get(moveIndex).getKey(),
				numberedMoves.get(moveIndex2).getValue());
		// System.out.println(m.toString());
		return m;

	}

	public Move goThroughMoves(boolean color) {

		Move m = null;
		for (Entry<Point, ChessSquare> e : potentialMoves.entrySet()) {

			for (Entry<Point, Piece> f : e.getValue().getInbound().entrySet()) {
				Move p = new Move(f.getKey(), e.getKey(), f.getValue());
				System.out.println(p.toString());
				return p;

			}

		}
		return m;

	}

}
