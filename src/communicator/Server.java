package communicator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static int port = 8080;

	public static void main(String[] args) {

		ServerSocket myServerSocket;
		Socket client;

		try {
			myServerSocket = new ServerSocket(port);
			while (true) {
				client = myServerSocket.accept();
				Thread t = new Thread(new ClientConnection(client));
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
