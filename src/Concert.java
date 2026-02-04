import java.util.ArrayList;

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

}
