package generalChess;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import sharedfiles.Piece;

import sharedfiles.Board;
public class BobbyServerDriver {

		private static String hostname = "localhost";
		private static int port = 8080;

		public static void main(String[] args) {

			BufferedReader in;
			PrintStream out;
			Board b=new Board();
			v1Bobby bobby=new v1Bobby(b, true);
			Socket myClient;
			try {
				myClient = new Socket(hostname, port);
				in = new BufferedReader(new InputStreamReader(myClient.getInputStream()));
				out = new PrintStream(myClient.getOutputStream());
				String line = "";
				String[] stuff = new String[8];
				while (true) {
					int k=0;
					while(true){
						line = in.readLine();
						if (line.equals("."))
							break;
						if(!(line==(null)))
						{
							stuff[k] = line;
							k++;
						}
					}
					b.buildBoard(stuff);
					bobby.turn(b.getBoardArray());
					
					stuff=new String[8];
					
					Piece[][] x =b.getBoardArray();
					
					for(int w=0; w<x.length; w++)
					{
						stuff[w]="";
						for(int z=0; z<x[w].length; z++)
						{
							stuff[w]+=x[w][z].toString() + " | ";
							
						}
						
					}
					
					
					for (int j = 0; j < 8; j++) {
						System.out.println(stuff[j]);
					}
					for (int j = 0; j < 8; j++) {
						out.println(stuff[j]);
					}
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
