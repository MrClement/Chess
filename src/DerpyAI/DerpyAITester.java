package DerpyAI;

import java.awt.Point;


//NOTE TO EVERYONE
//This is Preston's pieceCanMoveToPosition tester class. Please do not delete!

public class DerpyAITester extends DerpyAI {

	public static void main(String[] args) {
		DerpyAITester tester = new DerpyAITester(true);
		
		DerpyBoard b = new DerpyBoard();
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[0][1], new Point(0,2)))System.out.println("Test 0: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[1][1], new Point(1,2)))System.out.println("Test 1: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[2][1], new Point(2,2)))System.out.println("Test 2: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[3][1], new Point(3,2)))System.out.println("Test 3: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[4][1], new Point(4,2)))System.out.println("Test 4: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[5][1], new Point(5,2)))System.out.println("Test 5: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[6][1], new Point(6,2)))System.out.println("Test 6: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[7][1], new Point(7,2)))System.out.println("Test 7: Passed");
		
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[0][1], new Point(0,3)))System.out.println("Test 8: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[1][1], new Point(1,3)))System.out.println("Test 9: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[2][1], new Point(2,3)))System.out.println("Test 10: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[3][1], new Point(3,3)))System.out.println("Test 11: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[4][1], new Point(4,3)))System.out.println("Test 12: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[5][1], new Point(5,3)))System.out.println("Test 13: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[6][1], new Point(6,3)))System.out.println("Test 14: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[7][1], new Point(7,3)))System.out.println("Test 15: Passed");
		
		b.getBoardArray()[3][1] = new DerpyBlank(new Point(3,1));
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[2][0], new Point(3,1)))System.out.println("Test 16: Passed");
		if(tester.pieceCanMoveToPosition(b.getBoardArray()[2][0], new Point(6,4)))System.out.println("Test 17: Passed");
		
	}
	
	public DerpyAITester(Boolean b) {
		super(b);
	}
	
	

}
