package business;

import java.util.ArrayList;
import java.util.LinkedList;

public class CompositeProduct extends MenuItem {
    private String compositeName;
    private LinkedList<MenuItem> items;

    public CompositeProduct(String compositeName, LinkedList<MenuItem> items) {
        this.compositeName = compositeName;
        this.items = items;
    }

    @Override
    public double computePrice() {
        double totalPrice = 0;
        for(MenuItem item : items){
            totalPrice += item.computePrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        String s = "";
        for(MenuItem item : items){
            s+= ((BaseProduct)item).toString() + " ";
        }
        return s;
    }

    public String getName() {
        return compositeName;
    }

    public void setCompositeName(String compositeName) {
        this.compositeName = compositeName;
    }

    public LinkedList<MenuItem> getItems() {
        return items;
    }

    public void setItems(LinkedList<MenuItem> items) {
        this.items = items;
    }
}
