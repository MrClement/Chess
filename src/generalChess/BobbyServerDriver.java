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

		private static String hostname = "10.80.4.31";
		private static int port = 8080;

		public static void main(String[] args) {

			BufferedReader in;
			PrintStream out;
			Board b=new Board();
			v1Bobby bobby=new v1Bobby(b, false);
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
										
					for(int i=0;i<8;i++){
						for(int j=0;j<8;j++){
							out.print(bobby.getB()[i][j]);
						}
						out.println();
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
