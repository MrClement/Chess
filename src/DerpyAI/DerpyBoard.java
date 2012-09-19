package DerpyAI;

import sharedfiles.Board;

public class DerpyBoard extends Board {

	public DerpyBoard() {
		super();
	}
	
	public DerpyBoard(DerpyBoard b) {
		//This constructor returns a DerpyBoard that is identical to the DerpyBoard passed in
		//It copies DerpyBoards, basically
		this.arr = b.arr;
	}
	
	public DerpyBoard updateLocations() {
		// TODO Auto-generated method stub
		return null;
	}

	public DerpyPiece[][] getBoardArray(){
		return (DerpyPiece[][]) arr; 
	}
}
