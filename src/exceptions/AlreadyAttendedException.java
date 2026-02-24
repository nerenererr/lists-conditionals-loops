package exceptions;

public class AlreadyAttendedException extends Throwable {
    public AlreadyAttendedException() {
        super("You have already attended this concert");
    }

    public AlreadyAttendedException(String message) {
        super(message);
    }
}
