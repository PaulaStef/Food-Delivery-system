package data;

import business.MenuItem;
import business.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TxtWriter {
    public static int noOfReports = 1;


    public TxtWriter() {
    }

    public static void writePopularityReport(int nb, Set<String> items) {
        String report = "Products that have been ordered more than " + nb + " times:\n";
        if (!items.isEmpty()) {
            for (String item : items) {
                report += "Client " + item + "\n";
            }
        }
        generateReport("Popularity", report);
    }
        public static void generateTimeIntervalReport(int startHour,int finishHour,List<Order> goodOrders){
            String report = "Orders performed between " + startHour + " and " + finishHour + ":\n";
            if(!goodOrders.isEmpty()){
                for (Order order : goodOrders) {
                    report += "Order " + order.getOrderID() + "\n";
                }
            }
            //TxtFileWriter writer = new TxtFileWriter();
            generateReport("TimeInterval",report);
        }

    public static void writeLoyalClientsReport(int nb, Double price, Set<String> loyalClients){
        String report = "Clients that ordered more than " + nb + " times the value of the order is" +
                " higher than " + price + ":\n";
        if(!loyalClients.isEmpty()){
            for (String user : loyalClients) {
                report += "Client: " + user + "\n";
            }
        }
        generateReport("LoyalClients",report);
    }

    public static void writeBill(int idBill,String message){
        try {
            FileWriter writer = new FileWriter("Bill_no" + idBill + ".txt");
            writer.write(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTodayProductsReport(String date , Map<MenuItem,Long> items){
        String report = "Products that have been ordered in " + date + ":\n";
        if(!items.isEmpty()){
            for(Map.Entry<MenuItem,Long> item : items.entrySet()) {
                report += "Product " + item.getKey().getName() + " x " + item.getValue() + " times\n";
            }
        }
        generateReport("TodayProducts",report);
    }

    public static void generateReport(String title, String message){
        try {
            FileWriter writer = new FileWriter(title + "_Report" + noOfReports + ".txt");
            noOfReports++;
            writer.write(message);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
