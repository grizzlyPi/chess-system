package boardgame;

public class Board {
	public int rows;
	public int columns;
	
	public Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
			return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
	}
}
