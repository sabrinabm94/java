package objectOriented.chess;

import objectOriented.chess.Board;
import objectOriented.chess.exception.ChessException;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.Piece;
import objectOriented.chess.piece.attribute.ChessPosition;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;
import objectOriented.chess.piece.pieces.*;

public class ChessMatch {
    private Board board;

    public ChessMatch() {
        board = new Board(8,8);
        createAllPieces();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] matrix = new ChessPiece[board.getRows()][board.getColumns()];

        for(int i = 0; i < board.getRows(); i++) {
            for(int j = 0; j < board.getColumns(); j++) {
                matrix[i][j] = (ChessPiece)board.piece(i, j);
            }
        }

        return matrix;
    }

    private void createPiece(char column, int row, ChessPiece piece) {
        board.createPiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void createAllPieces() {
        /*
        //Adição de testes por posição
        board.createPiece(new Rook(board, Color.WHITE), new Position(2, 1));
        board.createPiece(new King(board, Color.WHITE, this), new Position(0, 4));
        board.createPiece(new King(board, Color.BLACK, this), new Position(7, 4));

        Teste de exceções
        board.createPiece(new Rook(board, Color.WHITE), new Position(9, 1));
        board.createPiece(new King(board, Color.WHITE), new Position(2, 1));
         */

        //Adição de testes por char e row
        createPiece('a', 1, new Rook(board, Color.WHITE));
        createPiece('b', 1, new Knight(board, Color.WHITE));
        createPiece('c', 1, new Bishop(board, Color.WHITE));
        createPiece('d', 1, new Queen(board, Color.WHITE));
        createPiece('e', 1, new King(board, Color.WHITE, this));
        createPiece('f', 1, new Bishop(board, Color.WHITE));
        createPiece('g', 1, new Knight(board, Color.WHITE));
        createPiece('h', 1, new Rook(board, Color.WHITE));
        //createPiece('a', 2, new Pawn(board, Color.WHITE, this));
        createPiece('b', 2, new Pawn(board, Color.WHITE, this));
        createPiece('c', 2, new Pawn(board, Color.WHITE, this));
        createPiece('d', 2, new Pawn(board, Color.WHITE, this));
        //createPiece('e', 2, new Pawn(board, Color.WHITE, this));
        createPiece('f', 2, new Pawn(board, Color.WHITE, this));
        createPiece('g', 2, new Pawn(board, Color.WHITE, this));
        createPiece('h', 2, new Pawn(board, Color.WHITE, this));

        createPiece('a', 8, new Rook(board, Color.BLACK));
        createPiece('b', 8, new Knight(board, Color.BLACK));
        createPiece('c', 8, new Bishop(board, Color.BLACK));
        createPiece('d', 8, new Queen(board, Color.BLACK));
        createPiece('e', 8, new King(board, Color.BLACK, this));
        createPiece('f', 8, new Bishop(board, Color.BLACK));
        createPiece('g', 8, new Knight(board, Color.BLACK));
        createPiece('h', 8, new Rook(board, Color.BLACK));
        createPiece('a', 7, new Pawn(board, Color.BLACK, this));
        createPiece('b', 7, new Pawn(board, Color.BLACK, this));
        createPiece('c', 7, new Pawn(board, Color.BLACK, this));
        createPiece('d', 7, new Pawn(board, Color.BLACK, this));
        createPiece('e', 7, new Pawn(board, Color.BLACK, this));
        createPiece('f', 7, new Pawn(board, Color.BLACK, this));
        createPiece('g', 7, new Pawn(board, Color.BLACK, this));
        createPiece('h', 7, new Pawn(board, Color.BLACK, this));
    }

    public ChessPiece performeChessMove(ChessPosition originPosition, ChessPosition targetPosition) {
        Position origin = originPosition.toPosition();
        Position target = targetPosition.toPosition();

        validateOriginPosition(origin);
        validateTargetPosition(origin, target);
        Piece removedPiece = movePiece(origin, target);

        return (ChessPiece)removedPiece;
    }

    private Piece movePiece(Position origin, Position target) {
        Piece pieceToMove = board.removePiece(origin);
        Piece pieceToRemove = board.removePiece(target); //remove a peça que está na posição de destino da peça movida
        board.createPiece(pieceToMove, target); //adiciona a peça na nova na nova posição

        return pieceToRemove; //retorna a peça removida do tabuleiro
    }

    public boolean[][] possiblePieceMoves(ChessPosition originPosition) {
        Position position = originPosition.toPosition();
        validateOriginPosition(position);

        return board.piece(position).createPossiblePieceMoves();
    }

    private void validateOriginPosition(Position position) {
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on origin position");
        }

        if(!board.piece(position).isAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position origin, Position target) {
        if(!board.piece(origin).createPossiblePieceMoves(target)) {
            throw new ChessException("The chosen piece can't move to the target position");
        }
    }
}
