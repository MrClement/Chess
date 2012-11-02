package driver;

import generalChess.v1Bobby;
import octo.AI;
import sharedfiles.Board;

public class BobbyVsOcto {

	public BobbyVsOcto() {

		Board b = new Board();
		v1Bobby bobby = new v1Bobby(b, false);
		System.out.println();
		b.printBoard();
		System.out.println();

		System.out.println("OCTO:");
		AI octo = new AI();
		octo.setColor('W');
		b = octo.takeTurn(b);
		b.printBoard();

		System.out.println("BOBBY:");
		// b.setBoardArray(bobby.turn(b));
		b.printBoard();
		System.out.println();

		// long start;
		for (int i = 0; i < 50; i++) {
			// start = System.currentTimeMillis();
			System.out.println();
			System.out.println("OCTO:");
			b = octo.takeTurn(b);
			b.printBoard();
			System.out.println();
			System.out.println("BOBBY:");
			// b.setBoardArray(bobby.turn(b));
			b.printBoard();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);

		}

	}
}
