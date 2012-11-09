package generalChess;

import sharedfiles.Board;

import java.awt.Point;
public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);

		a.move(0,6,1,2);
		a.move(1,6,2,3);
		a.move(3,7,0,3);
		a.printBoard();
		System.out.println(a.numDefenders(1,2));
		System.out.println(a.numDefenderValue(1,2));
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		System.out.println(a.kMovesDefending());
		System.out.println(a.qMovesDefending());
		System.out.println(a.pMovesDefending());
		
	
		
		System.out.println(a.allMoves());
		}
	
}
