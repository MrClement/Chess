package DerpyAI;
import java.awt.Point;

import sharedfiles.*; 

public class DerpyPawn extends Pawn {
	
	private Point currentLocation; 
	
	public DerpyPawn(boolean b, Point p){
		super(b);
		currentLocation = p; 
		}

		public Point getLocation(){
			return currentLocation; 
		}



}
