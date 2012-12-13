package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

import sharedfiles.Board;
import sharedfiles.Piece;

public class Evaluator {

	private Board b;
	private HashMap<Point, Piece> pieceLocations;
	private boolean color;
	private RecursiveMove r;

	public Evaluator(Board b, boolean color) {
		this.b = b;
		this.color = color;
		r = new RecursiveMove(b, color);
		BoardParser bp = new BoardParser(b);
		pieceLocations = bp.getPieceLocations();
	}

	public HashMap<Integer, Move> evaluateAllMoves() {
		Move m;
		HashMap<Integer, Move> allMoves = new HashMap<Integer, Move>();
		Movement availableMoves = new Movement(pieceLocations);
		availableMoves.findMoves();
		MoveSelector bestMoveFinder2 = new MoveSelector(availableMoves);
		for (Entry<Point, ChessSquare> e : bestMoveFinder2.getPotentialMoves().entrySet()) {
			for (Entry<Point, Piece> f : e.getValue().getInbound(color).entrySet()) {
				m = new Move(f.getKey(), e.getKey(), f.getValue());
				Board tempBoard = r.makeMove(b, m);
				Evaluator ev = new Evaluator(tempBoard, color);
				int[] temp = ev.valueOfBoard();
				allMoves.put(temp[0] - temp[1], m);
				// System.out.println("Ours: " + temp[0] + "  Theirs: " +
				// temp[1]);
			}
		}
		return allMoves;
	}

	public int[] valueOfBoard() {
		int myPieces = 0;
		int theirPieces = 0;
		for (Entry<Point, Piece> e : pieceLocations.entrySet()) {
			String temp = e.getValue().toString();
			switch (temp.charAt(1)) {
				case 'B':
					if (temp.charAt(0) == 'W') {
						myPieces += 3;
					} else {
						theirPieces += 3;
					}
					break;
				case 'K':
					if (temp.charAt(0) == 'W') {
						myPieces += 50;
					} else {
						theirPieces += 70;
					}
					break;
				case 'Q':
					if (temp.charAt(0) == 'W') {
						myPieces += 10;
					} else {
						theirPieces += 10;
					}
					break;
				case 'N':
					if (temp.charAt(0) == 'W') {
						myPieces += 3;
					} else {
						theirPieces += 3;
					}
					break;
				case 'R':
					if (temp.charAt(0) == 'W') {
						myPieces += 5;
					} else {
						theirPieces += 5;
					}
					break;
				case 'P':
					if (temp.charAt(0) == 'W') {
						myPieces += 1;
					} else {
						theirPieces += 1;
					}
					break;
				default:
					break;
			}
		}
		int[] temp = new int[2];
		temp[0] = myPieces;
		temp[1] = theirPieces;
		return temp;
	}

}
