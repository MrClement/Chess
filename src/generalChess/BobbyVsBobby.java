package generalChess;

import sharedfiles.Board;

public class BobbyVsBobby {
	public static void main(String[] args) {

		v1Bobby a = new v1Bobby(new Board(), true);
		v1Bobby b = new v1Bobby(new Board(), false);

		for (int i = 0; i < 200; i++) {
			a.turn(b.getB());
			a.printBoard();
			System.out.println();

			b.turn(a.getB());
			b.printBoard();
			System.out.println();
		}

	}

}
