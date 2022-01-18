package presentation;

import business.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Set;

public class ClientController implements ActionListener {
    ClientGraphicalUserInterface page;
    DeliveryService service;
    String clientName;
    String items = "";
    StartPage startPage;

    public ClientController(ClientGraphicalUserInterface page, DeliveryService service,String name,StartPage startPage) {
        this.page = page;
        this.service = service;
        this.clientName = name;
        this.startPage = startPage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == page.getAddItem()){
           String item = page.getItem().getText();
           if(item.equals(""))
               System.out.println("Insert an item!");
           else{
               items += item;
               items += ",";
               System.out.println("Added\n");
           }
        }
        else if(e.getSource() == page.getFinishOrder()){
            if(items.equals(" ")){
                System.out.println("Not enough items!");
            }
            else{
                items.substring(0,items.length()-1);
                Order order = service.createNewOrder(clientName,items);
                service.generateBill(order);
                System.out.println("Ordered : " + items);
                items = "";
            }
        }
        else if(e.getSource() == page.getViewProducts()){
               generateViewProducts();
               page.viewProducts();
        }
        else if(e.getSource() == page.getSearchButton()){
            String obj = page.getSearchField().getText();
            if(!obj.equals("")){
                if(page.rButton.isSelected()){
                  generateSearchProducts(service.lookAfterName(obj));
                  page.viewSearchProducts();
                }
                else if(page.rButton_1.isSelected()){
                    generateSearchProducts(service.lookAfterPrice(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
                else if(page.rButton_2.isSelected()){
                    generateSearchProducts(service.lookAfterRating(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
                else if(page.rButton_3.isSelected()){
                    generateSearchProducts(service.lookAfterProtein(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
                else if(page.rButton_4.isSelected()){
                    generateSearchProducts(service.lookAfterFat(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
                else if(page.rButton_5.isSelected()){
                    generateSearchProducts(service.lookAfterSodium(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
                else if(page.rButton_6.isSelected()){
                    generateSearchProducts(service.lookAfterCalories(Double.parseDouble(obj)));
                    page.viewSearchProducts();
                }
            }
        }
    }

    public void generateViewProducts() {
        int elements = service.getProducts().size();
        String[] head = {"Products"};
        String[][] data = new String[elements][head.length];
        int i =0;
            for (MenuItem item : service.getProducts()) {
                if(item instanceof BaseProduct) {
                    data[i][0] = ((BaseProduct) item).getName() + " ";
                }
                else {
                    data[i][0] = ((CompositeProduct) item).getName() + " ";
                }
                ++i;
            }
        page.setTable(new JTable(data, head));
    }

    public void generateSearchProducts(Set<MenuItem> products) {
        int elements = products.size();
        String[] head = {"Products"};
        String[][] data = new String[elements][head.length];
        int i =0;
        for (MenuItem item : products) {
            if(item instanceof BaseProduct) {
                data[i][0] = ((BaseProduct) item).getName() + " ";
            }
            else {
                data[i][0] = ((CompositeProduct) item).getName() + " ";
            }
            ++i;
        }
        page.setTable2(new JTable(data, head));
    }

}
