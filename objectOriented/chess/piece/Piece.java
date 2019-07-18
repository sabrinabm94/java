package objectOriented.chess.piece;

import objectOriented.chess.piece.attribute.Position;

public abstract class Piece {
    protected Position position; //posição da matriz e não da peça
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //a peça é criada mas ainda não está no tabuleiro
    }

    protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro
        return board;
    }

    public abstract boolean[][] possiblePieceMoves();

    //método concreto utilizando um método abstrato
    public boolean possiblePieceMoves(Position position) {
        return possiblePieceMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove() {
        boolean[][] possiblePieceMovesMatrix = possiblePieceMoves();
        for(int i = 0; i < possiblePieceMovesMatrix.length; i++) {
            for(int j = 0; j < possiblePieceMovesMatrix.length; j++) {
                if(possiblePieceMovesMatrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
