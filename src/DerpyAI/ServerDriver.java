package DerpyAI;

import java.util.Scanner;

public class ServerDriver {

	public static final String hostname = "localhost";
	public static final int port = 8080;
	
	public static void main(String[] args) {
		
		System.out.print("Select white (w) or black (b): ");
		Scanner s = new Scanner(System.in);
		String c = s.nextLine();
		char ch = c.charAt(0);
		
		DerpyAI ai;
		switch(ch) {
			case 'w':
				ai = new DerpyAI(true);
				break;
			case 'b':
				ai = new DerpyAI(false);
				break;
			default:
				System.out.println("Unrecognized character, assuming white.");
				ai = new DerpyAI(true);
				break;
		}
		
		
		
		
	}

}
