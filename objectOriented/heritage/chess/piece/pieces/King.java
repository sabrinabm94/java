package objectOriented.heritage.chess.piece.pieces;

import objectOriented.heritage.chess.ChessMatch;
import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.ChessPiece;
import objectOriented.heritage.chess.piece.attribute.Position;

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
    public boolean[][] createPossiblePieceMoves(Position origin) {
        boolean[][] possiblePieceMovesMatrix = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position positionOfPiece = new Position(origin.getRow(), origin.getColumn());

        //andará as posições da peça e adicionará true nas que poderá ser movida
        //acima(linhas)
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //abaixo
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn());
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //esquerda
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //direita
        positionOfPiece.setRow(origin.getRow());
        positionOfPiece.setColumn(origin.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //noroeste
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //nordeste
        positionOfPiece.setRow(origin.getRow() - 1);
        positionOfPiece.setColumn(origin.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldoeste
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn() - 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        //suldeste
        positionOfPiece.setRow(origin.getRow() + 1);
        positionOfPiece.setColumn(origin.getColumn() + 1);
        possiblePieceMovesMatrix = createPossiblePieceMovePossition(positionOfPiece, possiblePieceMovesMatrix);

        /*
        //Rook Castling
        if(getMoveCounter() == 0 && !chessMatch.getCheck()) {
            possiblePieceMovesMatrix = verifyKingSideRook(origin, possiblePieceMovesMatrix);
            possiblePieceMovesMatrix = verifyQueenSideRook(origin, possiblePieceMovesMatrix);
        }
        */

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
        return piece == null || piece.getColor() != getColor();
    }

    private boolean verifyRookCastling(Position position) {
        ChessPiece piece = (ChessPiece)getBoard().piece(position);
        //valida se tem uma torre na posição indicada apta para realizar o rook, para isso ela precisa ter movimentos 0
        return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCounter() == 0;
    }

    private boolean[][] verifyKingSideRook(Position origin, boolean[][] possiblePieceMovesMatrix) {
        //rook pequeno (do lado do rei)
        Position kingSideRook = new Position(origin.getRow(), origin.getColumn() + 3);
        if(verifyRookCastling(kingSideRook)) {
            Position kingRight = new Position(origin.getRow(), origin.getColumn() + 1);
            Position kingRightRight = new Position(origin.getRow(), origin.getColumn() + 2);

            if(getBoard().piece(kingRight) == null && getBoard().piece(kingRightRight) == null) {
                //as 2 casas a direita do rei estão livres
                possiblePieceMovesMatrix[origin.getRow()][origin.getColumn() + 2] = true;
            }
        }

        return possiblePieceMovesMatrix;
    }

    private boolean[][] verifyQueenSideRook(Position origin, boolean[][] possiblePieceMovesMatrix) {
        //rook grande (do lado da rainha)
        Position queenSideRook = new Position(origin.getRow(), origin.getColumn() - 4);
        if(verifyRookCastling(queenSideRook)) {
            Position queenRight = new Position(origin.getRow(), origin.getColumn() - 1);
            Position queenRightRight = new Position(origin.getRow(), origin.getColumn() - 2);
            Position queenRightRightRight = new Position(origin.getRow(), origin.getColumn() - 3);

            if(getBoard().piece(queenRight) == null && getBoard().piece(queenRightRight) == null && getBoard().piece(queenRightRightRight) == null) {
                //as 2 casas a direita do rei estão livres
                possiblePieceMovesMatrix[origin.getRow()][origin.getColumn() - 2] = true;
            }
        }

        return possiblePieceMovesMatrix;
    }
}
