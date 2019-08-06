package objectOriented.heritage.chess.piece.pieces;

import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.ChessPiece;
import objectOriented.heritage.chess.piece.attribute.Position;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "R";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position origin) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origin.getRow(), origin.getColumn());

        //acima(linhas)
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, positionOfPiece.getRow() - 1, -1, possiblePieceMovesMatrix);

        //abaixo(linhas)
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, positionOfPiece.getRow() + 1, -1, possiblePieceMovesMatrix);

        //direita(coluna)
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, -1, positionOfPiece.getColumn() + 1, possiblePieceMovesMatrix);

        //esquerda(coluna)
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, -1, positionOfPiece.getColumn() - 1, possiblePieceMovesMatrix);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePossition(Position positionOfPiece, int row, int column, boolean[][] possiblePieceMovesMatrix) {
        //enquanto a posição existir e não tiver uma peça na posição, é valido
        while(getBoard().positionExists(positionOfPiece) && !getBoard().thereIsAPiece(positionOfPiece)) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;

            //o -1 é usado para indicar se o parâmetro é a linha ou coluna, anulando o que receber -1
            if(row != -1) {
                positionOfPiece.setRow(row);
            } else if(column != -1) {
                positionOfPiece.setColumn(column);
            }
        }
        //se a posição exite e se a peça que existe na posição é inimiga, é valido
        if(getBoard().positionExists(positionOfPiece) && isOpponentPiece(positionOfPiece)) {
            possiblePieceMovesMatrix[positionOfPiece.getRow()][positionOfPiece.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }
}
