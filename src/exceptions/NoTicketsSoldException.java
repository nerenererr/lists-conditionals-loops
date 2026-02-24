package exceptions;

public class NoTicketsSoldException extends Throwable {
    public NoTicketsSoldException() {
        super("No tickets sold to calculate price");
    }

    public NoTicketsSoldException(String message) {
        super(message);
    }
}
