package objectOriented.chess.piece.pieces;

import objectOriented.chess.ChessMatch;
import objectOriented.chess.Board;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String getInitial() {
        return "P";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position origion) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origion.getRow(), origion.getColumn());

        if(getColor() == Color.WHITE) {
            positionOfPiece.setRow(origion.getRow() - 1);
            positionOfPiece.setColumn(origion.getColumn());
            possiblePieceMovesMatrix = createPossiblePieceMovePosition(positionOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() - 2);
            positionOfPiece.setColumn(origion.getColumn());
            Position positionInFrontOfPiece = new Position(origion.getRow() - 1, origion.getColumn());
            possiblePieceMovesMatrix = createPossiblePieceMovePosition(positionOfPiece, positionInFrontOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() - 1);
            positionOfPiece.setColumn(origion.getColumn() - 1);
            possiblePieceMovesMatrix = createPossiblePieceMovePositionToGetOpponentPiece(positionOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() - 1);
            positionOfPiece.setColumn(origion.getColumn() + 1);
            possiblePieceMovesMatrix = createPossiblePieceMovePositionToGetOpponentPiece(positionOfPiece, possiblePieceMovesMatrix);
        } else {
            positionOfPiece.setRow(origion.getRow() + 1);
            positionOfPiece.setColumn(origion.getColumn());
            possiblePieceMovesMatrix = createPossiblePieceMovePosition(positionOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() + 2);
            positionOfPiece.setColumn(origion.getColumn());
            Position positionInFrontOfPiece = new Position(positionOfPiece.getRow() + 1, positionOfPiece.getColumn());
            possiblePieceMovesMatrix = createPossiblePieceMovePosition(positionOfPiece, positionInFrontOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() + 1);
            positionOfPiece.setColumn(origion.getColumn() - 1);
            possiblePieceMovesMatrix = createPossiblePieceMovePositionToGetOpponentPiece(positionOfPiece, possiblePieceMovesMatrix);

            positionOfPiece.setRow(origion.getRow() + 1);
            positionOfPiece.setColumn(origion.getColumn() + 1);
            possiblePieceMovesMatrix = createPossiblePieceMovePositionToGetOpponentPiece(positionOfPiece, possiblePieceMovesMatrix);
        }

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePosition(Position positionOfPiece, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePosition(Position positionOfPiece, Position positionInFrontOfPiece, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(positionOfPiece) &&
                !getBoard().thereIsAPiece(positionOfPiece) &&
                getBoard().positionExists(positionInFrontOfPiece) &&
                !getBoard().thereIsAPiece(positionInFrontOfPiece) &&
                getMoveCounter() == 0) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePositionToGetOpponentPiece(Position position, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(position) && isOpponentPiece(position)) {
            possiblePieceMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }
}

