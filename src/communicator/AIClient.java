package communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class AIClient {

	private static String hostname = "localhost";
	private static int port = 8080;

	public static void main(String[] args) {

		BufferedReader in;
		PrintStream out;

		Socket myClient;
		try {
			myClient = new Socket(hostname, port);
			in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
			out = new PrintStream(myClient.getOutputStream());
			String line = "";
			String[] stuff = new String[8];
			while (true) {
				for (int j = 0; j < 8; j++) {
					line = in.readLine();
					if (line.equals("."))
						break;
					stuff[j] = line;
				}
				for (int j = 0; j < 8; j++) {
					System.out.println(stuff[j]);
				}
				for (int j = 0; j < 8; j++) {
					out.println(stuff[j]);
				}
				out.println(".");
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
