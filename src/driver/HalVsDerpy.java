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
		DerpyBoard db = new DerpyBoard(b);
		db.printBoard();
		System.out.println();

		System.out.println("Derpy:");
		DerpyAI aiOne = new DerpyAI(true);
		db = aiOne.makeMove(db);
		b = db.boardEquiv();
		b.printBoard();
		System.out.println();

		System.out.println("Hal:");
		Hal test = new Hal(false, b);
		b = test.nextMove(b);
		b.printBoard();
		System.out.println();
		// long start;
		for (int i = 0; i < 50; i++) {
			// start = System.currentTimeMillis();

			System.out.println("Derpy:");
			db = new DerpyBoard(b);
			db = aiOne.makeMove(db);
			b = db.boardEquiv();
			b.printBoard();
			System.out.println();

			System.out.println("Hal:");
			System.out.println();
			b = test.nextMove(b);
			b.printBoard();
			System.out.println();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);
		}

	}

}
