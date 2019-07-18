package objectOriented.chess.piece.pieces;

import objectOriented.chess.Board;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "B";
    }

    @Override
    public boolean[][] createPossiblePieceMoves() {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return possibleMovesMatrix;
    }
}