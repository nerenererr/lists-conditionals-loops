package exceptions;

public class InactiveConcertException extends Throwable {
    public InactiveConcertException() {
        super("The concert is not active");
    }

    public InactiveConcertException(String message) {
        super(message);
    }
}
