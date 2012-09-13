package DerpyAI;
import java.awt.Point;

import sharedfiles.*; 
public class DerpyKing extends King {
	
	private Point currentLocation; 
	
	public DerpyKing(boolean b, Point p){
		super(b);
		currentLocation = p; 
	}

	public Point getLocation(){
			return currentLocation; 
	}

}
