package objectOriented.heritage.chess.piece.pieces;

import objectOriented.heritage.chess.ChessMatch;
import objectOriented.heritage.chess.Board;
import objectOriented.heritage.chess.piece.ChessPiece;
import objectOriented.heritage.chess.piece.attribute.Color;
import objectOriented.heritage.chess.piece.attribute.Position;

public class Pawn extends ChessPiece {
    //associação dos objetos
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

            //possiblePieceMovesMatrix = verifyEnPassant(possiblePieceMovesMatrix, origion, "white");
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

            possiblePieceMovesMatrix = verifyEnPassant(possiblePieceMovesMatrix, origion, "black");
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

    private boolean[][] verifyEnPassant(boolean[][] possiblePieceMovesMatrix, Position position, String color) {
        //enPassant
        //Esse movimento só pode acontecer quando o pião estiver na minha 5 do tabuleiro (3 da matriz)
        if(color == "WHITE") {
            if(position.getRow() == 3) {
                Position pieceLeft =  new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(pieceLeft) && isOpponentPiece(pieceLeft) && getBoard().piece(pieceLeft) == chessMatch.getEnPassantVulnerablePiece()) {
                    possiblePieceMovesMatrix[pieceLeft.getRow() - 1][pieceLeft.getColumn()] = true;
                }

                Position pieceright =  new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(pieceright) && isOpponentPiece(pieceright) && getBoard().piece(pieceright) == chessMatch.getEnPassantVulnerablePiece()) {
                    possiblePieceMovesMatrix[pieceright.getRow() - 1][pieceright.getColumn()] = true;
                }
            }
        } else {
            if(position.getRow() == 4) {
                Position pieceLeft =  new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(pieceLeft) && isOpponentPiece(pieceLeft) && getBoard().piece(pieceLeft) == chessMatch.getEnPassantVulnerablePiece()) {
                    possiblePieceMovesMatrix[pieceLeft.getRow() + 1][pieceLeft.getColumn()] = true;
                }

                Position pieceright =  new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(pieceright) && isOpponentPiece(pieceright) && getBoard().piece(pieceright) == chessMatch.getEnPassantVulnerablePiece()) {
                    possiblePieceMovesMatrix[pieceright.getRow() + 1][pieceright.getColumn()] = true;
                }
            }
        }

        return possiblePieceMovesMatrix;
    }
}

