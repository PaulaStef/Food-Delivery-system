package business;

import data.Serializator;
import data.TxtWriter;
import presentation.StartPage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * @invariant isWellFormed()
 */

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {
    private static HashSet<MenuItem> products;
    private static HashMap<Order, LinkedList<MenuItem>> orders;
    private static HashMap<String,User> users;
    private Serializator serializator = new Serializator();
    private StartPage page;

    public DeliveryService(String file) {
        products = serializator.deserialize("DeliveryService.ser").getProducts();
        orders = serializator.deserialize("DeliveryService.ser").getOrders();
        users = serializator.deserialize("DeliveryService.ser").getUsers();
        page = new StartPage(this);
    }

    public DeliveryService(HashSet<MenuItem> products, HashMap<Order, LinkedList<MenuItem>> orders, HashMap<String, User> users) {
        this.products = products;
        this.orders = orders;
        this.users = users;
    }

    public DeliveryService() {
        this.products = new HashSet<>();
        this.orders = new HashMap<>();
        this.users = new HashMap<>();
    }

    public void getItemsFromFile() throws IOException {
      File MyFile = new File("products.csv");
      String[] menuValues = null;
        Stream<String> row1 = Files.lines(Paths.get("products.csv"));
        Set<MenuItem> productsGood = (  row1.skip(1).map(x->x.split(",")))
                .map(x -> new BaseProduct(x[0],Double.parseDouble(x[1]),Double.parseDouble(x[2]),Double.parseDouble(x[3]),Double.parseDouble(x[4]),Double.parseDouble(x[5]),Double.parseDouble(x[6])))
                .collect(Collectors.toSet());
        products.addAll(productsGood);
        serializator.serialize(this);
    }

    public static boolean isWellFormed(){
        if(products == null || orders == null || users == null)
            return false;
        for(MenuItem item : products){
            if(item == null)
                return false;
        }
        for(Map.Entry<Order, LinkedList<MenuItem>> order : orders.entrySet()){
            if(order == null)
                return false;
        }
        for(Map.Entry<String, User> user : users.entrySet()){
              if(user == null)
                  return false;
        }
        return true;
    }

    public void createDailyMenu(String name, LinkedList<MenuItem> items){
        assert  name != null & !items.isEmpty();
        assert isWellFormed();
        CompositeProduct menu = new CompositeProduct(name,items);
        if(products != null){
            products.add(menu);
        }
        serializator.serialize(this);
        assert isWellFormed();
    }

    public MenuItem lookForProduct (String itemName) {
        System.out.println(itemName);
        for (MenuItem item : products) {
            if(item.getName().contains(itemName)) {
                System.out.println("found");
                return item;
            }
        }
        return null;
    }

    public Set<MenuItem> lookAfterName(String name){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getName().contains(name))
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterPrice(Double price){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->(x.getPrice() < price) )
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterRating(Double rating){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getRating() == rating)
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterProtein(Double protein){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getRating() < protein)
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterCalories(Double calories){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getRating() < calories)
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterFat(Double fat){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getRating() == fat)
                .collect(Collectors.toSet());
        return thisProducts;
    }

    public Set<MenuItem> lookAfterSodium(Double sodium){
        Set<MenuItem> thisProducts =  products
                .stream()
                .filter(x->x.getRating() == sodium)
                .collect(Collectors.toSet());
        return thisProducts;
    }

    @Override
    public void createNewMenuItem(MenuItem product) {
       assert product != null;
       assert isWellFormed();
       if(products != null){
           products.add(product);
       }
      serializator.serialize(this);
       assert isWellFormed();
    }

    @Override
    public void deleteMenuItem(String name) {
        assert name != null;
        assert isWellFormed();
        MenuItem product = lookForProduct(name);
        if(products != null){
            products.remove(product);
        }
        serializator.serialize(this);
        assert products != null;
        assert isWellFormed();
    }

    @Override
    public void editMenuItem(String name, MenuItem newItem) {
        assert name != null && newItem != null;
        assert isWellFormed();
        MenuItem product = lookForProduct(name);
        if(products != null){
            products.remove(product);
            products.add(newItem);
        }
        serializator.serialize(this);
        assert products != null;
        assert isWellFormed();
    }

    @Override
    public Order createNewOrder(String clientName, String items) {
        assert clientName != null && items != null;
        assert isWellFormed();
        //System.out.println(items);
        System.out.println(orders.size());
        int id = Order.orderNumber++;
        Order order = new Order(id,clientName);
        String[] list = items.split(",");
        LinkedList<MenuItem> OrderItems = new LinkedList<MenuItem>();
        for (String item : list) {
            MenuItem product = lookForProduct(item);
            if(product != null) {
                OrderItems.add(product);
            }
            else{
                System.out.println("Not enough products");
                Order.orderNumber--;
                return null;
            }
        }
        orders.put(order,OrderItems);
        setChanged();
        notifyObservers(orders);
        serializator.serialize(this);
        assert products != null;
        assert isWellFormed();
        return order;
    }

    @Override
    public float computePrice(LinkedList<MenuItem> items) {
        assert items != null;
        assert isWellFormed();
        float total = 0;
        for (MenuItem item : items) {
            total += item.computePrice();
        }
        assert isWellFormed();
        return total;
    }

    @Override
    public void generateBill(Order order) {
         assert order != null;
         assert isWellFormed();
         String bill = "";
         float totalPrice = computePrice(orders.get(order));
         LinkedList<MenuItem> orderItems = orders.get(order);
         bill = "Order number : " + order.getOrderID() + "\nClient: " + order.getClientName();
        for (MenuItem item: orderItems) {
            bill += "\n Item : " + item.getName() + "   Price : " + item.computePrice();
        }
        bill +="\n Total Price : " + totalPrice;
        TxtWriter.writeBill(order.getOrderID(),bill);
        serializator.serialize(this);
        assert orders != null;
        assert isWellFormed();
    }

    public UserRole logIn(String userName, String password){
        assert userName != null && password != null;
        assert isWellFormed();
        for(Map.Entry<String, User> user : users.entrySet()){
            if(user.getValue().getUserName().equals(userName)){
                if(user.getValue().getPassword().equals(password)){
                    return user.getValue().getRole();
                }
            }
        }
        assert products != null;
        assert isWellFormed();
        return null;
    }

    public User register(String userName,String password,UserRole role) {
        assert isWellFormed();
        assert userName != null && password != null && role != null;
        User user = new User(userName, password, role);
        for (Map.Entry<String, User> userI : users.entrySet()) {
            if (userI.getValue().getUserName().equals(userName)) {
                return userI.getValue();
            }
        }
        User userX = users.put(userName, user);
        serializator.serialize(this);
        assert users != null;
        assert isWellFormed();
        return userX;
    }

    //1
    public List<Order> getBetween(int startHour, int finishHour){
        List<Order> useOrder = this.orders.keySet()
                .stream()
                .filter(x -> (x.getOrderDate().getHours() >= startHour && x.getOrderDate().getHours() <= finishHour))
                .collect(Collectors.toList());
        TxtWriter.generateTimeIntervalReport(startHour,finishHour,useOrder);
         return useOrder;
    }

    //2
    public Set<String> generatePopularityReport(int nb) {
        LinkedList<MenuItem> productsOrdered = new LinkedList<>();
        for (Map.Entry<Order, LinkedList<MenuItem>> order : orders.entrySet()) {
            productsOrdered.addAll(order.getValue());
        }
        Set<String> item = productsOrdered
                .stream()
                .filter(values -> (productsOrdered.stream().filter(val -> (val.getName().contains(values.getName()))).count() > nb))
                .map(MenuItem::getName)
                .collect(Collectors.toSet());
        TxtWriter.writePopularityReport(nb,item);
        return item;
    }
    //3

    public Set<Order> generateLoyalClientsReport(int nb, Double value){
        LinkedList<Order> allOrders = new LinkedList<>();
        for (Order order : orders.keySet()) {
            allOrders.add(order);
        }
        Set<Order> item = allOrders
                .stream()
                .filter(values -> (allOrders.stream().filter(val -> (val.getClientName().contains(values.getClientName()))).count() > nb))
                .collect(Collectors.toSet());
        Set<String> goodOrders = item
                .stream()
                .filter(val-> computePrice(orders.get(val)) > value)
                .map(Order::getClientName)
                .collect(Collectors.toSet());
        for (String name : goodOrders){
            System.out.println(name );
        }
        TxtWriter.writeLoyalClientsReport(nb,value,goodOrders);
        return item;
    }

    //4
    public void generateTodayProductsReport(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyy").parse(date);
        List<LinkedList<MenuItem>> goodProducts = orders.entrySet()
                .stream()
                .filter(val -> (val.getKey().getOrderDate().getDay() == date1.getDay() && val.getKey().getOrderDate().getMonth()==date1.getMonth() && val.getKey().getOrderDate().getYear() == date1.getYear() ))
                .map(val -> val.getValue())
                .collect(Collectors.toList());
        LinkedList<MenuItem> allProducts = new LinkedList<MenuItem>();
        for(LinkedList<MenuItem> item : goodProducts){
            allProducts.addAll(item);
        }
        Map<MenuItem,Long> prods = allProducts
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        TxtWriter.writeTodayProductsReport(date,prods);
        for(Map.Entry<MenuItem,Long> pro : prods.entrySet()){
            System.out.println(pro.getKey().getName() + " " + pro.getValue());
        }
    }


    public HashMap<Order, LinkedList<MenuItem>> getOrders() {
        return orders;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setOrders(HashMap<Order, LinkedList<MenuItem>> orders) {
        this.orders = orders;
    }


    public static HashSet<MenuItem> getProducts() {
        return products;
    }

    public StartPage getPage() {
        return page;
    }
}
