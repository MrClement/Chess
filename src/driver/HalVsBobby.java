package driver;

import generalChess.v1Bobby;
import ClementEhrenfriedAI.Hal;

public class HalVsBobby {

	public HalVsBobby() {

		sharedfiles.Board b = new sharedfiles.Board();
		Hal hal = new Hal(true, b);
		System.out.println();
		b.printBoard();
		System.out.println();

		System.out.println("Hal:");
		b = hal.nextMove(b);
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
			System.out.println("Hal:");
			b = hal.nextMove(b);
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
