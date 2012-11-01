package communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import sharedfiles.Board;
import sharedfiles.Piece;

public class CopyOfServer {

	private static int port = 8080;
	private static int maxConnections = 2;

	public static void main(String[] args) {

		ServerSocket myServerSocket;

		Socket client;
		Socket client2;
		BufferedReader in;
		PrintStream out;
		BufferedReader in2;
		PrintStream out2;

		String[] stuff = new String[8];
		try {
			myServerSocket = new ServerSocket(port);
			client = myServerSocket.accept();
			client2 = myServerSocket.accept();
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			in2 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
			out2 = new PrintStream(client2.getOutputStream());
			Board b = new Board();
			Piece[][] arr = b.getBoardArray();
			for (int y = 0; y < 8; y++) {
				for (int x = 0; x < 8; x++) {
					if (stuff[y] == null) {
						stuff[y] = (arr[x][y].toString() + " | ");
					} else {
						stuff[y] = stuff[y] + (arr[x][y].toString() + (y == 8 ? "" : " | "));
					}
				}

			}
			for (int i = 0; i < 25; i++) {
				String line = "";
				for (int j = 0; j < 8; j++) {
					out.println(stuff[j]);
				}
				out.println(".");
				for (int j = 0; j < 8; j++) {
					line = in.readLine();
					if (line.equals("."))
						break;
					stuff[j] = line;
				}
				for (int j = 0; j < 8; j++) {
					out2.println(stuff[j]);
				}
				out2.println(".");
				for (int j = 0; j < 8; j++) {
					line = in2.readLine();
					if (line.equals("."))
						break;
					stuff[j] = line;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
