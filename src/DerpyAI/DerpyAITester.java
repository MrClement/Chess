package DerpyAI;

import java.awt.Point;

//NOTE TO EVERYONE
//This is Preston's pieceCanMoveToPosition tester class. Please do not delete!

public class DerpyAITester extends DerpyAI {

	public static void main(String[] args) {
		DerpyAITester tester = new DerpyAITester(true);

		DerpyBoard b = new DerpyBoard();

		System.out.println("Pawns\n");
		System.out.print("Test 0: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[0][1], new Point(0,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 1: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[1][1], new Point(1,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 2: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[2][1], new Point(2,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 3: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[3][1], new Point(3,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 4: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[4][1], new Point(4,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 5: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[5][1], new Point(5,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 6: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[6][1], new Point(6,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 7: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[7][1], new Point(7,
				2))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}

		System.out.print("Test 8: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[0][1], new Point(0,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 9: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[1][1], new Point(1,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 10: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[2][1], new Point(2,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 11: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[3][1], new Point(3,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 12: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[4][1], new Point(4,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 13: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[5][1], new Point(5,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 14: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[6][1], new Point(6,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 15: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[7][1], new Point(7,
				3))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}

		System.out.println("\nBishops\n");
		b.getBoardArray()[3][1] = new DerpyBlank(new Point(3, 1));
		System.out.print("Test 16: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[2][0], new Point(3,
				1))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 17: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[2][0], new Point(6,
				4))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}

		System.out.println("\nRooks\n");
		b.getBoardArray()[0][1] = new DerpyBlank(new Point(0, 1));
		b.getBoardArray()[7][1] = new DerpyBlank(new Point(7, 1));
		System.out.print("Test 18: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[0][0], new Point(0,
				4))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 19: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[7][0], new Point(7,
				4))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 20: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[0][0], new Point(0,
				1))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 21: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[7][0], new Point(7,
				1))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}

		System.out.println("\nQueen\n");
		System.out.print("Test 22: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[3][0], new Point(3,
				4))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}
		System.out.print("Test 23: ");
		if (tester.pieceCanMoveToPosition(b.getBoardArray()[3][0], new Point(3,
				1))) {
			System.out.println("Passed");
		} else {
			System.out.println("FAILED!  <<<");
		}

	}

	public DerpyAITester(Boolean b) {
		super(b);
	}

}
