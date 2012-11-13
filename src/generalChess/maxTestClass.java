package generalChess;

import sharedfiles.Board;
import sharedfiles.Piece;

import java.awt.Point;
import java.util.ArrayList;
public class maxTestClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);

		
		Point w = new Point(3,4);
		Point y = new Point(3,4);
		
		System.out.println(w==y);
		System.out.println(w.equals(y));
		
		a.move(2,7,5,3);
		a.move(3,0,4,2);
	
		//a.move(6,1,4,3);
		//a.move(2,0,2,3);
		//a.move(7,7,3,4);
		a.printBoard();
		a.newBestPieceToTake();
		a.printBoard();
		
		a.printBoard();
		System.out.println(a.allMoves().get(13).get(a.takeIfPossible(a.allMoves().get(13))));
		
		a.printBoard();
		System.out.println(a.numDefenders(1,4));
		System.out.println(a.numDefenderValue(1,4));
		System.out.println(a.bMovesDefending());
		a.randomMove();
		a.printBoard();
		a.randomMove();
		v1Bobby x=new v1Bobby(a.getB(), false);
		x.move(4,1,4,2);
		x.printBoard();
		System.out.println(a.takeIfPossible(a.allMoves().get(15)));
		System.out.println(x.numDefenders(4, 2));
	
		
		System.out.println(a.allMoves());
		}
	
}
