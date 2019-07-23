package objectOriented.chess.piece.pieces;

import objectOriented.chess.ChessMatch;
import objectOriented.chess.Board;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.attribute.Position;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color) {
        super(board, color);
    }

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String getInitial() {
        return "K";
    }

    @Override
    public boolean[][] createPossiblePieceMoves(Position origion) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origion.getRow(), origion.getColumn());

        //andará as posições da peça e adicionará true nas que poderá ser movida
        //acima(linhas)
        positionOfPiece.setRow(origion.getRow() - 1);
        positionOfPiece.setColumn(origion.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //abaixo
        positionOfPiece.setRow(origion.getRow() + 1);
        positionOfPiece.setColumn(origion.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //esquerda
        positionOfPiece.setRow(origion.getRow());
        positionOfPiece.setColumn(origion.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //direita
        positionOfPiece.setRow(origion.getRow());
        positionOfPiece.setColumn(origion.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //noroeste
        positionOfPiece.setRow(origion.getRow() - 1);
        positionOfPiece.setColumn(origion.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //nordeste
        positionOfPiece.setRow(origion.getRow() - 1);
        positionOfPiece.setColumn(origion.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldoeste
        positionOfPiece.setRow(origion.getRow() + 1);
        positionOfPiece.setColumn(origion.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldeste
        positionOfPiece.setRow(origion.getRow() + 1);
        positionOfPiece.setColumn(origion.getColumn() + 1);
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
        ChessPiece piece = (ChessPiece)getBoard().piece(target);
        if(piece != null || piece.getColor() != getColor()) {
            return true;
        } else {
            return false;
        }
    }
}
