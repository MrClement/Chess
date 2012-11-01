package generalChess;

import sharedfiles.Board;

import java.awt.Point;
public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);
		a.printBoard();


		a.move((int)((Point)a.bestPieceToTake().get(0)).getX(),(int)((Point)a.bestPieceToTake().get(0)).getY(), (int)((Point)a.bestPieceToTake().get(1)).getX(), (int)((Point)a.bestPieceToTake().get(1)).getY());
		a.printBoard();
		

		a.printBoard();
		
		System.out.println((int)((Point)a.bestPieceToTake().get(1)).getX());
		System.out.println((int)((Point)a.bestPieceToTake().get(1)).getY());
		System.out.println((int)((Point)a.bestPieceToTake().get(2)).getX());
		System.out.println((int)((Point)a.bestPieceToTake().get(2)).getY());
		a.move((int)((Point)a.bestPieceToTake().get(0)).getX(),(int)((Point)a.bestPieceToTake().get(0)).getY(), (int)((Point)a.bestPieceToTake().get(1)).getX(), (int)((Point)a.bestPieceToTake().get(1)).getY());
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		a.randomMove();
		a.printBoard();
		}
	
}
