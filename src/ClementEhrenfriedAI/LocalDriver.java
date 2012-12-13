package ClementEhrenfriedAI;

import sharedfiles.Board;

public class LocalDriver {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		System.out.println();

		Hal me = new Hal(true, b);
		b = me.nextMove(b);
		b.printBoard();
		System.out.println();

		Hal them = new Hal(false, b);
		b = them.nextMove(b);
		b.printBoard();
		System.out.println();

		for (int i = 0; i < 20; i++) {
			me = new Hal(true, b);
			b = me.nextMove(b);
			b.printBoard();
			System.out.println();

			them = new Hal(false, b);
			b = them.nextMove(b);
			b.printBoard();
			System.out.println();
		}

	}

}
