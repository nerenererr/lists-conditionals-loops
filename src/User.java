import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class User {
    private String name;
    private int age;
    private ArrayList<Ticket> ticketsBought;
    private HashSet<Concert> concertsAttended;
    private HashMap<Concert, Integer> reviews; //num entero con Integer porque no se permiten tipos primitivos en HashMap

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.ticketsBought = new ArrayList<>();
        this.concertsAttended = new HashSet<>();
        this.reviews = new HashMap<>();
    }


    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Ticket> getTicketsBought() {
        return ticketsBought;
    }

    public void setTicketsBought(ArrayList<Ticket> ticketsBought) {
        this.ticketsBought = ticketsBought;
    }

    public HashSet<Concert> getConcertsAttended() {
        return concertsAttended;
    }

    public void setConcertsAttended(HashSet<Concert> concertsAttended) {
        this.concertsAttended = concertsAttended;
    }

    public HashMap<Concert, Integer> getReviews() {
        return reviews;
    }

    public void setReviews(HashMap<Concert, Integer> reviews) {
        this.reviews = reviews;
    }

    public void buyTicket(Concert concert, Ticket.Type type) {
        if (!concert.isActive()) {
            System.out.println("Error: no longer active");
        } else if (this.concertsAttended.contains(concert)) {
            System.out.println("Error: already attended");
        } else if (!concert.availableTickets()) {
            System.out.println("No more tickets available");
        } else {
            Ticket ticket = new Ticket(concert, type);
            concert.getTicketsSold().add(ticket);
            this.ticketsBought.add(ticket);
            this.concertsAttended.add(concert);
        }
    }

    public void toReview(Concert concert, int review) {
        if (!concertsAttended.contains(concert)) {
            System.out.println("Error");
        } else if (review < 0 || review > 10) {
            System.out.println("Error");
        } else {
            this.reviews.put(concert, review);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(ticketsBought, user.ticketsBought) && Objects.equals(concertsAttended, user.concertsAttended) && Objects.equals(reviews, user.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, ticketsBought, concertsAttended, reviews);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.concertsAttended + " concerts attended)";
    }
}
