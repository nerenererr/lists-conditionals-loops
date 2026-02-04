import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String name;
    private int age;
    private ArrayList<Ticket> ticketsBought;
    private HashMap<Concert, Integer> reviews; //num entero con Integer porque no se permiten tipis primitivos en HashMap

    public User(String name, int age, ArrayList<Ticket> ticketsBought, HashMap<Concert, Integer> reviews) {
        this.name = name;
        this.age = age;
        this.ticketsBought = ticketsBought;
        this.reviews = reviews;
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

    public HashMap<Concert, Integer> getReviews() {
        return reviews;
    }

    public void setReviews(HashMap<Concert, Integer> reviews) {
        this.reviews = reviews;
    }


}
