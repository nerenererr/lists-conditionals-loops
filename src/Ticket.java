import java.util.Objects;

public class Ticket {
    private Concert concert;
    public enum Type {FLOOR, SEATS, VIP};
    private Type type;

    public Ticket(Concert concert, Type type) {
        this.concert = concert;
        this.type = type;
    }

    public Ticket() {
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getTotalPrice() {
        if (type == Type.SEATS) {
            return concert.getBasePrice();
        } else if (type == Type.FLOOR) {
            return concert.getBasePrice() * 1.1;
        } else if (type == Type.VIP) {
            return concert.getBasePrice() * 1.2;
        } else {
            return concert.getBasePrice(); //En caso de que no se introduzca ningún tipo devuelve el precio base
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(concert, ticket.concert) && type == ticket.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(concert, type);
    }

    @Override
    public String toString() {
        return "Ticket price: " + getTotalPrice() + "€";
    }
}
