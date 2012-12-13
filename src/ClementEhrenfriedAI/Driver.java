package ClementEhrenfriedAI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import sharedfiles.Board;
import sharedfiles.Piece;

public class Driver {

	private static String hostname = "localhost";
	private static int port = 8080;
	private static boolean color = false;

	public synchronized static void main(String[] args) {

		BufferedReader in;
		PrintStream out;

		Board b = new Board();
		Hal test = new Hal(color, b);

		Socket myClient;
		try {
			myClient = new Socket(hostname, port);
			in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
			out = new PrintStream(myClient.getOutputStream());
			String line = "";
			while (true) {
				String[] stuff = new String[8];
				int j = 0;
				while (true) {
					if ((line = in.readLine()) == null) {
					} else {
						if (line.equals(".")) {
							break;
						}
						stuff[j] = line;
						j++;
					}
				}
				b.buildBoard(stuff);
				b = test.nextMove(b);
				Piece[][] arr = b.getBoardArray();
				stuff = new String[8];
				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						if (stuff[y] == null) {
							stuff[y] = (arr[x][y].toString() + " | ");
						} else {
							stuff[y] = stuff[y] + (arr[x][y].toString() + (x == 7 ? "" : " | "));
						}
					}

				}
				for (int i = 0; i < 8; i++) {
					out.println(stuff[i]);
				}
				System.out.println(".");
				out.println(".");
				out.flush();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
