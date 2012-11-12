package generalChess;

import sharedfiles.Board;
import sharedfiles.Piece;

import java.awt.Point;
import java.util.ArrayList;
public class maxTestClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);

		a.move(2,7,5,3);
		a.move(3,0,4,2);
	
		//a.move(6,1,4,3);
		//a.move(2,0,2,3);
		//a.move(7,7,3,4);
		a.printBoard();
		ArrayList<Point> bob=a.newBestPieceToTake();
		
		a.move((int)bob.get(0).getX(),(int)bob.get(0).getY(),(int)bob.get(1).getX(),(int)bob.get(1).getY())	;
		a.printBoard();
		a.move((int) a.newBestPieceToTake().get(0).getX(), (int) a.newBestPieceToTake().get(0).getY(), (int) a.newBestPieceToTake()
					.get(1).getX(), (int) a.newBestPieceToTake().get(1).getY());

			a.printBoard();
		System.out.println(a.newBestPieceToTake());
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
