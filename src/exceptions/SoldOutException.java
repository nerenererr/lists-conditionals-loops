package exceptions;

public class SoldOutException extends Throwable {
    public SoldOutException() {
        super("No tickets available");
    }

    public SoldOutException(String message) {
        super(message);
    }
}
