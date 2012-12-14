package communicator;

import gui.IntegratedGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import sharedfiles.Board;
import sharedfiles.Piece;

public class AIServer {

	private static int port = 8080;

	public synchronized static void main(String[] args) {

		ServerSocket myServerSocket;

		Socket client;
		Socket client2;
		BufferedReader in;
		PrintStream out;
		BufferedReader in2;
		PrintStream out2;

		Scanner scan = new Scanner(System.in);

		String[] stuff = new String[8];
		try {
			System.out.println("Server started");
			myServerSocket = new ServerSocket(port);
			client = myServerSocket.accept();
			System.out.println("Got client 1");
			client2 = myServerSocket.accept();
			System.out.println("Got client 2");
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
			out2 = new PrintStream(client2.getOutputStream());
			Board b = new Board();
			IntegratedGUI gui = new IntegratedGUI(b);
			gui.getFrame().setVisible(true);
			Piece[][] arr = b.getBoardArray();
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 8; x++) {
					if (stuff[y] == null) {
						stuff[y] = (arr[x][y].toString() + " | ");
					} else {
						stuff[y] = stuff[y] + (arr[x][y].toString() + (x == 7 ? "" : " | "));
					}
				}

			}
			for (int i = 0; i < 25; i++) {
				String line = "";
				System.out.println();
				System.out.println("Client 1 move");
				for (int j = 0; j < 8; j++) {
					out.println(stuff[j]);
				}
				out.println(".");
				int h = 0;
				while (true) {
					if ((line = in.readLine()) == null) {
					} else {
						if (line.equals(".")) {
							break;
						}
						stuff[h] = line;
						h++;
					}
				}
				System.out.println(stuff);
				b.buildBoard(stuff);
				b.printBoard();
				gui.redraw(b);
				System.out.println();
				scan.nextLine();
				System.out.println("Client 2 move");
				for (int j = 0; j < 8; j++) {
					out2.println(stuff[j]);
				}
				out2.println(".");
				int p = 0;
				while (true) {
					if ((line = in2.readLine()) == null) {
					} else {
						if (line.equals(".")) {
							break;
						}
						stuff[p] = line;
						p++;
					}
				}
				b.buildBoard(stuff);
				b.printBoard();
				gui.redraw(b);
				scan.nextLine();
			}
			System.out.println("done!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
