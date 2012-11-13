package generalChess;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import sharedfiles.Bishop;
import sharedfiles.Blank;
import sharedfiles.Board;
import sharedfiles.King;
import sharedfiles.Knight;
import sharedfiles.Pawn;
import sharedfiles.Piece;
import sharedfiles.Queen;
import sharedfiles.Rook;


	
public class BoardLordsStrategy {

	public boolean color;
	public Piece[][] b;
	public int move;
	
	
	
	public ArrayList<ArrayList> kMovesDefending() {
		ArrayList<ArrayList> d = new ArrayList();
	
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				if (b[j][k].getColor() == color && b[j][k].toString().charAt(1) == 'K') {
					ArrayList g = new ArrayList();
					int x = j;
					int y = k;
					g.add(b[x][y]);
					g.add(new Point(x, y));
					if (x == -1 || y == -1) {
						return null;
					} else {
						for (int a = x - 1; a < x + 2; a++) {
							for (int b = y - 1; b < y + 2; b++) {
								if (a > -1 && a < 8 && b > -1 && b < 8) {
									if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color) {
										g.add(new Point(a, b));
									}
								}
							}
						}
					}
					d.add(g);
				}
			}
		}
		
		return d;
	}

	public ArrayList<ArrayList> qMovesDefending() {
		ArrayList<ArrayList> d = new ArrayList<ArrayList>();
		int x = 0;
		int y = 0;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				if (b[j][k].getColor() == color && b[j][k].toString().charAt(1) == 'Q') {
					ArrayList g = new ArrayList();
					x = j;
					y = k;
					g.add(b[x][y]);
					g.add(new Point(x, y));
					if (x == -1 || y == -1) {
						return null;
					} else {
						// checks queen for diagonal down to the right. quits if adds an
						// opposite color piece or reaches end of board or our piece
						int a = x;
						int b = y;
						 
						int quit = 0;
						if (b!=7 && a!=7) //if the queen is on the last row or furthest right column of the board no need to check down and to the right
						{
						do {
							a = a + 1;
							b = b + 1;
							if (a == 7)
								quit = -999;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color )
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks queen for diagonal down to the left. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
						quit = 0;
						if(b!=7 && a!=0) //if the queen is on the last row or leftmost column of the board no need to check down and to the left
						{
						do {
							a = a - 1;
							b = b + 1;
							if (a == 0)
								quit = -999;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks queen for diagonal up to the left. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
							
						quit = 0;
						if (b!=0 && a!=0)
						{//if the queen is on the first row of the board or leftmost column no need to check up and to the left
						do {
							a = a - 1;
							b = b - 1;
							if (a == 0)
								quit = -999;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks queen for diagonal up to the right. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
						quit = 0;
						if(b!=0 && a!=7)
							//if queen is on the highest row and rightmost column no need to look up and to the right
						{
						do {
							a = a + 1;
							b = b - 1;
							if (a == 7)
								quit = -999;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks queen north. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						a = x;
						b = y;
						if (b == 0)
							b = b + 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							b = b - 1;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks queen south. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						a = x;
						b = y;
						if (b == 7)
							b = b - 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							b = b + 1;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks queen to the west. quits if adds an opposite color piece
						// or reaches end of board or hits our piece
						a = x;
						b = y;
						if (a == 7)
							a = a - 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							a = a + 1;
							if (a == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks queen to the east. quits if adds an opposite color piece
						// or reaches end of board or hits our piece
						a = x;
						b = y;
						if (a == 0)
							a = a + 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							a = a - 1;
							if (a == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

					}
					d.add(g);
				}
			}
		}
		
		return d;
	}

	public ArrayList<ArrayList> rMovesDefending() {
		ArrayList<ArrayList> d = new ArrayList<ArrayList>();
		int x = 0;
		int y = 0;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				if (b[j][k].getColor() == color && b[j][k].toString().charAt(1) == 'R') {
					ArrayList g = new ArrayList();
					x = j;
					y = k;
					g.add(b[x][y]);
					g.add(new Point(x, y));
					if (x == -1 || y == -1) {
						return null;
					} else {
						// checks queen rook. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						int a = x;
						int b = y;
						if (b == 0)
							b = b + 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						int quit = 0;
						do {
							b = b - 1;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks rook south. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						a = x;
						b = y;
						if (b == 7)
							b = b - 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							b = b + 1;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks rook to the west. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						a = x;
						b = y;
						if (a == 7)
							a = a - 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							a = a + 1;
							if (a == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);

						// checks rook to the east. quits if adds an opposite color piece or
						// reaches end of board or hits our piece
						a = x;
						b = y;
						if (a == 0)
							a = a + 1; // if piece is already on edge of board, need to
										// adjust for the do while loop to work
						quit = 0;
						do {
							a = a - 1;
							if (a == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
					}
					d.add(g);
				}
			}
		}
		
		return d;
	}

	public ArrayList<ArrayList> nMovesDefending() {
		ArrayList<ArrayList> v = new ArrayList<ArrayList>();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (b[x][y].getColor() == color && b[x][y].toString().charAt(1) == 'N') {
					ArrayList d = new ArrayList();
					d.add(b[x][y]);
					d.add(new Point(x, y));
					if (x - 2 > -1 && y - 1 > -1)
						d.add(new Point(x - 2, y - 1));
					if (x - 1 > -1 && y - 2 > -1)
						d.add(new Point(x - 1, y - 2));

					if (x - 2 > -1 && y + 1 < 8)
						d.add(new Point(x - 2, y + 1));
					if (x - 1 > -1 && y + 2 < 8)
						d.add(new Point(x - 1, y + 2));

					if (x + 2 < 8 && y + 1 < 8)
						d.add(new Point(x + 2, y + 1));
					if (x + 1 < 8 && y + 2 < 8)
						d.add(new Point(x + 1, y + 2));

					if (x + 1 < 8 && y - 2 > -1)
						d.add(new Point(x + 1, y - 2));
					if (x + 2 < 8 && y - 1 > -1)
						d.add(new Point(x + 2, y - 1));
					v.add(d);
				}
			}
		}
		return v;
	}

	public ArrayList<ArrayList> bMovesDefending() {
		ArrayList<ArrayList> m = new ArrayList<ArrayList>();
		int x = 0;
		int y = 0;
		for (int j = 0; j < 8; j++) {
			for (int k = 0; k < 8; k++) {
				if (b[j][k].getColor() == color && b[j][k].toString().charAt(1) == 'B') {
					ArrayList g = new ArrayList();
					x = j;
					y = k;
					g.add(b[x][y]);
					g.add(new Point(x, y));
					if (x == -1 || y == -1) {
						return null;
					} else {
						// checks bishop for diagonal down to the right. quits if adds an
						// opposite color piece or reaches end of board or our piece
						int a = x;
						int b = y;
						 
						int quit = 0;
						if (b!=7 && a!=7) //if the bishop is on the last row or furthest right column of the board no need to check down and to the right
						{
						do {
							a = a + 1;
							b = b + 1;
							if (a == 7)
								quit = -999;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks queen for diagonal down to the left. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
						quit = 0;
						if(b!=7 && a!=0) //if the bishop is on the last row or leftmost column of the board no need to check down and to the left
						{
						do {
							a = a - 1;
							b = b + 1;
							if (a == 0)
								quit = -999;
							if (b == 7)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks bishop for diagonal up to the left. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
							
						quit = 0;
						if (b!=0 && a!=0)
						{//if the bishop is on the first row of the board or leftmost column no need to check up and to the left
						do {
							a = a - 1;
							b = b - 1;
							if (a == 0)
								quit = -999;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
						// checks bishop for diagonal up to the right. quits if adds an
						// opposite color piece or reaches end of board or our piece
						a = x;
						b = y;
						
						quit = 0;
						if(b!=0 && a!=7)
							//if bishop is on the highest row and rightmost column no need to look up and to the right
						{
						do {
							a = a + 1;
							b = b - 1;
							if (a == 7)
								quit = -999;
							if (b == 0)
								quit = -999;
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color || this.b[a][b].getColor() == color)
								g.add(new Point(a, b));
							if (this.b[a][b].toString().charAt(1) != 'X')
								quit = -999;
						} while (quit != -999);
						}
					}
					m.add(g);
				}
			}
		}
		
		return m;
	}

	public ArrayList<ArrayList> pMovesDefending() {
		ArrayList<ArrayList> v = new ArrayList<ArrayList>();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (b[x][y].getColor() == color && b[x][y].toString().charAt(1) == 'P') {
					ArrayList d = new ArrayList();
					d.add(b[x][y]);
					d.add(new Point(x, y));
					if (color == false) {
						if (y == 1)
							d.add(new Point(x, y + 2));
						if (y + 1 < 8)
							d.add(new Point(x, y + 1));
						if (x + 1 < 8 && y + 1 < 8)
							d.add(new Point(x + 1, y + 1));
						if (x - 1 > -1 && y + 1 < 8)
							d.add(new Point(x - 1, y + 1));
					}

					if (color == true) {
						if (y == 6)
							d.add(new Point(x, y - 2));
						if (y - 1 > -1)
							d.add(new Point(x, y - 1));
						if (x + 1 < 8 && y - 1 > -1)
							d.add(new Point(x + 1, y - 1));
						if (x - 1 > -1 && y - 1 > -1)
							d.add(new Point(x - 1, y - 1));
					}
					v.add(d);
				}
			}
		}
		return v;
	}

	
	public ArrayList<ArrayList> allMovesDefending(){
		ArrayList<ArrayList> a=new ArrayList<ArrayList>();
		for(int i=0;i<pMovesDefending().size();i++){
			a.add(pMovesDefending().get(i));
		}
		for(int i=0;i<nMovesDefending().size();i++){
			a.add(nMovesDefending().get(i));
		}
		for(int i=0;i<bMovesDefending().size();i++){
			a.add(bMovesDefending().get(i));
		}
		for(int i=0;i<rMovesDefending().size();i++){
			a.add(rMovesDefending().get(i));
		}
		for(int i=0;i<qMovesDefending().size();i++){
			a.add(qMovesDefending().get(i));
		}
		for(int i=0;i<kMovesDefending().size();i++){
			a.add(kMovesDefending().get(i));
		}
		return a;
	}	
	
	
}
