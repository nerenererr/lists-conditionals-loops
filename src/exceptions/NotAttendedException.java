package exceptions;

public class NotAttendedException extends Throwable {
    public NotAttendedException() {
        super("You have not attended this concert");
    }

    public NotAttendedException(String message) {
        super(message);
    }
}
