package communicator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private static String hostname = "localhost";
	private static int port = 8080;

	public static void main(String[] args) {

		BufferedReader in;
		PrintStream out;

		Scanner scan = new Scanner(System.in);

		Socket myClient;
		try {
			myClient = new Socket(hostname, port);
			in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
			out = new PrintStream(myClient.getOutputStream());
			while (scan.hasNext()) {
				out.println(scan.nextLine());
				System.out.println(in.readLine());
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
