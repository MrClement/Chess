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

public class v1Bobby {
	public boolean color;
	public Piece[][] b;
	public int move;

	
	public v1Bobby(Board b, boolean c) {
		this.color = c;
		this.b = new Piece[8][8];
		getBoard(b);
		move = 0;
	}

	public v1Bobby(Piece[][] b, boolean c) {
		this.color = c;
		this.b = new Piece[8][8];
		getBoard(b);
		move = 0;
	}

	public void set (int a, int c, Piece p){
		b[a][c]=p;
	}
	
	public boolean getColor() {
		return color;
	}

	public Piece[][] getPieceArray() {
		return b;
	}

	public Piece[][] getB(){
		return b;
	}
	public void getBoard(Board b) {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				char t = b.getBoardArray()[x][y].toString().charAt(1);
				boolean tt = b.getBoardArray()[x][y].getColor();
				switch (t) {
					case 'P':
						this.b[x][y] = new Pawn(tt);
						break;
					case 'R':
						this.b[x][y] = new Rook(tt);
						break;

					case 'N':
						this.b[x][y] = new Knight(tt);
						break;

					case 'B':
						this.b[x][y] = new Bishop(tt);
						break;

					case 'K':
						this.b[x][y] = new King(tt);
						break;

					case 'Q':
						this.b[x][y] = new Queen(tt);
						break;

					case 'X':
						this.b[x][y] = new Blank(true);
						break;

				}
			}
		}
	}

	public void getBoard(Piece[][] u) {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				char t = u[x][y].toString().charAt(1);
				boolean tt = u[x][y].getColor();
				switch (t) {
					case 'P':
						this.b[x][y] = new Pawn(tt);
						break;
					case 'R':
						this.b[x][y] = new Rook(tt);
						break;

					case 'N':
						this.b[x][y] = new Knight(tt);
						break;

					case 'B':
						this.b[x][y] = new Bishop(tt);
						break;

					case 'K':
						this.b[x][y] = new King(tt);
						break;

					case 'Q':
						this.b[x][y] = new Queen(tt);
						break;

					case 'X':
						this.b[x][y] = new Blank(true);
						break;

				}
			}
		}
	}

	public void getBoard(String[] a){
		for(int i=0;i<8;i++){
			boolean col;
			char typ;
			int g=0;
			for (int j=0;j<40;j+=5){
				if(a[i].charAt(j)=='B'){col=false;}
				else col=true;
				typ=a[i].charAt(j+1);
				switch (typ){
				case 'P':
					this.b[g][i] = new Pawn(col);
					break;
				case 'R':
					this.b[g][i] = new Rook(col);
					break;

				case 'N':
					this.b[g][i] = new Knight(col);
					break;

				case 'B':
					this.b[g][i] = new Bishop(col);
					break;

				case 'K':
					this.b[g][i] = new King(col);
					break;

				case 'Q':
					this.b[g][i] = new Queen(col);
					break;

				case 'X':
					this.b[g][i] = new Blank(true);
					break;
					
				}
				g++;
			}
		}
	}
	
	public void move(int ax, int ay, int bx, int by) {
		char t = this.b[ax][ay].toString().charAt(1);
		boolean c = this.b[ax][ay].getColor();
		this.b[ax][ay] = new Blank(true);
		switch (t) {
			case 'P':
				this.b[bx][by] = new Pawn(c);
				break;
			case 'R':
				this.b[bx][by] = new Rook(c);
				break;
			case 'N':
				this.b[bx][by] = new Knight(c);
				break;
			case 'B':
				this.b[bx][by] = new Bishop(c);
				break;
			case 'K':
				this.b[bx][by] = new King(c);
				break;
			case 'Q':
				this.b[bx][by] = new Queen(c);
				break;
		}

	}

	public void printBoard() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if(b[y][x].toString().equals("WX")) System.out.print("   | ");
				else System.out.print(b[y][x].toString() + " | ");
			}
			System.out.println();
			System.out.println("---------------------------------------");
		}

		System.out.println(".");
		System.out.println();

	}

	// returns possible king moves
	public ArrayList<ArrayList> kMoves() {
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
									if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color) {
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

	// possible queen moves
	public ArrayList<ArrayList> qMoves() {
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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

	public ArrayList<ArrayList> rMoves() {
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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

	public ArrayList<ArrayList> nMoves() {
		ArrayList<ArrayList> v = new ArrayList<ArrayList>();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (b[x][y].getColor() == color && b[x][y].toString().charAt(1) == 'N') {
					ArrayList d = new ArrayList();
					d.add(b[x][y]);
					d.add(new Point(x, y));
					if (x - 2 > -1 && y - 1 > -1
							&& (b[x - 2][y - 1].toString().charAt(1) == 'X' || b[x - 2][y - 1].getColor() == !color))
						d.add(new Point(x - 2, y - 1));
					if (x - 1 > -1 && y - 2 > -1
							&& (b[x - 1][y - 2].toString().charAt(1) == 'X' || b[x - 1][y - 2].getColor() == !color))
						d.add(new Point(x - 1, y - 2));

					if (x - 2 > -1 && y + 1 < 8
							&& (b[x - 2][y + 1].toString().charAt(1) == 'X' || b[x - 2][y + 1].getColor() == !color))
						d.add(new Point(x - 2, y + 1));
					if (x - 1 > -1 && y + 2 < 8
							&& (b[x - 1][y + 2].toString().charAt(1) == 'X' || b[x - 1][y + 2].getColor() == !color))
						d.add(new Point(x - 1, y + 2));

					if (x + 2 < 8 && y + 1 < 8
							&& (b[x + 2][y + 1].toString().charAt(1) == 'X' || b[x + 2][y + 1].getColor() == !color))
						d.add(new Point(x + 2, y + 1));
					if (x + 1 < 8 && y + 2 < 8
							&& (b[x + 1][y + 2].toString().charAt(1) == 'X' || b[x + 1][y + 2].getColor() == !color))
						d.add(new Point(x + 1, y + 2));

					if (x + 1 < 8 && y - 2 > -1
							&& (b[x + 1][y - 2].toString().charAt(1) == 'X' || b[x + 1][y - 2].getColor() == !color))
						d.add(new Point(x + 1, y - 2));
					if (x + 2 < 8 && y - 1 > -1
							&& (b[x + 2][y - 1].toString().charAt(1) == 'X' || b[x + 2][y - 1].getColor() == !color))
						d.add(new Point(x + 2, y - 1));
					v.add(d);
				}
			}
		}
		return v;
	}

	public ArrayList<ArrayList> bMoves() {
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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
							if (this.b[a][b].toString().charAt(1) == 'X' || this.b[a][b].getColor() != color)
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

	public ArrayList<ArrayList> pMoves() {
		ArrayList<ArrayList> v = new ArrayList<ArrayList>();
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (b[x][y].getColor() == color && b[x][y].toString().charAt(1) == 'P') {
					ArrayList d = new ArrayList();
					d.add(b[x][y]);
					d.add(new Point(x, y));
					if (color == false) {
						if (y == 1 && b[x][y + 2].toString().charAt(1) == 'X'&&b[x][y + 1].toString().charAt(1) == 'X')
							d.add(new Point(x, y + 2));
						if (y + 1 < 8 && b[x][y + 1].toString().charAt(1) == 'X')
							d.add(new Point(x, y + 1));
						if (x + 1 < 8 && y + 1 < 8
								&& (b[x + 1][y + 1].toString().charAt(1) != 'X' && b[x + 1][y + 1].getColor() != color))
							d.add(new Point(x + 1, y + 1));
						if (x - 1 > -1 && y + 1 < 8
								&& (b[x - 1][y + 1].toString().charAt(1) != 'X' && b[x - 1][y + 1].getColor() != color))
							d.add(new Point(x - 1, y + 1));
					}

					if (color == true) {
						if (y == 6 && b[x][y - 2].toString().charAt(1) == 'X'&&b[x][y + 1].toString().charAt(1) == 'X')
							d.add(new Point(x, y - 2));
						if (y - 1 > -1 && b[x][y - 1].toString().charAt(1) == 'X')
							d.add(new Point(x, y - 1));
						if (x + 1 < 8 && y - 1 > -1
								&& (b[x + 1][y - 1].toString().charAt(1) != 'X' && b[x + 1][y - 1].getColor() != color))
							d.add(new Point(x + 1, y - 1));
						if (x - 1 > -1 && y - 1 > -1
								&& (b[x - 1][y - 1].toString().charAt(1) != 'X' && b[x - 1][y - 1].getColor() != color))
							d.add(new Point(x - 1, y - 1));
					}
					v.add(d);
				}
			}
		}
		return v;
	}

	//takes an array of possible returns the index of the highest ranking opponent piece that any specific piece
	//has in its possible moves
	//-1 if no possible pieces to take
	public int takeIfPossible(ArrayList a)
	{

	for(int i=2; i<a.size();i++) {
		
	if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
			b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='K') {
			int x=i;
			return x;}
	}
	}
	for(int i=2; i<a.size();i++) {
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
				b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
			if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='Q') {
				int x=i;
				return x;}
		}
		}
	for(int i=2; i<a.size();i++) {
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
				b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
			if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='R') {
				int x=i;
				return x;}
		}
		}
	for(int i=2; i<a.size();i++) {
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
				b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
			if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='N') {
				int x=i;
				return x;}
		}
		}
	for(int i=2; i<a.size();i++) {
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
				b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
			if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='B') {
				int x=i;
				return x;}
		}
		}
	for(int i=2; i<a.size();i++) {
		if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].getColor()==!color &&
				b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)!='X'){
			if(b[(int)((Point)a.get(i)).getX()][(int)((Point)a.get(i)).getY()].toString().charAt(1)=='P') {
				int x=i;
				return x;}
		}
		}
	
	return 1;
	}
	
	public ArrayList<Point> bestPieceToTake()
	{
		ArrayList<Point> a=new ArrayList<Point>();
		int loc=0;
		int locloc=1;
		int bb=0;
		
		for(int i=0;i<allMoves().size();i++){
			int bestv=0;
			int best=0;
			char t=allMoves().get(i).get(0).toString().charAt(1);
			int v;
			switch (t) {
			case 'P':
				v=2;
				break;
			case 'R':
				v=5;
				break;

			case 'N':
				v=3;
				break;

			case 'B':
				v=4;
				break;

			case 'K':
				v=100;
				break;

			case 'Q':
				v=6;
				break;
			default:
				v=0;
				break;
			}
		
			for(int d=1;d<allMoves().get(i).size();d++){
			char tt=b[(int)((Point)allMoves().get(i).get(d)).getX()][(int)((Point)allMoves().get(i).get(d)).getY()].toString().charAt(1);
			int vv;
			switch (tt) {
			case 'P':
				vv=2;
				break;
			case 'R':
				vv=5;
				break;

			case 'N':
				vv=3;
				break;

			case 'B':
				vv=4;
				break;

			case 'K':
				vv=100;
				break;

			case 'Q':
				vv=6;
				break;

			default:
				vv=0;
				break;
			}
			
			v1Bobby test=new v1Bobby(b, color);
			test.set((int)((Point)allMoves().get(i).get(d)).getX(), (int)((Point)allMoves().get(i).get(d)).getY(), (Piece)allMoves().get(i).get(0));
			if(vv-v>=bestv){
				bestv=vv-v;
				best=d;
			}
			if(best>bb){
				bb=bestv;
				loc=i;
				locloc=best;
			}
		}
		}
		
		a.add(new Point((Point)allMoves().get(loc).get(1)));
		a.add(new Point((Point)allMoves().get(loc).get(locloc)));
		return a;
		
		
		/*
		ArrayList<Point> v=new ArrayList<Point>();

		int best=0;
		ArrayList currPiece=allMoves().get(0);
		int high=0;
		for(int i=0;i<allMoves().size();i++){
			
			char c;
			if(color==true)c='W';else c='B';
			
			//p=2 n=3 b=3 r=5 q=9 k=100
			int curVal = 0;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'P') curVal=2;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'N') curVal=3;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'B') curVal=3;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'R') curVal=5;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'Q') curVal=9;
			if((char)allMoves().get(i).get(0).toString().charAt(1) == 'K') curVal=100;
			
			int takeVal=0;
			currPiece= allMoves().get(i);
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='P')
				takeVal =2;
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='N')
				takeVal =3;
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='B')
				takeVal =3;
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='R')
				takeVal =5;
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='Q')
				takeVal =9;
			if(b[(int)((Point)currPiece.get(takeIfPossible(currPiece))).getX()][(int)((Point)currPiece.get(takeIfPossible(currPiece))).getY()].toString().charAt(1)=='K')
				takeVal =100;
			
			if(takeVal-curVal>high){
				high=takeVal-curVal;
				best=i;
				v.add((Point)allMoves().get(best).get(1));
				v.add((Point)allMoves().get(best).get(takeIfPossible(allMoves().get(best))));
			}
			else{
				v.add((Point)allMoves().get(best).get(1));
				v.add((Point)allMoves().get(best).get(1));

			}
		}
		
		return v;
		*/
		
	}
	
	public void randomMove() {
		Random r=new Random();		
		int a=r.nextInt(allMoves().size());
		while(allMoves().get(a).size()<=2){
			a=r.nextInt(allMoves().size());
		}
		int b=r.nextInt(allMoves().get(a).size()-2)+2;
		move((int)((Point)allMoves().get(a).get(1)).getX(), (int)((Point)allMoves().get(a).get(1)).getY(), (int)((Point)allMoves().get(a).get(b)).getX(), (int)((Point)allMoves().get(a).get(b)).getY());
		
	}

