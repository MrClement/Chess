package generalChess;

import sharedfiles.Board;

public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), false);
		a.move(2, 0, 0, 5);
		a.printBoard();
		for(int i=0;i<a.bMoves().size();i++){
			for(int j=0;j<a.bMoves().get(i).size();j++){
				System.out.println(a.bMoves().get(i).get(j));
			}
		}
	}
}
