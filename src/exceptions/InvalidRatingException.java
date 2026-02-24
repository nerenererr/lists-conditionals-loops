package exceptions;

public class InvalidRatingException extends Throwable {
    public InvalidRatingException() {
        super("Rating must be between 0 and 10");
    }

    public InvalidRatingException(String message) {
        super(message);
    }
}
