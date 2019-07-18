package objectOriented.chess;

import objectOriented.chess.piece.attribute.Position;
import objectOriented.chess.exception.BoardException;
import objectOriented.chess.piece.Piece;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] piecesInBoard;

    private String minimumNumberOfRowsAndColumnsErrorMessage = "Error: the board need be at least 1 row and 1 column.";
    private String positionDoesNotExistErrorMessage = "Error: this position does not exist on the board.";
    private String positionIsOccupiedErrorMessage = "Error: this position is occupied.";

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1) {
            new BoardException(minimumNumberOfRowsAndColumnsErrorMessage);
        }
        this.rows = rows;
        this.columns = columns;
        piecesInBoard = new Piece[rows][columns];
    }

    public Piece piece(int row, int column) {
        if(!positionExists(row, column)) {
            throw new BoardException(positionDoesNotExistErrorMessage + "\nRow: " + row + " Column: " + column);
        }

        return piecesInBoard[row][column];
    }

    //sobrecarga
    public Piece piece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException(positionDoesNotExistErrorMessage);
        }

        return piecesInBoard[position.getRow()][position.getColumn()];
    }

    public void createPiece(Piece piece, Position position) {
        if(thereIsAPiece(position)) {
            throw new BoardException(positionIsOccupiedErrorMessage + "\nRow: " + position.getRow() + " Column: " + position.getColumn());
        }
        piecesInBoard[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException(positionDoesNotExistErrorMessage + "\nRow: " + position.getRow() + " Column: " + position.getColumn());
        }

        if(piece(position) == null) {
            return null;
        }

        Piece helper = piece(position);
        helper.position = null;
        piecesInBoard[position.getRow()][position.getColumn()] = null;

        return helper;
    }

    private boolean positionExists(int row, int column) {
        return((row >= 0 && row < rows) && (column >= 0 && column < columns));
    }

    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException(positionDoesNotExistErrorMessage + "\nRow: " + position.getRow() + " Column: " + position.getColumn());
        }

        return piece(position) != null;
    }
}
