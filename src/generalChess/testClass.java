package generalChess;

import sharedfiles.Board;

public class testClass {
	public static void main(String[] args) {
		Board b = new Board();
		Bobby BoardLords = new Bobby(false, b);
		BoardLords.printBoard();
	}
}
