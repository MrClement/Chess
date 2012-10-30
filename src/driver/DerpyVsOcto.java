package driver;

import octo.AI;
import sharedfiles.Board;
import DerpyAI.DerpyAI;
import DerpyAI.DerpyBoard;

public class DerpyVsOcto {
	public DerpyVsOcto() {

		Board b = new Board();
		b.printBoard();
		System.out.println();
		DerpyBoard db = new DerpyBoard(b);
		System.out.println();

		System.out.println("Derpy:");
		DerpyAI aiOne = new DerpyAI(true);
		db = aiOne.makeMove(db);
		b = db.boardEquiv();
		b.printBoard();
		System.out.println();

		System.out.println("OCTO:");
		AI octo = new AI();
		octo.setColor('B');
		b = octo.takeTurn(b);
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

			System.out.println("OCTO:");
			b = octo.takeTurn(b);
			b.printBoard();
			System.out.println();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);
		}
	}

}
