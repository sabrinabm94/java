package objectOriented.chess.piece.pieces;

import objectOriented.chess.piece.Board;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "Q";
    }

    @Override
    public boolean[][] possiblePieceMoves() {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return possibleMovesMatrix;
    }
}
