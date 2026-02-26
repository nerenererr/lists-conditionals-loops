import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import exceptions.*;

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
        User user2 = new User("Diego", 24, new ArrayList<>(), new HashSet<>(), new HashMap<>());
        User user3 = new User("Kim", 33, new ArrayList<>(), new HashSet<>(), new HashMap<>());

        try {
            user1.buyTicket(kaliUchis, Ticket.Type.SEATS);
            System.out.println("ฅ^•ﻌ•^ฅ Terry bought ticket for Kali Uchis");
        } catch (InactiveConcertException | AlreadyAttendedException | SoldOutException e) {
        System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
    }

        try {
            user1.buyTicket(amaia, Ticket.Type.VIP);
            System.out.println("ฅ^•ﻌ•^ฅ Terry bought ticket for Amaia");
        } catch (InactiveConcertException | AlreadyAttendedException | SoldOutException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        try {
            user1.toReview(kaliUchis, 10);
            System.out.println("ฅ^•ﻌ•^ฅ Terry reviewed Kali Uchis");
        } catch (NotAttendedException | InvalidRatingException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        try {
            user1.toReview(amaia, 10);
            System.out.println("ฅ^•ﻌ•^ฅ Terry reviewed Amaia");
        } catch (NotAttendedException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());  // This will execute
        } catch (InvalidRatingException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }


        try {
            user2.buyTicket(kaliUchis, Ticket.Type.FLOOR);
            user2.buyTicket(theodora, Ticket.Type.FLOOR);
            System.out.println("ฅ^•ﻌ•^ฅ Diego bought tickets");
        } catch (InactiveConcertException | AlreadyAttendedException | SoldOutException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        try {
            user2.toReview(kaliUchis, 8);
            System.out.println("ฅ^•ﻌ•^ฅ Diego reviewed Kali Uchis");
        } catch (NotAttendedException | InvalidRatingException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }


        try {
            user3.buyTicket(theodora, Ticket.Type.VIP);
            System.out.println("ฅ^•ﻌ•^ฅ Kim bought ticket for Theodora");
        } catch (InactiveConcertException | AlreadyAttendedException | SoldOutException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        try {
            user3.buyTicket(amaia, Ticket.Type.FLOOR);
            System.out.println("ฅ^•ﻌ•^ฅ Kim bought ticket for Amaia");
        } catch (InactiveConcertException | AlreadyAttendedException | SoldOutException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        try {
            user3.toReview(theodora, 10);
            System.out.println("ฅ^•ﻌ•^ฅ Kim reviewed Theodora");
        } catch (NotAttendedException | InvalidRatingException e) {
            System.out.println("≽(◉˕ ◉ ≼マ Error: " + e.getMessage());
        }

        System.out.println("=== Users ===");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);



        //statistics

        System.out.println("=== Statistics ===");

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