package objectOriented.chess.piece.pieces;

import objectOriented.chess.piece.Board;
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
    public boolean[][] possiblePieceMoves() {
        boolean[][] possibleMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0,0);

        //andará as posições da peça e adicionará true nas que poderá ser movida
        //acima da peça (linhas)
        position.setRow(position.getRow() - 1);
        position.setColumn(position.getColumn());

        while (getBoard().positionExists(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
        }
        if (getBoard().positionExists(position) && isOpponentPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        //abaixo
        position.setRow(position.getRow() + 1);
        position.setColumn(position.getColumn());

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
        }
        //se a posição existe, se a peça que existe na posição e inimiga
        if (getBoard().positionExists(position) && isOpponentPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        //direita
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() + 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() + 1);
        }
        if (getBoard().positionExists(position) && isOpponentPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        //esquerda
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() - 1);

        while (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() - 1);
        }
        if (getBoard().positionExists(position) && isOpponentPiece(position)) {
            possibleMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        return possibleMovesMatrix;
    }
}
