package start;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import business.User;
import data.Serializator;
import presentation.StartPage;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //StartPage page1 = new StartPage();
        DeliveryService service = new DeliveryService("DeliveryService.ser");
        service.addObserver(service.getPage().getEmployeePage().controler);
        Date date = new Date();
        System.out.println(date.getHours());
        System.out.println((date.getTime() % 86400000 ) / 3600000);
        /*
        try {
            service.generateTodayProductsReport("31/05/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
         */
        /*
        Serializator ser = new Serializator();
        User user1 = new User("Andrei","Mihai");
        User user2 = new User("Ionut","2345");
        HashMap<String,User> users = new HashMap<String,User>();
        users.put(user1.getUserName(), user1);
        users.put(user2.getUserName(), user2);
        DeliveryService service = new DeliveryService();
        service.setUsers(users);
        ser.serialize(service);
        service = ser.deserialize("DeliveryService.ser");
        for (String user: service.getUsers().keySet()) {
            System.out.println(user);
        }

         */
        //System.out.println(user1);
        //System.out.println(user2);
    }
}
