package objectOriented.chess.piece;

import objectOriented.chess.Board;
import objectOriented.chess.piece.attribute.Position;

public abstract class Piece {
    public Position position; //posição da matriz e não da peça
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null; //a peça é criada mas ainda não está no tabuleiro
    }

    protected Board getBoard() { //somente classes do mesmo pacote e subclasses poderão acessar o tabuleiro
        return board;
    }

    public abstract boolean[][] createPossiblePieceMoves();

    //método concreto utilizando um método abstrato
    public boolean createPossiblePieceMoves(Position position) {
        return createPossiblePieceMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isAnyPossibleMove() {
        boolean[][] possiblePieceMovesMatrix = createPossiblePieceMoves();
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
