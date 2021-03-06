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
	private String[] boardStrings;

	public ClientConnection(Socket client, String[] stuff) {
		this.client = client;
		setBoardStrings(stuff);

	}

	@Override
	public synchronized void run() {
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
			String line = "";
			int i = 0;
			while (true) {
				line = in.readLine();
				if (!line.equals(".")) {
					boardStrings[i] = line;
					i++;
				}
				i = 0;
				wait();

			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String[] getBoardStrings() {
		return boardStrings;
	}

	public void setBoardStrings(String[] boardStrings) {
		this.boardStrings = boardStrings;
	}

}
