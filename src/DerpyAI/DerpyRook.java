package DerpyAI;
import java.awt.Point;

import sharedfiles.*;

public class DerpyRook extends Rook {
	
	private Point currentLocation;
	
	public DerpyRook(boolean b, Point p){
		super(b);
		currentLocation = p; 
		}

		public Point getLocation(){
			return currentLocation; 
		}


}
