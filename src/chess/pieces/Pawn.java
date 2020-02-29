package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	public ChessMatch chessMatch;

	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[board.getRows()][board.getColumns()];

		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			p.setValues(position.getRow() - 2, position.getColumn());

			if (getBoard().positionExists(p) 
					&& getBoard().positionExists(p2) 
					&& !getBoard().thereIsAPiece(p)
					&& !getBoard().thereIsAPiece(p2) 
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() - 1);

			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() - 1, position.getColumn() + 1);

			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #specialmove en passant white
			// En passant is a move in chess. It is a special pawn capture that can only occur 
			// immediately after a pawn makes a move of two squares from its starting square.
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(board.positionExists(left) && isThereOpponentPiece(left) && board.piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(board.positionExists(right) && isThereOpponentPiece(right) && board.piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		} else {
			p.setValues(position.getRow() + 1, position.getColumn());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			p.setValues(position.getRow() + 2, position.getColumn());

			if (getBoard().positionExists(p) 
					&& getBoard().positionExists(p2) 
					&& !getBoard().thereIsAPiece(p)
					&& !getBoard().thereIsAPiece(p2) 
					&& getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() - 1);

			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}

			p.setValues(position.getRow() + 1, position.getColumn() + 1);

			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #specialmove en passant black
			// En passant is a move in chess. It is a special pawn capture that can only occur 
			// immediately after a pawn makes a move of two squares from its starting square.
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(board.positionExists(left) && isThereOpponentPiece(left) && board.piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(board.positionExists(right) && isThereOpponentPiece(right) && board.piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}

		return mat;
	}
}