package DerpyAI;

import java.awt.Point;


public class DerpyBoard {
	
	protected DerpyPiece[][] arr;
	public DerpyBoard(){
		arr=new DerpyPiece[8][8];
		for(int i=0;i<8;i++){
			for(int a=2;a<6;a++){
				arr[i][a]=new DerpyBlank(new Point(i,a)); 
			}
		}
		for(int x=0;x<8;x++){
			arr[x][1] = new DerpyPawn(false, new Point(x,1));
			arr[x][6] = new DerpyPawn(true, new Point(x,6));
		}
	
		//black setup
		arr[0][0] = new DerpyRook(false, new Point(0,0));
		arr[7][0] = new DerpyRook(false, new Point(7,0));
		
		arr[1][0] = new DerpyKnight(false, new Point(1,0));
		arr[6][0] = new DerpyKnight(false, new Point(6,0));
		
		arr[2][0] = new DerpyBishop(false, new Point(2,0));
		arr[5][0] = new DerpyBishop(false, new Point(5,0));
	
		arr[3][0] = new DerpyQueen(false, new Point(3,0));
		arr[4][0] = new DerpyKing(false, new Point(4,0));
	
		//white setup
		arr[0][7] = new DerpyRook(true, new Point(0,7));
		arr[7][7] = new DerpyRook(true, new Point(7,7));
		
		arr[1][7] = new DerpyKnight(true, new Point(1,7));
		arr[6][7] = new DerpyKnight(true, new Point(6,7));
		
		arr[2][7] = new DerpyBishop(true, new Point(2,7));
		arr[5][7] = new DerpyBishop(true, new Point(5,7));
	
		arr[3][7] = new DerpyQueen(true, new Point(3,7));
		arr[4][7] = new DerpyKing(true, new Point(4,7));

	}
	
	public DerpyBoard(DerpyBoard b) {
		this.arr = b.arr;
	}

	public DerpyPiece[][] getBoardArray(){
		return arr; 
	}

	public void printBoard(){ 
		for(int y=0; y<8; y++){
	
			for(int x=0; x<8; x++){
				System.out.print(arr[x][y].toString()+" | ");
			}
		
			System.out.println();
		}
	}
	
	public static void main (String args[]){
		DerpyBoard a = new DerpyBoard();
		a.printBoard();
	}

	public void updateLocations() {
		
		DerpyPiece newArr[][] = new DerpyPiece[8][8];
		
		for(int i = 0; i < 8; i++) {
			for(int a = 0; a < 8; a++) {
				DerpyPiece piece = arr[i][a];
				System.out.println("i: " + i + "...a: " + a);
				Point location = piece.getLocation();
				newArr[(int) location.getX()][(int) location.getY()] = piece;
			}
		}
		
		arr = newArr;
		
	}
	
}
