package DerpyAI;
import java.util.ArrayList;
import java.awt.Point; 


public class Driver {

	public static void main(String[] args) {

		
		//October 7 2012: This needs to stay like this, folks! An AI is created, it's passed board, makes a move, returns the board, and prints it
		
		
		DerpyBoard db = new DerpyBoard();
		DerpyAI aiOne = new DerpyAI(true);
		System.out.println(db.getBoardArray()[5][6].toString());
		System.out.println(db.getBoardArray()[4][6].toString());
		System.out.println(aiOne.pieceCanMoveToPosition(db.getBoardArray()[5][6],new Point(5,5)));
		System.out.println(aiOne.pieceCanMoveToPosition(db.getBoardArray()[5][6],new Point(5,4)));
		System.out.println(aiOne.pieceCanMoveToPosition(db.getBoardArray()[4][6],new Point(4,5)));
		System.out.println("Array List 1: " + aiOne.movablePoints(db.getBoardArray()[5][6]));
		db = aiOne.randomMove();

		db.printBoard();
		
	}

}
