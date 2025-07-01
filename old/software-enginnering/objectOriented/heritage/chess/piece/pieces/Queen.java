package objectOriented.heritage.chess.piece.pieces;

import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.ChessPiece;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.attribute.Position;

public class Queen extends ChessPiece {

    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "Q";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position origin) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origin.getRow(), origin.getColumn());

        //acima
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn());
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() - 1, -1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        //abaixo
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn());
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, positionOfPiece.getRow() + 1, -1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);


        //direita
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() + 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, -1, + 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

        //esquerda
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() - 1);
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix = createPossiblePieceMoves(positionOfPiece, -1, - 1, possiblePieceMovesMatrix);
        }
        possiblePieceMovesMatrix = verifyPositionAndEnemyPiece(positionOfPiece, possiblePieceMovesMatrix);

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
