package ClementEhrenfriedAI;

import java.awt.Point;
import java.util.HashMap;

import sharedfiles.Board;
import sharedfiles.Piece;

public class BoardParser {

	private HashMap<Point, Piece> pieceLocations = new HashMap<Point, Piece>();

	public BoardParser(Board b) {

		Piece[][] boardState = b.getBoardArray();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				getPieceLocations().put(new Point(i, j), boardState[i][j]);

			}

		}

	}

	public HashMap<Point, Piece> getPieceLocations() {
		return pieceLocations;
	}

}
