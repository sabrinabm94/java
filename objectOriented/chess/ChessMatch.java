package objectOriented.chess;

import objectOriented.chess.exception.ChessException;
import objectOriented.chess.piece.ChessPiece;
import objectOriented.chess.piece.Piece;
import objectOriented.chess.piece.attribute.ChessPosition;
import objectOriented.chess.piece.attribute.Color;
import objectOriented.chess.piece.attribute.Position;
import objectOriented.chess.piece.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public ChessMatch() {
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
        //createAllPieces();
        createPiecesToTestCheck();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
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
        piecesOnTheBoard.add(piece);
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
        createPiece('a', 2, new Pawn(board, Color.WHITE, this));
        createPiece('b', 2, new Pawn(board, Color.WHITE, this));
        createPiece('c', 2, new Pawn(board, Color.WHITE, this));
        createPiece('d', 2, new Pawn(board, Color.WHITE, this));
        createPiece('e', 2, new Pawn(board, Color.WHITE, this));
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

    private void createPiecesToTestCheck() {
        createPiece('h', 7, new Rook(board, Color.WHITE));
        createPiece('d', 1, new Rook(board, Color.WHITE));
        createPiece('e', 1, new King(board, Color.WHITE));
        createPiece('b', 8, new Rook(board, Color.BLACK));
        createPiece('a', 8, new King(board, Color.BLACK));
    }

    public ChessPiece performeChessMove(ChessPosition originPosition, ChessPosition targetPosition) {
        Position origin = originPosition.toPosition();
        Position target = targetPosition.toPosition();

        validateOriginPosition(origin);
        validateTargetPosition(origin, target);
        Piece removedPiece = movePiece(origin, target);

        if(verifyCheckPossibilityInTheKing(currentPlayer)) {
            undoMovePiece(origin, target, removedPiece);
            throw new ChessException("You can't put yourself in check");
        }

        check = (verifyCheckPossibilityInTheKing(opponent(currentPlayer))) ? true : false;

        if(verifyCheckMatePossibilityInTheKing((opponent(currentPlayer)))) {
            checkMate = true;
        } else {
            nextTurn();
        }

        return (ChessPiece)removedPiece;
    }

    private Piece movePiece(Position origin, Position target) {
        ChessPiece pieceToMove = (ChessPiece)board.removePiece(origin);
        pieceToMove.increaseMoveCounter();

        Piece pieceToRemove = board.removePiece(target); //remove a peça que está na posição de destino da peça movida
        board.createPiece(pieceToMove, target); //adiciona a peça na nova na nova posição

        if(pieceToRemove != null) {
            piecesOnTheBoard.remove(pieceToRemove);
            capturedPieces.add(pieceToRemove);
        }
        return pieceToRemove; //retorna a peça removida do tabuleiro
    }

    private void undoMovePiece(Position origin, Position target, Piece capturedPiece) {
        ChessPiece piece = (ChessPiece)board.removePiece(target); //remove peça do destino
        piece.decreaseMoveCounter();

        board.createPiece(piece, origin);

        if(capturedPiece != null) {
            board.createPiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
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

        if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
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

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE; //expressão ternária
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece searchForKing(Color color) {
        List<Piece> piecesOnBoardList = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece)piece).getColor() == color).collect(Collectors.toList()); //predicado: expressões lambda para filtrar lista
        for(Piece piece: piecesOnBoardList) {
            if(piece instanceof King) { //rei encontrado
                return (ChessPiece)piece;
            }
        }

        throw new IllegalStateException("Don't exist a " + color + " King in the board");
    }

    private boolean verifyCheckPossibilityInTheKing(Color color) {
        Position kingPosition = searchForKing(color).getChessPosition().toPosition(); //pega a posição do rei em forma de matriz
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece)piece).getColor() == opponent(color)).collect(Collectors.toList());
        for(Piece piece: opponentPieces) {
            boolean[][] piecePossibleMovesMatrix = piece.createPossiblePieceMoves();
            if(piecePossibleMovesMatrix[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyCheckMatePossibilityInTheKing(Color color) {
        if(!verifyCheckPossibilityInTheKing(color)) {
            return false;
        }

        List<Piece> yourPieces = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece)piece).getColor() == color).collect(Collectors.toList());
        for(Piece piece: yourPieces) {
            boolean[][] piecePossibleMovesMatrix = piece.createPossiblePieceMoves();
            for(int i = 0; i < board.getRows(); i++) {
                for(int j = 0; j < board.getRows(); j++) {
                    if(piecePossibleMovesMatrix[i][j]) {
                        Position origin = ((ChessPiece)piece).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = movePiece(origin, target);
                        boolean verifyCheck = verifyCheckPossibilityInTheKing(color);
                        undoMovePiece(origin, target, capturedPiece);

                        if(!verifyCheck) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
