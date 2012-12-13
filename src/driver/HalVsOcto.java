package driver;

import octo.AI;
import sharedfiles.Board;
import ClementEhrenfriedAI.Hal;

public class HalVsOcto {

	public HalVsOcto() {

		Board b = new Board();

		Hal hal = new Hal(true, b);
		System.out.println();
		b.printBoard();
		System.out.println();

		System.out.println("Hal:");
		b = hal.nextMove(b);
		b.printBoard();
		System.out.println();

		System.out.println("OCTO:");
		AI octo = new AI();
		octo.setColor('B');
		b = octo.takeTurn(b);
		b.printBoard();

		// long start;
		for (int i = 0; i < 50; i++) {

			System.out.println();
			System.out.println("Hal:");
			b = hal.nextMove(b);
			b.printBoard();
			System.out.println();
			System.out.println("OCTO:");
			b = octo.takeTurn(b);
			b.printBoard();

			// float time = System.currentTimeMillis() - start;
			// time = time / 1000F;
			// System.out.println(time);

		}

	}
}
