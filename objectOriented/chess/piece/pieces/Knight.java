package objectOriented.chess.piece.pieces;

import objectOriented.chess.Board;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "N";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position position) {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return possibleMovesMatrix;
    }
}
