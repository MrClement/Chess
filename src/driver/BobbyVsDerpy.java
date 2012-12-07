package driver;

import generalChess.v1Bobby;
import sharedfiles.Board;
import DerpyAI.DerpyAI;
import DerpyAI.DerpyBoard;

public class BobbyVsDerpy {

	public BobbyVsDerpy() {
		Board b = new Board();
		b.printBoard();
		System.out.println();
		DerpyBoard db = new DerpyBoard(b);
		db.printBoard();
		System.out.println();

		System.out.println("Derpy:");
		DerpyAI aiOne = new DerpyAI(true);
		db = aiOne.makeMove(db);
		b = db.boardEquiv();
		b.printBoard();
		System.out.println();

		v1Bobby bobby = new v1Bobby(b, false);
		System.out.println("Bobby:");
		b.setBoardArray(bobby.turn(b.getBoardArray()));
		b.printBoard();
		// long start;
		for (int i = 0; i < 100; i++) {
			// start = System.currentTimeMillis();
			System.out.println();
			System.out.println("Derpy:");
			db = new DerpyBoard(b);
			db = aiOne.makeMove(db);
			b = db.boardEquiv();
			b.printBoard();
			System.out.println();
			System.out.println("Bobby:");
			b.setBoardArray(bobby.turn(b.getBoardArray()));
			b.printBoard();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);

		}

	}

}
