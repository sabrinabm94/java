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
    public boolean[][] createPossiblePieceMoves(Position origin) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origin.getRow(), origin.getColumn());

        //noroeste
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn() + 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() - 1, positionOfPiece.getColumn() + 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        //nordeste
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn() - 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() - 1, positionOfPiece.getColumn() - 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        //suldeste
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn() + 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() + 1, positionOfPiece.getColumn() + 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        //suldoeste
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn() - 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() + 1, positionOfPiece.getColumn() + 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMoves(Position positionOfPiece, int row, int column, boolean[][] possiblePieceMovesMatrix) {
        possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        positionOfPiece.setRow(row);
        positionOfPiece.setColumn(column);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] verifyPositionAndEnemyPiece(Position positionOfPiece, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(positionOfPiece) && isOpponentPiece(positionOfPiece)) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }
}