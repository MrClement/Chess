package DerpyAI;
import java.awt.Point;

import java.util.ArrayList;

import sharedfiles.Board;
import sharedfiles.Piece;

public class Driver {

	public static void main(String[] args) {
	DerpyPawn b = new DerpyPawn(false, new Point(0,0));
	System.out.println(b.changeLocation(new Point(0,2)));
	System.out.println(b.changeLocation(new Point(0,4)));
	System.out.println(b.getLocation());
	System.out.println(b.changeLocation(new Point(0,3)));
	System.out.println(b.getLocation());
	}

}
