package DerpyAI;

import java.util.ArrayList;
import sharedfiles.*;

public class DerpyAI {
	private Boolean myColor; //black is false, white is true. 
	private ArrayList<Board> boardStore; //The current, and all previous boards
	private ArrayList<Piece> takenPieces; //The pieces we took
	public ArrayList<Piece> ourPieces; //Our Array of Pieces
	private Board currentBoard; //currentBoard is the current chess board

	//constructor
	public DerpyAI(Boolean b, Board c){
		myColor = b; 
		boardStore = new ArrayList<Board>();
		takenPieces = new ArrayList<Piece>();
		ourPieces = new ArrayList<Piece>();
		currentBoard = c; 
	}
	
	
	public void findOurPieces(){ // Creates an array of our pieces
	Piece[][] boardState = currentBoard.getBoardArray(); 
	for(int i=0;i<8;i++){
			for(int a=0;a<8;a++){ 
				if (boardState[i][a].getColor() == myColor) ourPieces.add(boardState[i][a]); 
			}
		}
	}

	//Board State Checks

	public boolean inCheck(){
		boolean b = false;
		
		return b;
	} 

	//checks if a piece is ours
	public boolean isPieceOurs(Piece p){
		if (this.myColor == p.getColor() && !(p instanceof Blank)){
			return true;}
		else return false;}
	
	//returns an arraylist of our pieces that are threatened by enemy an enemy piece
	public ArrayList<Piece> enemyThreats(Board b){
		ArrayList<Piece> ourThreatenedPieces = new ArrayList<Piece>();
		for(int i=0; i<8; i++){
			for(int j=0; j<=8; j++){
				if(this.isPieceOurs(b.getBoardArray()[i][j])){
					if(this.pieceIsThreatened(b.getBoardArray()[i][j])){
						ourThreatenedPieces.add(b.getBoardArray()[i][j]);
					}
				}
			}
		}
						

		return ourThreatenedPieces;

	}

	//returns an arraylist of enemy pieces that we threaten
	public ArrayList<Piece> ourThreats(Board b){
		ArrayList<Piece> theirThreatenedPieces = new ArrayList<Piece>();
		for(int i=0; i<8; i++){
			for(int j=0; j<=8; j++){
				if(!(this.isPieceOurs(b.getBoardArray()[i][j]))){
					if(this.pieceIsThreatened(b.getBoardArray()[i][j])){
						theirThreatenedPieces.add(b.getBoardArray()[i][j]);
					}
				}
			}
		}

		return theirThreatenedPieces;
	}

	//asks if a piece is threatened
	public boolean pieceIsThreatened(Piece p) {
		boolean b = false; 
		return b; 
	}

	//makes a move to get out of check
	public Board getOutOfCheck(Board b){
		return b;
	}
	
	//uses provided board to make a move, returns a board with the move made
	public Board makeMove(Board b){
		if (this.inCheck() == false){
			this.getOutOfCheck(b);}
		else {


		}
		return b;
	}

}


