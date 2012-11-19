package DerpyAI;

import java.awt.Point;


//NOTE TO EVERYONE
//This is Preston's pieceCanMoveToPosition tester class. Please do not delete!

public class DerpyAITester extends DerpyAI {

	public static void main(String[] args) {
		DerpyAITester tester = new DerpyAITester(true);
		
		DerpyBoard b = new DerpyBoard();
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[0][1], new Point(0,2)))System.out.println("Test 1: Passed");
	}
	
	public DerpyAITester(Boolean b) {
		super(b);
	}
	
	

}
