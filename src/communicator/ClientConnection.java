package communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClientConnection implements Runnable {

	Socket client;
	BufferedReader in;
	PrintStream out;

	public ClientConnection(Socket client) {
		this.client = client;

	}

	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			String line = "";
			while ((line = in.readLine()) != null) {
				System.out.println(line);
				out.println(line + 1);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
