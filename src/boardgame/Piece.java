package boardgame;

public abstract class Piece {
	protected Position position;
	public Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	
	protected Board getBoard() {
		return board;
	}	
}