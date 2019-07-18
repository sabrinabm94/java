package objectOriented.chess.exception;

public class BoardException extends RuntimeException {
    public BoardException(String errorMessage) {
        super(errorMessage);
    }
}