/*
	public Piece[][] turn(Board c) {
		getBoard(c);
		Piece[][] arr = new Piece[8][8];
		arr = getPieceArray();
		move++;
		int w, x, y, z;
		w=0;
		x=0;
		y=0;
		z=0;
		if (color == true) {

			switch (move) {
				case 1:
					w=4;x=6;y=4;z=4;
				case 2:
					w=3;x=7;y=5;z=5;

				case 3:

					if (arr[2][4].toString().charAt(1) == 'X' || arr[2][4].getColor() != color)
					w=5;x=7;y=2;z=4;

				case 4:
					if (arr[5][3].toString().charAt(1) == 'X' && arr[5][4].toString().charAt(1) == 'X'
							&& arr[5][5].toString().charAt(1) == 'X'
							&& (arr[5][6].toString().charAt(1) == 'X' || arr[5][6].getColor() != color))
					w=5;x=2;y=5;z=6;

					return b;
				default:
					randomMove();
			}
		} else {

			switch (move) {
				case 1:
					w=4;x=1;y=4;z=3;

				case 2:
					w=3;x=0;y=5;z=2;

				case 3:
					if (arr[2][3].toString().charAt(1) == 'X' || arr[2][3].getColor() != color)
					w=5;x=0;y=2;z=3;

				case 4:
					if (arr[5][3].toString().charAt(1) == 'X' && arr[5][4].toString().charAt(1) == 'X'
							&& arr[5][5].toString().charAt(1) == 'X'
							&& (arr[5][6].toString().charAt(1) == 'X' || arr[5][6].getColor() != color))
					w=5;x=2;y=5;z=6;

				default:
					randomMove();
			}
		}
		move(w, x, y, z);
		
		System.out.println("Origin: ("+w+", "+x+") Destination:"+y+", "+z+")"+"Piece: "+b[w][x].toString());
		return b;


	}

	public Piece[][] turn(Piece[][] c) {
		getBoard(c);
		Piece[][] arr = new Piece[8][8];
		arr = getPieceArray();
		move++;
		if (color == true) {
			switch (move) {
				case 1:
					move(4, 6, 4, 4);
					return b;
				case 2:
					move(3, 7, 5, 5);
					return b;
				case 3:

					if (arr[2][4].toString().charAt(1) == 'X' || arr[2][4].getColor() != color)
						move(5, 7, 2, 4);
					return b;
				case 4:
					if (arr[5][3].toString().charAt(1) == 'X' && arr[5][4].toString().charAt(1) == 'X'
							&& arr[5][5].toString().charAt(1) == 'X'
							&& (arr[5][6].toString().charAt(1) == 'X' || arr[5][6].getColor() != color))
						move(5, 2, 5, 6);
					return b;
				default:
					randomMove();
					return b;

			}
		} else {

			switch (move) {
				case 1:
					move(4, 1, 4, 3);
					return b;
				case 2:
					move(3, 0, 5, 2);
					return b;
				case 3:
					if (arr[2][3].toString().charAt(1) == 'X' || arr[2][3].getColor() != color)
						move(5, 0, 2, 3);
					return b;
				case 4:
					if (arr[5][3].toString().charAt(1) == 'X' && arr[5][4].toString().charAt(1) == 'X'
							&& arr[5][5].toString().charAt(1) == 'X'
							&& (arr[5][6].toString().charAt(1) == 'X' || arr[5][6].getColor() != color))
						move(5, 2, 5, 6);
					return b;
				default:
					randomMove();
					return b;
			}

		}

	}

	
*/
	
	public Point randomKingMove() {
	
			Random r = new Random();
			int m = r.nextInt(kMoves().size());
			while (kMoves().get(m).size() == 2) {
				m = r.nextInt(kMoves().size());
			}
			Point st = new Point((Point) kMoves().get(m).get(1));
			Random q=new Random();
			int choose=q.nextInt((kMoves().get(m).size()-2))+2;
			Point fn = new Point((Point) kMoves().get(m).get(choose));
			move((int) st.getX(), (int) st.getY(), (int) fn.getX(), (int) fn.getY());
			return fn;
		
	}

	public boolean checkmate(){
	//replicate board state
	v1Bobby a=new v1Bobby(b, color);
	Point p;
	int x, y;
	for (int i=0;i<a.allMoves().size();i++){
		for(int k=1;k<a.allMoves().get(i).size();k++){
			x=i;y=k;
			a.move((int)((Point)a.allMoves().get(i).get(1)).getX(), (int)((Point)a.allMoves().get(i).get(1)).getY(),(int)((Point)a.allMoves().get(i).get(k)).getX(), (int)((Point)a.allMoves().get(i).get(k)).getY());
			if(a.check()==false)return false;
		}
	}
	return true;
}

	public boolean check(){
	if(isThreatened((int)((Point)kMoves().get(0).get(1)).getX(),(int)((Point)kMoves().get(0).get(1)).getY() ).size()!=0)return true;
	else return false;
}

	public void getOutOfCheck(){
	//replicate board state
	v1Bobby a=new v1Bobby(b, color);
	Point p;
	int x, y;
	for (int i=0;i<a.allMoves().size();i++){
		for(int k=1;k<a.allMoves().get(i).size();k++){
			x=(int)((Point)a.allMoves().get(i).get(k)).getX();y=(int)((Point)a.allMoves().get(i).get(k)).getY();
			int x1=(int)((Point)a.allMoves().get(i).get(1)).getX(); int y1=(int)((Point)a.allMoves().get(i).get(1)).getY();
			a.move((int)((Point)a.allMoves().get(i).get(1)).getX(), (int)((Point)a.allMoves().get(i).get(1)).getY(),(int)((Point)a.allMoves().get(i).get(k)).getX(), (int)((Point)a.allMoves().get(i).get(k)).getY());
			if(a.check()==false){
				move(x1, y1, x, y);
				break;
			}
			else a.move(x, y, x1, y1);
		}
	}
}

	public ArrayList<ArrayList> allMoves(){
	ArrayList<ArrayList> a=new ArrayList<ArrayList>();
	for(int i=0;i<pMoves().size();i++){
		a.add(pMoves().get(i));
	}
	for(int i=0;i<nMoves().size();i++){
		a.add(nMoves().get(i));
	}
	for(int i=0;i<bMoves().size();i++){
		a.add(bMoves().get(i));
	}
	for(int i=0;i<rMoves().size();i++){
		a.add(rMoves().get(i));
	}
	for(int i=0;i<qMoves().size();i++){
		a.add(qMoves().get(i));
	}
	for(int i=0;i<kMoves().size();i++){
		a.add(kMoves().get(i));
	}
	return a;
}

	public ArrayList<Point> isThreatened (int d, int e){
	ArrayList<Point> a=new ArrayList<Point>();
	v1Bobby c=new v1Bobby(b, !color);
	for(int i=0;i<c.allMoves().size();i++){
		for(int k=1;k<c.allMoves().get(i).size();k++){
			if(((Point)c.allMoves().get(i).get(k)).equals(new Point(d, e))){
					a.add((Point)c.allMoves().get(i).get(1));
		}}
		
	}
	return a;
}

	public Piece[][] turn(Board b) {
		getBoard(b);
		if (checkmate() == true)
			System.out.print("Lose");
		else if (check() == true)
			getOutOfCheck();
		else if (!(bestPieceToTake().get(0).equals(bestPieceToTake().get(1)))) {
			move((int) bestPieceToTake().get(0).getX(), (int) bestPieceToTake().get(0).getY(), (int) bestPieceToTake()
					.get(1).getX(), (int) bestPieceToTake().get(1).getY());
			System.out.println(bestPieceToTake().get(0) + ") --> (" + bestPieceToTake().get(1));

		} else
			randomMove();
return this.b;
	}

	public Piece[][] turn(Piece[][] b) {
		getBoard(b);
		if (checkmate() == true)
			System.out.print("Lose");
		else if (check() == true)
			getOutOfCheck();
		else if (!(bestPieceToTake().get(0).equals(bestPieceToTake().get(1)))) {
			move((int) bestPieceToTake().get(0).getX(), (int) bestPieceToTake().get(0).getY(), (int) bestPieceToTake()
					.get(1).getX(), (int) bestPieceToTake().get(1).getY());
			System.out.println(bestPieceToTake().get(0) + ") --> (" + bestPieceToTake().get(1));

		} else
			randomMove();
return this.b;
	}


}


