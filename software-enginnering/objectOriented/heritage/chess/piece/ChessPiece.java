package objectOriented.heritage.chess.piece;

import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.attribute.ChessPosition;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.attribute.Position;

public abstract class ChessPiece extends Piece {
    //a classe é abstrata pois não queremos implementar o método createPossiblePieceMoves aqui, e sim nas classes das peças específicas como por exemplo King
    private Color color;

    private int moveCounter;

    public Color getColor() {
        return color;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public abstract String getInitial();

    protected boolean isOpponentPiece(Position position) {
        ChessPiece opponentPiece = (ChessPiece)getBoard().piece(position);
        return opponentPiece != null && opponentPiece.getColor() != color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }

    public void increaseMoveCounter() {
        moveCounter++;
    }

    public void decreaseMoveCounter() {
        moveCounter--;
    }
}
