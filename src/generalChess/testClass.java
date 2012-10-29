package generalChess;

import sharedfiles.Board;

public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);
		for (int i=0;i<a.allMoves().size();i++){
			for(int k=0;k<a.allMoves().get(i).size();k++){
				System.out.println(a.allMoves().get(i).get(k));
				
			}
			
		}
		}
	
}
