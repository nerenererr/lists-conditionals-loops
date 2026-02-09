import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //concerts

        Concert theodora = new Concert("Theodora", "Paris", 35.5, 2500, true);
        System.out.println(theodora);

        Concert kaliUchis = new Concert("Kali Uchis", "Los Angeles", 55.0, 8000, true);
        System.out.println(kaliUchis);

        Concert amaia = new Concert("Amaia", "Madrid", 30.75, 3000, false);
        System.out.println(amaia);

        //users
        User user1 = new User("Terry", 19);
        user1.buyTicket(kaliUchis, Ticket.Type.SEATS);
        user1.buyTicket(amaia, Ticket.Type.VIP);
        System.out.println(user1);
        User user2 = new User("Diego", 24);
        System.out.println(user2);
        User user3 = new User("Kim", 33);
        System.out.println(user3);




    }


}