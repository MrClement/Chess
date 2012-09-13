package DerpyAI;
import java.awt.Point;

import sharedfiles.*;

public class DerpyKnight extends Knight{
	
	private Point currentLocation;
	
	public DerpyKnight(boolean b, Point p){
		super(b);
		currentLocation = p; 
		}

		public Point getLocation(){
			return currentLocation; 
		}


}
