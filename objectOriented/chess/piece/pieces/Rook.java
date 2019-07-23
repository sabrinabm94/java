package objectOriented.chess.piece.pieces;

import objectOriented.chess.Board;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Position;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String getInitial() {
        return "R";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position position) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(position.getRow(), position.getColumn());

        //acima(linhas)
        position.setRow(position.getRow() - 1);
        position.setColumn(position.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, position.getRow() - 1, -1, possiblePieceMovesMatrix);

        //abaixo(linhas)
        position.setRow(position.getRow() + 1);
        position.setColumn(position.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, position.getRow() + 1, -1, possiblePieceMovesMatrix);

        //direita(coluna)
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, -1, position.getColumn() + 1, possiblePieceMovesMatrix);

        //esquerda(coluna)
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, -1, position.getColumn() - 1, possiblePieceMovesMatrix);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePossition(Position position, int row, int column, boolean[][] possiblePieceMovesMatrix) {
        //enquanto a posição existir e não tiver uma peça na posição, é valido
        while(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            possiblePieceMovesMatrix[position.getRow()][position.getColumn()] = true;

            //o -1 é usado para indicar se o parâmetro é a linha ou coluna, anulando o que receber -1
            if(row != -1) {
                position.setRow(row);
            } else if(column != -1) {
                position.setColumn(column);
            }
        }
        //se a posição exite e se a peça que existe na posição é inimiga, é valido
        if(getBoard().positionExists(position) && isOpponentPiece(position)) {
            possiblePieceMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }
}
