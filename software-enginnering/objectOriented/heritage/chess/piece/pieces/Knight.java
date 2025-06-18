package objectOriented.heritage.chess.piece.pieces;

import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.ChessPiece;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.attribute.Position;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "N";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position origion) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origion.getRow(), origion.getColumn());

        //andará as posições da peça e adicionará true nas que poderá ser movida
        //acima(linhas)
        positionOfPiece.setRow(origion.getRow() - 1);
        positionOfPiece.setColumn(origion.getColumn() - 2);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //abaixo
        positionOfPiece.setRow(origion.getRow() - 2);
        positionOfPiece.setColumn(origion.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //esquerda
        positionOfPiece.setRow(origion.getRow() - 2);
        positionOfPiece.setColumn(origion.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //direita
        positionOfPiece.setRow(origion.getRow() - 1);
        positionOfPiece.setColumn(origion.getColumn() + 2);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //noroeste
        positionOfPiece.setRow(origion.getRow() + 1);
        positionOfPiece.setColumn(origion.getColumn() + 2);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //nordeste
        positionOfPiece.setRow(origion.getRow() + 2);
        positionOfPiece.setColumn(origion.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldoeste
        positionOfPiece.setRow(origion.getRow() + 2);
        positionOfPiece.setColumn(origion.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldeste
        positionOfPiece.setRow(origion.getRow() + 1);
        positionOfPiece.setColumn(origion.getColumn() - 2);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePossition(Position positionOfPiece, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(positionOfPiece) && canMove(positionOfPiece)) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }

    private boolean canMove(Position target) {
        ChessPiece position = (ChessPiece)getBoard().piece(target);
        return position == null || position.getColor() != getColor();
    }
}
