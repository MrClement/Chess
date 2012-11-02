package generalChess;

import sharedfiles.Board;

import java.awt.Point;
public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);
		a.move(2, 0, 2, 3);
		a.move(3, 7, 3, 4);
		System.out.println(a.bestPieceToTake().get(1)+" -- "+a.bestPieceToTake().get(1) );
		}
	
}
