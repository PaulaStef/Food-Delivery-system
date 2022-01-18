package presentation;

import business.BaseProduct;
import business.DeliveryService;
import business.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedList;

public class AdministratorController implements ActionListener {
        presentation.AdministratorGraphicalUserInterface page;
        DeliveryService service;
        LinkedList<MenuItem> products = new LinkedList<>();

        public AdministratorController(AdministratorGraphicalUserInterface page,DeliveryService service) {
            this.page = page;
            this.service = service;
        }

        public void actionPerformed(ActionEvent e) {
           if(e.getSource() == page.getReports()) {
             ReportPage reportPage = new ReportPage(service);
            }
           else if(e.getSource() == page.getCreateMenu()){
               page.createMenuPage();
           }
           else if(e.getSource() == page.getAdd()){
               String name = page.getName().getText();
               Double calories = Double.valueOf(page.getCalories().getText());
               Double sodium =  Double.valueOf(page.getSodium().getText());
               Double fat = Double.valueOf(page.getFat().getText());
               Double rating = Double.valueOf(page.getFat().getText());
               Double price = Double.valueOf(page.getRating().getText());
               Double protein = Double.valueOf(page.getProtein().getText());
               BaseProduct product = new BaseProduct(name,price,rating,calories,protein,fat,sodium);
               service.createNewMenuItem(product);
           }
           else if(e.getSource() == page.getDelete()){
               String name = page.getName().getText();
               service.deleteMenuItem(name);
           }
           else if(e.getSource() == page.getModify()){
               String name = page.getName().getText();
               Double calories = Double.valueOf(page.getCalories().getText());
               Double sodium =  Double.valueOf(page.getSodium().getText());
               Double fat = Double.valueOf(page.getFat().getText());
               Double rating = Double.valueOf(page.getFat().getText());
               Double price = Double.valueOf(page.getRating().getText());
               Double protein = Double.valueOf(page.getProtein().getText());
               BaseProduct oldProduct = (BaseProduct) service.lookForProduct(name);
               if(sodium.equals("")) sodium = oldProduct.getSodium();
               if(calories.equals("")) calories = oldProduct.getCalories();
               if (fat.equals("")) fat = oldProduct.getFat();
               if (rating.equals("")) rating = oldProduct.getRating();
               if(price.equals("")) price = oldProduct.getPrice();
               if (protein.equals("")) protein = oldProduct.getProtein();
               BaseProduct product = new BaseProduct(name,price,rating,calories,protein,fat,sodium);
               service.editMenuItem(name,product);
           }
           else if(e.getSource() == page.getImportProducts()){
               try {
                   service.getItemsFromFile();
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               }
           }
           if(e.getSource() == page.getAddItem()){
               String itemName = page.getItem().getText();
               //service.printProducts();
               BaseProduct product = (BaseProduct) service.lookForProduct(itemName);
               if(product != null){
                  if(products.add(product) == true)
                      System.out.println("Added");;
               }
               else{
                   System.out.println("Product not found!");
               }
           }
           if(e.getSource() == page.getFinishMenu()){
               String name = page.getMenuName().getText();
               System.out.println(products.size());
               for (MenuItem item : products) {
                   System.out.println(item.getName());
               }
               if(!products.isEmpty()){
                   service.createDailyMenu(name,products);
               }
               else{
                   System.out.println("Not enough products");
               }
           }

        }

}
