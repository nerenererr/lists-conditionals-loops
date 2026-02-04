import java.util.ArrayList;
import java.util.Objects;

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
        double revenue = 0; //Variable para acumular el total
        for (Ticket ticket : ticketsSold) {  //Recorre todas las entradas vendidas
            revenue += ticket.getTotalPrice(); //Por cada entrada suma su precio al total
        }
        return revenue; //Devuelve el total acumulado
    }

    public double calculateAveragePrice() {
        if (ticketsSold.isEmpty()) { //Si no hay ninguna entrada vendida devuelve 0
            return 0;
        }
        return calculateRevenue() / ticketsSold.size(); //Se divide el total recaudado entre el tamaño del array de entradas vendidas
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Concert concert = (Concert) o;
        return Double.compare(basePrice, concert.basePrice) == 0 && maxAforum == concert.maxAforum && active == concert.active && Objects.equals(artist, concert.artist) && Objects.equals(city, concert.city) && Objects.equals(ticketsSold, concert.ticketsSold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, city, basePrice, maxAforum, ticketsSold, active);
    }
}
