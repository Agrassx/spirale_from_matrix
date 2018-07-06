package test2.onetwotrip.exceptions;

public class SquareException extends RuntimeException {

    public SquareException(String message) {
        super(message);
    }

    public SquareException(String message, Throwable cause) {
        super(message, cause);
    }

    public SquareException(Throwable cause) {
        super(cause);
    }
}
