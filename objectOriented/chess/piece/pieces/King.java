package objectOriented.chess.piece.pieces;

import objectOriented.chess.ChessMatch;
import objectOriented.chess.Board;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Position;

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
    public boolean[][] createPossiblePieceMoves() {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position position = new Position(0,0);

        //andará as posições da peça e adicionará true nas que poderá ser movida
        //acima(linhas)
        position.setRow(position.getRow() - 1);
        position.setColumn(position.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //abaixo
        position.setRow(position.getRow() + 1);
        position.setColumn(position.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //esquerda
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //direita
        position.setRow(position.getRow());
        position.setColumn(position.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //noroeste
        position.setRow(position.getRow() - 1);
        position.setColumn(position.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //nordeste
        position.setRow(position.getRow() - 1);
        position.setColumn(position.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //suldoeste
        position.setRow(position.getRow() + 1);
        position.setColumn(position.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        //suldeste
        position.setRow(position.getRow() + 1);
        position.setColumn(position.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(position, possiblePieceMovesMatrix);

        return possiblePieceMovesMatrix;
    }

    private boolean[][] createPossiblePieceMovePossition(Position position, boolean[][] possiblePieceMovesMatrix) {
        if(getBoard().positionExists(position) && canMove(position)) {
            possiblePieceMovesMatrix[position.getRow()][position.getColumn()] = true;
        }

        return possiblePieceMovesMatrix;
    }

    private boolean canMove(Position target) {
        ChessPiece piece = (ChessPiece)getBoard().piece(target);
        return piece != null || piece.getColor() != getColor(); //pode mover: a casa está vazia ou tem uma peça adversária
    }
}
