import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        //concerts

        Concert theodora = new Concert("Theodora", "Paris", 35.5, 2500, new ArrayList<>(),true);
        System.out.println(theodora);

        Concert kaliUchis = new Concert("Kali Uchis", "Los Angeles", 55.0, 8000, new ArrayList<>(), true);
        System.out.println(kaliUchis);

        Concert amaia = new Concert("Amaia", "Madrid", 30.75, 3000, new ArrayList<>(), false);
        System.out.println(amaia);

        //users
        User user1 = new User("Terry", 19, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        user1.buyTicket(kaliUchis, Ticket.Type.SEATS);
        user1.buyTicket(amaia, Ticket.Type.VIP);
        user1.toReview(amaia, 10);
        System.out.println(user1);


        User user2 = new User("Diego", 24, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        user2.buyTicket(kaliUchis, Ticket.Type.FLOOR);
        user2.buyTicket(theodora, Ticket.Type.FLOOR);
        user2.toReview(kaliUchis, 8);
        System.out.println(user2);


        User user3 = new User("Kim", 33, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        user3.buyTicket(theodora, Ticket.Type.VIP);
        user3.buyTicket(amaia, Ticket.Type.FLOOR);
        user3.toReview(theodora, 10);
        System.out.println(user3);



        //statistics

        int totalTickets = theodora.getTicketsSold().size() + kaliUchis.getTicketsSold().size() + amaia.getTicketsSold().size();
        System.out.println("Total tickets: " + totalTickets);

        int floorTickets = 0;
        int seatsTickets = 0;
        int vipTickets = 0;

        for (Ticket ticket : theodora.getTicketsSold()) {
            if (ticket.getType() == Ticket.Type.FLOOR) floorTickets++;
            else if (ticket.getType() == Ticket.Type.SEATS) seatsTickets++;
            else if (ticket.getType() == Ticket.Type.VIP) vipTickets++;
        }

        for (Ticket ticket : kaliUchis.getTicketsSold()) {
            if (ticket.getType() == Ticket.Type.FLOOR) floorTickets++;
            else if (ticket.getType() == Ticket.Type.SEATS) seatsTickets++;
            else if (ticket.getType() == Ticket.Type.VIP) vipTickets++;
        }

        for (Ticket ticket : amaia.getTicketsSold()) {
            if (ticket.getType() == Ticket.Type.FLOOR) floorTickets++;
            else if (ticket.getType() == Ticket.Type.SEATS) seatsTickets++;
            else if (ticket.getType() == Ticket.Type.VIP) vipTickets++;
        }

        System.out.println("FLOOR TICKETS: " + floorTickets);
        System.out.println("SEATS TICKETS: " + seatsTickets);
        System.out.println("VIP TICKETS: " + vipTickets);



        double totalRevenue = theodora.calculateRevenue() + kaliUchis.calculateRevenue() + amaia.calculateRevenue();
        System.out.println("Total revenue: " + totalRevenue + "€");


        if (totalTickets > 0) {
            double averagePrice = totalRevenue / totalTickets;
            System.out.println("Average price of tickets: " + averagePrice + "€");
        } else {
            System.out.println("Average price of tickets: 0€");
        }


        Concert mostSold = theodora;
        if (kaliUchis.getTicketsSold().size() > mostSold.getTicketsSold().size()) {
            mostSold = kaliUchis;
        }
        if (amaia.getTicketsSold().size() > mostSold.getTicketsSold().size()) {
            mostSold = amaia;
        }

        System.out.println("Concert with most sold tickets: " + mostSold + " (" + mostSold.getTicketsSold().size() + " tickets)");

        Concert leastSold = theodora;
        if (kaliUchis.getTicketsSold().size() < leastSold.getTicketsSold().size()) {
            leastSold = kaliUchis;
        }
        if (amaia.getTicketsSold().size() < leastSold.getTicketsSold().size()) {
            leastSold = amaia;
        }

        System.out.println("Concert with less tickets sold: " + leastSold + " (" + leastSold.getTicketsSold().size() + " tickets)");

    }


}