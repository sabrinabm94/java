package objectOriented.chess.piece.pieces;

import objectOriented.chess.ChessMatch;
import objectOriented.chess.piece.Board;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.ChessPiece;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String getInitial() {
        return "K";
    }

    @Override
    public boolean[][] possiblePieceMoves() {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return possibleMovesMatrix;
    }
}
