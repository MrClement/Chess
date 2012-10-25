package communicator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import sharedfiles.Board;
import sharedfiles.Piece;

public class Server {

	private static int port = 8080;
	private static int maxConnections = 2;

	public static void main(String[] args) {

		ServerSocket myServerSocket;
		Socket client;
		int connections = 0;
		String[] stuff = new String[8];
		try {
			myServerSocket = new ServerSocket(port);
			while (connections < maxConnections) {
				client = myServerSocket.accept();
				Thread t;
				Thread u;
				Board b = new Board();
				Piece[][] arr = b.getBoardArray();
				for (int y = 0; y < 8; y++) {

					for (int x = 0; x < 8; x++) {
						if (stuff[y] == null) {
							stuff[y] = (arr[x][y].toString() + " | ");
						} else {
							stuff[y] = stuff[y] + (arr[x][y].toString() + " | ");
						}
					}

				}
				if (connections == 0) {
					System.out.println("WOW");
					t = new Thread(new ClientConnection(client, stuff));
					t.start();
				} else {
					System.out.println("WOW2");
					u = new Thread(new ClientConnection(client, stuff));
					u.start();
				}
				System.out.println(stuff[0]);
				connections++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
