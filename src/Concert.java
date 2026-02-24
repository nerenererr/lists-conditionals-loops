import java.util.ArrayList;
import java.util.Objects;
import exceptions.NoTicketsSoldException;

public class Concert {
    private String artist;
    private String city;
    private double basePrice;
    private int maxAforum;
    private ArrayList<Ticket> ticketsSold;
    private boolean active;

    public Concert(String artist, String city, double basePrice, int maxAforum, ArrayList<Ticket> ticketsSold, boolean active) {
        this.artist = artist;
        this.city = city;
        this.basePrice = basePrice;
        this.maxAforum = maxAforum;
        this.ticketsSold = ticketsSold;
        this.active = active;
    }

    public Concert() {
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getMaxAforum() {
        return maxAforum;
    }

    public void setMaxAforum(int maxAforum) {
        this.maxAforum = maxAforum;
    }

    public ArrayList<Ticket> getTicketsSold() {
        return ticketsSold;
    }

    public void setTicketsSold(ArrayList<Ticket> ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double calculateRevenue() {
        double revenue = 0;
        for (Ticket ticket : ticketsSold) {
            revenue += ticket.getTotalPrice(); // Add each ticket's price to total
        }
        return revenue;
    }

    public double calculateAveragePrice() throws NoTicketsSoldException {
        if (ticketsSold.isEmpty()) {
            throw new NoTicketsSoldException();
        }
        return calculateRevenue() / ticketsSold.size(); // Divide total revenue by number of tickets
    }

    public boolean availableTickets() {
        return ticketsSold.size() < maxAforum;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Double.compare(basePrice, concert.basePrice) == 0 && maxAforum == concert.maxAforum && active == concert.active && Objects.equals(artist, concert.artist) && Objects.equals(city, concert.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, city, basePrice, maxAforum, active);
    }

    @Override
    public String toString() {
        return this.artist + "'s concert in " + this.city;
    }
}
