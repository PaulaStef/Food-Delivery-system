package business;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable {
    private int orderID;
    private String clientName;
    private Date orderDate;
    public static int orderNumber = 0;

    public Order(int orderID, String clientName ) {
        this.orderID = orderID;
        this.clientName = clientName;
        this.orderDate = new Date();
    }

    @Override
    public int hashCode() {
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(this.orderDate);
       int code = this.orderID;
       if(calendar.get(Calendar.YEAR) % 2 == 0){
           code *= calendar.get(Calendar.MONTH);
           code = code / calendar.get(Calendar.DAY_OF_MONTH);
       }
       else {
           code += ( calendar.get(Calendar.DAY_OF_MONTH) + calendar.get(Calendar.MONTH));
           code = code / calendar.get(Calendar.DAY_OF_MONTH);
       }
       return code;
    }


    public int getOrderID() {
        return orderID;
    }

    public String getClientName() {
        return clientName;
    }

    public Date getOrderDate() {
        return orderDate;
    }
}
