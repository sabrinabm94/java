package objectOriented.chess.piece.pieces;

import objectOriented.chess.Board;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "B";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position position) {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return possibleMovesMatrix;
    }
}