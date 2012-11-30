package DerpyAI;
import java.awt.Point;

public class DerpyAICheckTester extends DerpyAI {


	public static void main(String[] args) { 
		DerpyAICheckTester tester = new DerpyAICheckTester(true);
		DerpyBoard b = tester.currentBoard;
		b.clearPieces();
		for(int y = 0; y < 8; y++) {
			b.getBoardArray()[7][y] = new DerpyRook(false, new Point(7,y));
		}
		
		b.getBoardArray()[4][0] = new DerpyKing(true, new Point(4,0));
		
		b.printBoard();
		
		System.out.print("Test result: "); if(tester.inCheck())System.out.println("Passed"); else System.out.println("Failed");
	}

	public DerpyAICheckTester(Boolean b) {
		super(b);
	}


}
