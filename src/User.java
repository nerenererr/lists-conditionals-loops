import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import exceptions.*;

public class User {
    private String name;
    private int age;
    private ArrayList<Ticket> ticketsBought;
    private HashSet<Concert> concertsAttended;
    private HashMap<Concert, Integer> reviews; //num entero con Integer porque no se permiten tipos primitivos en HashMap

    public User(String name, int age, ArrayList<Ticket> ticketsBought, HashSet<Concert> concertsAttended, HashMap<Concert, Integer> reviews) {
        this.name = name;
        this.age = age;
        this.ticketsBought = ticketsBought;
        this.concertsAttended = concertsAttended;
        this.reviews = reviews;
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

    public void buyTicket(Concert concert, Ticket.Type type) throws InactiveConcertException, AlreadyAttendedException, SoldOutException {
        // Check if concert is still active
        if (!concert.isActive()) {
            throw new InactiveConcertException();
        } else if (this.concertsAttended.contains(concert)) {
            throw new AlreadyAttendedException();
        } else if (!concert.availableTickets()) {
            throw new SoldOutException();
        } else {
            // Create new ticket and add to both concert and user collections
            Ticket ticket = new Ticket(concert, type);
            concert.getTicketsSold().add(ticket);
            this.ticketsBought.add(ticket);
            this.concertsAttended.add(concert);
        }
    }

    public void toReview(Concert concert, int review) throws NotAttendedException, InvalidRatingException {
        // Check if user attended the concert
        if (!concertsAttended.contains(concert)) {
            throw new NotAttendedException();
        } else if (review < 0 || review > 10) {
            throw new InvalidRatingException();
        } else {
            // Store or update reviews for this concert
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
        return this.name + " :" + this.concertsAttended;
    }
}
