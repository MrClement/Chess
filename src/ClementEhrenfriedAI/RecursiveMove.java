package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

import sharedfiles.Blank;
import sharedfiles.Board;
import sharedfiles.Piece;

public class RecursiveMove {

	private Board b;
	private MoveSelector bestMoveFinder;
	private boolean color;
	private HashMap<Point, Piece> pieceLocations;

	public RecursiveMove(Board b, boolean color) {
		this.b = b;
		this.color = color;
		BoardParser bp = new BoardParser(b);
		pieceLocations = bp.getPieceLocations();
		Movement m = new Movement(pieceLocations);
		m.findMoves();
		bestMoveFinder = new MoveSelector(m);

	}

	public Board makeMove(Board b, Move m) {
		BoardParser bp = new BoardParser(b);
		HashMap<Point, Piece> pieceLocations2 = bp.getPieceLocations();

		Move bestMove = m;

		pieceLocations2.remove(bestMove.getDestination());
		pieceLocations2.remove(bestMove.getOrigin());
		pieceLocations2.put(bestMove.getDestination(), bestMove.getPieceToMove());
		pieceLocations2.put(bestMove.getOrigin(), new Blank(true));
		b = boardBuilder(pieceLocations2);

		return b;

	}

	public Board recursiveMoveStarter(boolean recurse) {
		int recursiveDepth = 4;
		if (!recurse) {
			Evaluator ev = new Evaluator(b, color);
			HashMap<Integer, Move> meMoves = ev.evaluateAllMoves();
			int bestMoveSoFar = 0;
			Move highValueMove = bestMoveFinder.defendMyKing(color);
			for (Entry<Integer, Move> e : meMoves.entrySet()) {
				if (e.getKey() > bestMoveSoFar) {
					bestMoveSoFar = e.getKey();
					highValueMove = e.getValue();

				}
			}
			// System.out.println(highValueMove.toString());
			b = makeMove(b, highValueMove);
			return b;
		}
		Evaluator ev = new Evaluator(b, color);
		HashMap<Integer, Move> meMoves = ev.evaluateAllMoves();
		int bestMoveSoFar = 0;
		Move highValueMove = bestMoveFinder.defendMyKing(color);
		for (Entry<Integer, Move> e : meMoves.entrySet()) {
			if (e.getKey() + recursiveMove(makeMove(b, e.getValue()), recursiveDepth) > bestMoveSoFar) {
				bestMoveSoFar = e.getKey();
				highValueMove = e.getValue();

			}
		}
		System.out.println(highValueMove.toString());
		b = makeMove(b, highValueMove);
		return b;
	}

	public int recursiveMove(Board b, int depth) {
		Hal them = new Hal(!color, b);
		b = them.nextMoveNoRecursion(b);
		BoardParser bp = new BoardParser(b);
		HashMap<Point, Piece> pieceLocations2 = bp.getPieceLocations();
		Movement availableMoves2 = new Movement(pieceLocations2);
		availableMoves2.findMoves();
		MoveSelector bestMoveFinder2 = new MoveSelector(availableMoves2);
		Evaluator ev = new Evaluator(b, color);
		HashMap<Integer, Move> meMoves = ev.evaluateAllMoves();
		int bestMoveSoFar = 0;
		Move highValueMove = bestMoveFinder2.defendMyKing(color);
		int stuff = 0;
		for (Entry<Integer, Move> e : meMoves.entrySet()) {
			if (depth > 0) {
				stuff += recursiveMove(makeMove(b, highValueMove), depth - 1);
			}
			if (e.getKey() + stuff > bestMoveSoFar) {
				bestMoveSoFar = e.getKey();
				highValueMove = e.getValue();
			}
		}
		return bestMoveSoFar;
	}

	private Board boardBuilder(HashMap<Point, Piece> pieceLocations2) {
		Board b = new Board();
		Piece[][] temp = new Piece[8][8];
		for (Entry<Point, Piece> e : pieceLocations2.entrySet()) {
			// System.out.println(pieceLocations.toString());
			temp[(int) e.getKey().getX()][(int) e.getKey().getY()] = e.getValue();
		}
		b.setBoardArray(temp);
		return b;
	}
}
