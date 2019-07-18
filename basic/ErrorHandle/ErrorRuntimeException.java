package ErrorHandle;

public class ErrorRuntimeException extends RuntimeException {
    /*
    RuntimeException
    Tipo de excessão que não é obrigado tratar
     */

    public ErrorRuntimeException(String message) {
        super(message);
    }
}
