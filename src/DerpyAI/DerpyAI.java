package DerpyAI;

import java.awt.Point;
import java.util.ArrayList;
import sharedfiles.*;

public class DerpyAI {
	private Boolean myColor; //black is false, white is true. 
	private ArrayList<Board> boardStore; //The current, and all previous boards
	private ArrayList<Piece> takenPieces; //The pieces we took
	public ArrayList<Piece> ourPieces; //Our Array of Pieces
	public ArrayList<Piece> theirPieces; //Our Array of their Pieces
	private Board currentBoard; //currentBoard is the current chess board
	public ArrayList<Point> ourPiecesPoints; //array of the locations of our pieces
	public ArrayList<Point> theirPiecesPoints; //array of the locations of their pieces
	private ArrayList<Move> allMoves;

	//constructor
	public DerpyAI(Boolean b, Board c){
		myColor = b; 
		boardStore = new ArrayList<Board>();
		takenPieces = new ArrayList<Piece>();
		ourPieces = new ArrayList<Piece>();
		ourPieces = new ArrayList<Piece>();
		currentBoard = c; 
		theirPiecesPoints = new ArrayList<Point>();
		ourPiecesPoints = new ArrayList<Point>();
		allMoves = new ArrayList<Move>();
	}

	///////////////////////////Board State Checks//////////////////////////////////////////

	public void findTheirPieces(){ // Creates an array of their pieces
	Piece[][] boardState = currentBoard.getBoardArray(); 
	for(int i=0;i<8;i++){
			for(int a=0;a<8;a++){ 
				if (!(this.isPieceOurs(boardState[i][a]))) theirPieces.add(boardState[i][a]); 
			}
		}
	}
	
	public void findTheirPiecesPoints(){ // Creates an array of their pieces' locations
		Piece[][] boardState = currentBoard.getBoardArray(); 
		for(int i=0;i<8;i++){
				for(int a=0;a<8;a++){
					Point currentPoint=new Point (i,a);
					if (!(this.isPieceOurs(boardState[i][a]))) theirPiecesPoints.add(currentPoint); 
				}
			}
		}
	
	public void findOurPieces(){ // Creates an array of our pieces
		Piece[][] boardState = currentBoard.getBoardArray(); 
		for(int i=0; i < 8; i++){
			for(int a=0; a < 8; a++){ 
				if (this.isPieceOurs(boardState[i][a])) ourPieces.add(boardState[i][a]); 
			}
		}
	}
	
	public void findOurPiecesPoints(){ // Creates an array of our pieces' locations
		Piece[][] boardState = currentBoard.getBoardArray(); 
		for(int i=0; i < 8; i++){
			for(int a=0; a < 8; a++){ 
				Point currentPoint=new Point(i,a);
				if (this.isPieceOurs(boardState[i][a])) ourPiecesPoints.add(currentPoint); 
			}
		}
	}

	//checks if a piece is ours
	public boolean isPieceOurs(Piece p) {
		if (this.myColor == p.getColor() && !(p instanceof Blank)){
			return true;
		}
		else return false;
	}
	
	//returns an arraylist of our pieces that are threatened by an enemy piece
	public ArrayList<Piece> enemyThreats(Board b){
		ArrayList<Piece> ourThreatenedPieces = new ArrayList<Piece>();
		for(int i = 0; i < 8; i++){
			for(int j = 0; j <= 8; j++){
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
		for(int i = 0; i < 8; i++){
			for(int j = 0; j <= 8; j++){
				if(!(this.isPieceOurs(b.getBoardArray()[i][j]))){
					if(this.pieceIsThreatened(b.getBoardArray()[i][j])){
						theirThreatenedPieces.add(b.getBoardArray()[i][j]);
					}
				}
			}
		}

		return theirThreatenedPieces;
	}
	//checks if p is more valuable than a
	public boolean pieceIsMoreValuable(Piece a, Piece p){
		if(p instanceof DerpyKing){
			return true;
		}
		if(p instanceof DerpyQueen){
			return true;
		}
		if(p instanceof DerpyRook){
			if(a instanceof DerpyQueen){
				return false;
			}
			else{
				return true;
			}
			
		}
		if(p instanceof DerpyBishop || p instanceof DerpyKnight){
			if(a instanceof DerpyRook || a instanceof DerpyQueen){
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	
	public boolean pieceIsProtected(Piece p){
		DerpyPiece d = (DerpyPiece)p;
		for(Piece a:ourPieces){
			if(this.pieceCanMoveToPosition(a, d.getLocation())){
				return true;
			}
		}
		return false;
	}
	
	//asks if a piece is threatened
	public boolean pieceIsThreatened(Piece p) {
		DerpyPiece d = (DerpyPiece)p;
		for(Piece a:theirPieces) {
			if(this.pieceCanMoveToPosition(a, d.getLocation())){
				if(this.pieceIsMoreValuable(a,p)){
					return true;
				}
				else if(this.pieceIsProtected(p)){
					return false;
				}
				else{
					return true;
				}
			}
		}
		return false; 
	}

	//Returns if the king is in check
	public boolean inCheck() {
		
		boolean b = false;
		
		return b;
	} 
	
	//makes a move to get out of check
	public Board getOutOfCheck(Board b){
		return b;
	}
	
	public boolean pieceCanMoveToPosition(Piece piece, Point position) {
		
		int xPos = (int)position.getX();
		int yPos = (int)position.getY();
		
		//We need to get the Piece object at that position
		
		//Iterate through each Piece to figure out whether there's a piece at that position, or is it blank?
		
		Piece targetPiece = null;
		for(Piece p : ourPieces) {
			DerpyPiece d = (DerpyPiece)p;
			Point piecePosition = d.getLocation();
		}
		
		
		
		return false;
	}
	
	//uses provided board to make a move, returns a board with the move made
	
	public Board movePiece(Piece p, Point mL){
		Board theBoard = currentBoard; 
		//Point oL = p.getLocation(); //This will access the instance data in the piece class that contain its location. 
		//p.changeLocation(mL); //This will change the instance data above to the new location and erase the piece from its prior location. 
		//theBoard = theBoard.updateLocations(); //This will have the board update its array locations; could potentially just be a function of changeLocation() but for now I have it as a separate method. 
		
		return theBoard; 
	}
	
	public Board makeMove(Board b){
		
		boardStore.add(b);
		
		Board boardWithPieceMoved = null;
		
		if (this.inCheck()){
			//We're in check, call getOutOfCheck to get us a board where we're not in check
			boardWithPieceMoved = this.getOutOfCheck(b);
		}
		else {


		}
		boardStore.add(boardWithPieceMoved);
		currentBoard = boardWithPieceMoved;
		if(this.inCheck())concedeGame(); //If we're still in check even after all that, there's no way out of check. Concede to the other player.
		
		return boardWithPieceMoved;
	}
	
	public void concedeGame() {
		System.out.println("DerpyAI has lost the game.");
		System.exit(0); //Exit with terminated status 0
	}

}


