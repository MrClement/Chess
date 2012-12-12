package DerpyAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import sharedfiles.Board;
import sharedfiles.Piece;

public class ServerDriver {

	public static final String hostname = "10.80.4.31";
	public static final int port = 8080;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

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

		Socket client = null;
		try {
			System.out.println("Establishing socket connection...");
			client = new Socket(hostname, port);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		BufferedReader in = null;
		PrintStream out = null;

		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		//String[] stuff = new String[8];
		//ArrayList<String> stuff = new ArrayList<String>();

		//while(true) loop
		while (true) {
			ArrayList<String> stuff = new ArrayList<String>();
			String line = in.readLine();
			while(true) {
				if(line == null)in.readLine();
				else {

					if(line.equals("."))break;

					stuff.add(line);
					line = in.readLine();

				}
			}
			String[] stuffArr = stuff.toArray(new String[stuff.size()]);
			//System.out.println(stuffArr);
			Board board = new Board();
			board.buildBoard(stuffArr);
			DerpyBoard input = new DerpyBoard(board);
			input = ai.makeMove(input);

			Board equiv = input.boardEquiv();
			Piece[][] arr = equiv.getBoardArray();
			for (int y = 0; y < 8; y++) {

				for (int x = 0; x < 8; x++) {
					out.print((arr[x][y].toString()) + " | ");
				}
				out.println();

			}
			out.println(".");
		}
		//end while(true) loop

	}

}
