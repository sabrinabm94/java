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
    private Color currentPlayerColor;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerablePiece;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public ChessPiece getEnPassantVulnerablePiece() {
        return enPassantVulnerablePiece;
    }

    public void setEnPassantVulnerablePiece(ChessPiece enPassantVulnerablePiece) {
        this.enPassantVulnerablePiece = enPassantVulnerablePiece;
    }

    public ChessMatch() {
        board = new Board(8,8);
        turn = 1;
        currentPlayerColor = Color.WHITE;
        createAllPieces();
        //createPiecesToTestCheck();
    }

    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayerColor() {
        return currentPlayerColor;
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
        createPiece('e', 1, new King(board, Color.WHITE, this));
        createPiece('b', 8, new Rook(board, Color.BLACK));
        createPiece('a', 8, new King(board, Color.BLACK, this));
    }

    public ChessPiece performeChessMove(ChessPosition originPosition, ChessPosition targetPosition) {
        Position origin = originPosition.toPosition();
        Position target = targetPosition.toPosition();

        validateOriginPosition(origin);
        validateTargetPosition(origin, target);
        Piece removedPiece = movePiece(origin, target);

        verifyCheckByCurrentPlayer(currentPlayerColor, origin, target, removedPiece);

        ChessPiece movedPiece = (ChessPiece)board.piece(target);

        Boolean promoted = null;
        if(movedPiece instanceof Pawn) {
            if(movedPiece.getColor() == Color.WHITE && target.getRow() == 0) {

            }
        }
        check = verifyCheckByOpponnent(currentPlayerColor);
        checkMate = verifyCheckMateByOpponent(currentPlayerColor);
        //enPassantVulnerablePiece = verifyEnPassant(movedPiece, origin, target);

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

        makeKingSideRook(pieceToMove, origin, target);
        makeQueenSideRook(pieceToMove, origin, target);
        makeEnPassant(pieceToMove, pieceToRemove, origin, target);

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

        return board.piece(position).createPossiblePieceMoves(position);
    }

    private void validateOriginPosition(Position position) {
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on origin position");
        }

        if(currentPlayerColor != ((ChessPiece)board.piece(position)).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isAnyPossibleMove(position)) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }

    private void validateTargetPosition(Position origin, Position target) {
        if(!board.piece(origin).PiecePossibleMoveToPosition(origin, target)) {
            throw new ChessException("The chosen piece can't move to the target position");
        }
    }

    private void nextTurn() {
        turn++;
        currentPlayerColor = (currentPlayerColor == Color.WHITE) ? Color.BLACK : Color.WHITE; //expressão ternária
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

    private void verifyCheckByCurrentPlayer(Color currentPlayerColor, Position origin, Position target, Piece piece) {
        if(verifyCheckPossibilityInTheKing(currentPlayerColor)) {
            undoMovePiece(origin, target, piece);
            throw new ChessException("You can't put yourself in check");
        }
    }

    private boolean verifyCheckByOpponnent(Color currentPlayerColor) {
        return (verifyCheckPossibilityInTheKing(opponent(currentPlayerColor))) ? true : false;
    }

    private boolean verifyCheckMateByOpponent(Color currentPlayerColor) {
        if(verifyCheckMatePossibilityInTheKing((opponent(currentPlayerColor)))) {
            return true;
        } else {
            nextTurn();
        }

        return false;
    }

    private boolean verifyCheckPossibilityInTheKing(Color color) {
        Position kingPosition = searchForKing(color).getChessPosition().toPosition(); //pega a posição do rei em forma de matriz
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(piece -> ((ChessPiece)piece).getColor() == opponent(color)).collect(Collectors.toList());
        for(Piece piece: opponentPieces) {
            boolean[][] piecePossibleMovesMatrix = piece.createPossiblePieceMoves(new Position(0, 0));
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
            boolean[][] piecePossibleMovesMatrix = piece.createPossiblePieceMoves(new Position(0,0));
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

    private void makeKingSideRook(ChessPiece pieceToMove, Position origin, Position target) {
        if (pieceToMove instanceof King && target.getColumn() == origin.getColumn() + 2) {
            Position originOfRook = new Position(origin.getRow(), origin.getColumn() + 3);
            Position targetOfRook = new Position(origin.getRow(), origin.getColumn() + 1);
            ChessPiece rook = (ChessPiece) board.removePiece(originOfRook);
            board.createPiece(rook, targetOfRook);
            rook.increaseMoveCounter();
        }
    }

    private void undoKingSideRook(ChessPiece pieceToMove, Position origin, Position target) {
        if (pieceToMove instanceof King && target.getColumn() == origin.getColumn() + 2) {
            Position originOfRook = new Position(origin.getRow(), origin.getColumn() + 3);
            Position targetOfRook = new Position(origin.getRow(), origin.getColumn() + 1);
            ChessPiece rook = (ChessPiece) board.removePiece(targetOfRook);
            board.createPiece(rook, origin);
            rook.decreaseMoveCounter();
        }
    }

    private void makeQueenSideRook(ChessPiece pieceToMove, Position origin, Position target) {
        if (pieceToMove instanceof King && target.getColumn() == origin.getColumn() - 2) {
            Position originOfRook = new Position(origin.getRow(), origin.getColumn() - 4);
            Position targetOfRook = new Position(origin.getRow(), origin.getColumn() - 1);
            ChessPiece rook = (ChessPiece) board.removePiece(originOfRook);
            board.createPiece(rook, targetOfRook);
            rook.increaseMoveCounter();
        }
    }

    private void undoQueenSideRook(ChessPiece pieceToMove, Position origin, Position target) {
        if (pieceToMove instanceof King && target.getColumn() == origin.getColumn() - 2) {
            Position originOfRook = new Position(origin.getRow(), origin.getColumn() - 4);
            Position targetOfRook = new Position(origin.getRow(), origin.getColumn() - 1);
            ChessPiece rook = (ChessPiece) board.removePiece(targetOfRook);
            board.createPiece(rook, origin);
            rook.decreaseMoveCounter();
        }
    }

    private ChessPiece verifyEnPassant(ChessPiece chessPiece, Position origin, Position target) {
        if(chessPiece instanceof Pawn && target.getRow() == origin.getRow() - 2 || target.getRow() == origin.getRow()  + 2) {
            return chessPiece;
        } else {
            return null;
        }
    }

    private Piece makeEnPassant(ChessPiece pieceToMove, Piece pieceToRemove, Position origin, Position target) {
        //En Passant
        if(pieceToMove instanceof Pawn) {
            if(origin.getColumn() != target.getColumn() && pieceToRemove == null) {
                Position pawnPosition;
                if(pieceToMove.getColor() == Color.WHITE) {
                    pawnPosition = new Position(target.getRow() + 1, target.getColumn());
                } else {
                    pawnPosition = new Position(target.getRow() - 1, target.getColumn());
                }
                pieceToRemove = board.removePiece(pawnPosition);
                capturedPieces.add(pieceToRemove);
                piecesOnTheBoard.remove(pieceToRemove);
            }
        }

        return pieceToRemove;
    }

    private Piece undoEnPassant(ChessPiece pieceToMove, Piece pieceToRemove, Position origin, Position target) {
        //En Passant
        if(pieceToMove instanceof Pawn) {
            if(origin.getColumn() != target.getColumn() && pieceToRemove == enPassantVulnerablePiece) {
                ChessPiece pawn = (ChessPiece)board.removePiece(target);
                Position pawnPosition;
                if(pieceToMove.getColor() == Color.WHITE) {
                    pawnPosition = new Position(3, target.getColumn());
                } else {
                    pawnPosition = new Position(4, target.getColumn());
                }
                board.createPiece(pawn, pawnPosition);
            }
        }

        return pieceToRemove;
    }
}
