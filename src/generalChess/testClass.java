package generalChess;

import sharedfiles.Board;

public class testClass {
	public static void main(String[] args) {
		v1Bobby a=new v1Bobby(new Board(), true);
		a.move(4, 7, 3, 2);
		for (int i=0;i<a.isThreatened(3, 2).size();i++){
				System.out.println(a.isThreatened(3, 2).get(i));
			
		}
		a.getOutOfCheck();
		}
	
}
