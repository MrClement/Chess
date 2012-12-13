package driver;

import sharedfiles.Board;
import ClementEhrenfriedAI.Hal;
import DerpyAI.DerpyAI;
import DerpyAI.DerpyBoard;

public class HalVsDerpy {

	public HalVsDerpy() {
		Board b = new Board();
		b.printBoard();
		System.out.println();

		System.out.println("Hal:");
		Hal test = new Hal(true, b);
		b = test.nextMove(b);
		b.printBoard();
		System.out.println();

		System.out.println("Derpy:");
		DerpyBoard db = new DerpyBoard(b);
		DerpyAI aiOne = new DerpyAI(false);
		db = aiOne.makeMove(db);
		b = db.boardEquiv();
		b.printBoard();
		System.out.println();

		// long start;
		for (int i = 0; i < 100; i++) {
			// start = System.currentTimeMillis();

			System.out.println("Hal:");
			System.out.println();
			b = test.nextMove(b);
			b.printBoard();
			System.out.println();

			System.out.println("Derpy:");
			db = new DerpyBoard(b);
			db = aiOne.makeMove(db);
			b = db.boardEquiv();
			b.printBoard();
			System.out.println();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);
		}

	}

}
