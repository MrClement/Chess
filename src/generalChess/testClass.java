package generalChess;

import sharedfiles.Board;

public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);
		a.move(2, 7, 3, 3);
		a.printBoard();
			for(int j=0;j<a.bMoves().get(0).size();j++){
				System.out.println(a.bMoves().get(0).get(j));
			}
		}
	
}
