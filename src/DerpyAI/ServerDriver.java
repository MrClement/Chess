package DerpyAI;

import java.net.Socket;
import java.util.Scanner;

public class ServerDriver {

	public static final String hostname = "localhost";
	public static final int port = 8080;
	
	public static void main(String[] args) {
		
		System.out.println("DerpyAI ServerDriver v1");
		System.out.println("Configured to connect to " + hostname + " on port " + port);
		System.out.print("Select white (w) or black (b): ");
		Scanner s = new Scanner(System.in);
		String c = s.nextLine();
		char ch = c.charAt(0);
		
		DerpyAI ai = null;
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
		
		Socket myClient = null;
		try {
			System.out.println("Establishing socket connection...");
			myClient = new Socket(hostname, port);
		}
		catch (Exception e) {
			
			
		}
		
		
	}

}
