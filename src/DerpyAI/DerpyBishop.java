package DerpyAI;
import sharedfiles.*;
import java.awt.Point; 

public class DerpyBishop extends Bishop {
	
	private Point currentLocation; 
	
	public DerpyBishop(boolean b, Point p) {
		super(b);
		currentLocation = p; 
	}

	public Point getLocation(){
		return currentLocation; 
	}

}
