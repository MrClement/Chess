package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

import sharedfiles.Blank;
import sharedfiles.Board;
import sharedfiles.King;
import sharedfiles.Piece;

public class Hal {

	private HashMap<Point, Piece> pieceLocations;
	private Movement availableMoves;
	private boolean color;
	private HashMap<Integer, Move> movesToMake;
	private int moveCounter;
	MoveSelector bestMoveFinder;

	public Hal(boolean color, Board b) {
		this.color = color;
		moveCounter = 0;
		movesToMake = new HashMap<Integer, Move>();
		BoardParser bp = new BoardParser(b);
		pieceLocations = bp.getPieceLocations();
		availableMoves = new Movement(pieceLocations);
		availableMoves.findMoves();
		bestMoveFinder = new MoveSelector(availableMoves);
		// indianDefense();
	}

	public Board nextMove(Board b) {
		// return simpleMove(b);
		RecursiveMove r = new RecursiveMove(b, color);
		return r.recursiveMoveStarter(true);
	}

	public Board simpleMove(Board b) {

		if (weHaveLost()) {
			System.out.println("OH NOES!");
			return b;
		}

		BoardParser bp = new BoardParser(b);
		pieceLocations = bp.getPieceLocations();
		availableMoves = new Movement(pieceLocations);
		availableMoves.findMoves();

		Move bestMove;
		if (!movesToMake.isEmpty()) {
			bestMove = movesToMake.remove(moveCounter);
			moveCounter++;
		} else {
			bestMove = bestMoveFinder.optimalMove(color);

		}
		pieceLocations.remove(bestMove.getDestination());
		pieceLocations.remove(bestMove.getOrigin());
		pieceLocations.put(bestMove.getDestination(), bestMove.getPieceToMove());
		pieceLocations.put(bestMove.getOrigin(), new Blank(true));
		b = boardBuilder();

		return b;

	}

	public Board oldMove(Board b) {

		b.printBoard();
		color = true; // fix white and black

		BoardParser bp = new BoardParser(b);
		pieceLocations = bp.getPieceLocations();
		availableMoves = new Movement(pieceLocations);
		availableMoves.findMoves();
		MoveSelector bestMoveFinder = new MoveSelector(availableMoves);
		Move bestMove = bestMoveFinder.goThroughMoves(color);
		System.out.println(bestMove.toString());
		pieceLocations.remove(bestMove.getDestination());
		pieceLocations.put(bestMove.getDestination(), bestMove.getPieceToMove());
		pieceLocations.put(bestMove.getOrigin(), new Blank(true));
		b = boardBuilder();

		return b;
	}

	private Board boardBuilder() {
		Board b = new Board();
		Piece[][] temp = new Piece[8][8];
		for (Entry<Point, Piece> e : pieceLocations.entrySet()) {
			// System.out.println(pieceLocations.toString());
			temp[(int) e.getKey().getX()][(int) e.getKey().getY()] = e.getValue();
		}
		b.setBoardArray(temp);
		return b;
	}

	public void indianDefense() {

		Move tempMove;
		Point tempPoint;
		tempPoint = new Point(3, 6);
		tempMove = new Move(tempPoint, availableMoves.pieceMove(tempPoint, 0, -2), pieceLocations.get(tempPoint));
		movesToMake.put(0, tempMove);
		tempPoint = new Point(2, 6);
		tempMove = new Move(tempPoint, availableMoves.pieceMove(tempPoint, 0, -2), pieceLocations.get(tempPoint));
		movesToMake.put(1, tempMove);

	}

	public boolean weHaveLost() {
		King k = new King(color);
		for (Piece p : pieceLocations.values()) {
			if (p.toString().equals(k.toString()))
				return false;
		}
		return true;
	}

	public boolean weHaveLost(HashMap<Point, Piece> p2, boolean color2) {
		King k = new King(color2);
		for (Piece p : p2.values()) {
			if (p.toString().equals(k.toString()))
				return false;
		}
		return true;

	}

	public Board nextMoveNoRecursion(Board b) {
		RecursiveMove r = new RecursiveMove(b, color);
		return r.recursiveMoveStarter(false);
	}

}
