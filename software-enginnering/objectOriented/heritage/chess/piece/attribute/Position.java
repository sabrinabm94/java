package objectOriented.heritage.chess.piece.attribute;

import javaRepositories.Print;

public class Position {
    private int row;
    private int column;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void print() {
        Print.print("\nRow: " + row);
        Print.print("Column: " + column);
    }
}
