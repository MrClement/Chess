package DerpyAI;
import java.awt.Point;

import sharedfiles.*; 
public class DerpyQueen extends Queen {
	
	private Point currentLocation;
	
	public DerpyQueen(boolean b, Point p){
		super(b);
		currentLocation = p; 
		}

		public Point getLocation(){
			return currentLocation; 
		}


}
