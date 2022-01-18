package presentation;

import business.BaseProduct;
import business.MenuItem;
import business.Order;

//import java.awt.*;
import java.util.*;

public class EmployeeController implements Observer {
    EmployeeGraphicalUserInterface page;
    public String message_print;
    public int notifiedOrders;

    public EmployeeController(EmployeeGraphicalUserInterface page) {
        this.page = page;
    }

    @Override
    public void update(Observable o, Object arg) {
         /*
        LinkedList<MenuItem> items = orders.get(orders.size());
         notifiedOrders = orders.size();
         message = "";
        if( items != null) {
            for (MenuItem item : items) {
                message += item.getName() + " ";
            }
            page.getField().setText(message);
            page.getOrders().setText(Integer.toString(++notifiedOrders));
        }
        else {
            page.getField().setText("No order.");
            page.getOrders().setText("0");
            //message = "No order";
            //notifiedOrders = 0;
        }
         */
        HashMap<Order, LinkedList<business.MenuItem>> orders = (HashMap<Order, LinkedList<business.MenuItem>>) arg;
        System.out.println(orders.size() + "\n");
        int i = orders.size();
        Iterator<Map.Entry<Order, LinkedList<MenuItem>>> itr = orders.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Order, LinkedList<MenuItem>> order = itr.next();
            if(i == 1) {
                message_print = "";
                LinkedList<business.MenuItem> items = orders.get(order.getKey());
                for (business.MenuItem item : items) {
                    message_print += item.getName() + " \n";
                }
                page.getField().setText(message_print);
                page.getOrders().setText(Integer.toString(++notifiedOrders));
                break;
            }
            --i;
        }
    }

}
