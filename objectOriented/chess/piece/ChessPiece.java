package objectOriented.chess.piece;

import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;

public abstract class ChessPiece extends Piece {
    //a classe é abstrata pois não queremos implementar o método createPossiblePieceMoves aqui, e sim nas classes das peças específicas como por exemplo King
    private Color color;

    public Color getColor() {
        return color;
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
}
