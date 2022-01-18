package data;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import business.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Serializator {

    public void serialize(DeliveryService server) {
        try {
            FileOutputStream file_in = new FileOutputStream("DeliveryService.ser");
            ObjectOutputStream outFile = new ObjectOutputStream(file_in);
            //serializam produsele
            if(server.getProducts() != null) {
                outFile.writeObject(server.getProducts());
            }
            //serializam comenziile
            if(server.getOrders() != null) {
                outFile.writeObject(server.getOrders());
            }
            //serializam clientii
            if(server.getUsers() != null) {
                outFile.writeObject(server.getUsers());
            }
            outFile.close();
            file_in.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public DeliveryService deserialize(String fileName) {
        try {
            FileInputStream file_out = new FileInputStream(fileName);
            ObjectInputStream inFile = new ObjectInputStream(file_out);
            //Deserializam produsele
            HashSet<MenuItem> menuItem = (HashSet<MenuItem>) inFile.readObject();
            //Deserializam compenziile
            HashMap<Order, LinkedList<MenuItem>> orders = (HashMap<Order, LinkedList<MenuItem>>) inFile.readObject();
            //Deserializam clientii
            HashMap<String,User> users = (HashMap<String, User>) inFile.readObject();
            inFile.close();
            file_out.close();
            return new DeliveryService(menuItem,orders,users);

        } catch(Exception e) {
            return new DeliveryService();
        }
    }
}
