package presentation;

import business.DeliveryService;

import javax.swing.*;
import java.awt.*;

public class AdministratorGraphicalUserInterface {
    private JPanel panelC;
    private JButton importProducts;
    private JButton add;
    private JButton delete;
    private JButton modify;
    private JButton createMenu;
    private JButton reports;
    private JTextField name;
    private JTextField rating;
    private JTextField calories;
    private JTextField protein;
    private JTextField fat;
    private JTextField sodium;
    private JTextField price;
    private AdministratorController control;

    //
    JFrame frameM;
    JPanel panelM;
    JTextField item;
    JButton addItem;
    JButton finishMenu;
    JTextField menuName;

    public AdministratorGraphicalUserInterface(JPanel panelC, DeliveryService service) {
        this.panelC = panelC;
        control = new AdministratorController(this,service);
    }

    public void initializeAdmin(){

        importProducts = new JButton("Import");
        importProducts.setBounds(40,20,150,50);
        importProducts.setFont(new Font("Times New Roman",Font.PLAIN,20));
        importProducts.setBackground(Color.PINK);
        importProducts.addActionListener(control);
        panelC.add(importProducts);

        reports = new JButton("Reports");
        reports.setBounds(210,20,150,50);
        reports.setFont(new Font("Times New Roman",Font.PLAIN,20));
        reports.setBackground(Color.PINK);
        reports.addActionListener(control);
        panelC.add(reports);

        createMenu = new JButton("Daily Menu");
        createMenu.setBounds(390,20,180,50);
        createMenu.setFont(new Font("Times New Roman",Font.PLAIN,20));
        createMenu.setBackground(Color.PINK);
        createMenu.addActionListener(control);
        panelC.add(createMenu);

        name = new JTextField();
        name.setBounds(100, 100,200,40);
        name.setBackground(Color.PINK);
        JLabel label_2 = new JLabel("Name:  ");
        label_2.setBounds(20,100,100,30);
        label_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_2.setForeground(Color.PINK);
        panelC.add(label_2);
        panelC.add(name);

        rating = new JTextField();
        rating.setBounds(100, 150,200,40);
        rating.setBackground(Color.PINK);
        JLabel label_1 = new JLabel("Rating: ");
        label_1.setBounds(20,150,100,30);
        label_1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_1.setForeground(Color.PINK);
        panelC.add(label_1);
        panelC.add(rating);

        calories = new JTextField();
        calories.setBounds( 100, 200,200,40);
        calories.setBackground(Color.PINK);
        JLabel label_3 = new JLabel("Calories:  ");
        label_3.setBounds(20,200,100,30);
        label_3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_3.setForeground(Color.PINK);
        panelC.add(label_3);
        panelC.add(calories);

        protein = new JTextField();
        protein.setBounds( 100, 250,200,40);
        protein.setBackground(Color.PINK);
        JLabel label_4 = new JLabel("Protein:  ");
        label_4.setBounds(20,250,100,30);
        label_4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_4.setForeground(Color.PINK);
        panelC.add(label_4);
        panelC.add(protein);

        fat = new JTextField();
        fat.setBounds( 100, 300,200,40);
        fat.setBackground(Color.PINK);
        JLabel label_5 = new JLabel("Fat:  ");
        label_5.setBounds(20,300,100,30);
        label_5.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_5.setForeground(Color.PINK);
        panelC.add(label_5);
        panelC.add(fat);

        sodium = new JTextField();
        sodium.setBounds( 100, 350,200,40);
        sodium.setBackground(Color.PINK);
        JLabel label_6 = new JLabel("Sodium:  ");
        label_6.setBounds(20,350,100,30);
        label_6.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_6.setForeground(Color.PINK);
        panelC.add(label_6);
        panelC.add(sodium);

        price = new JTextField();
        price.setBounds( 100, 400,200,40);
        price.setBackground(Color.PINK);
        JLabel label_7 = new JLabel("price:  ");
        label_7.setBounds(20,400,100,30);
        label_7.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_7.setForeground(Color.PINK);
        panelC.add(label_7);
        panelC.add(price);


        add = new JButton("Add");
        add.setBounds(370,150,150,50);
        add.setBackground(Color.PINK);
        add.setFont(new Font("Times New Roman",Font.PLAIN,20));
        add.addActionListener(control);
        panelC.add(add);

        modify = new JButton("Modify");
        modify.setBounds(370,240,150,50);
        modify.setBackground(Color.PINK);
        modify.setFont(new Font("Times New Roman",Font.PLAIN,20));
        modify.addActionListener(control);
        panelC.add(modify);

        delete = new JButton("Delete");
        delete.setBounds(370,330,150,50);
        delete.setBackground(Color.PINK);
        delete.setFont(new Font("Times New Roman",Font.PLAIN,20));
        delete.addActionListener(control);
        panelC.add(delete);

    }

    public void createMenuPage(){
        frameM = new JFrame();
        frameM.setSize(700, 600);
        frameM.setBounds(450, 550, 650, 550);
        frameM.getContentPane().setLayout(null);
        panelM = new JPanel();
        panelM.setBounds(0, 0, 700, 600);
        panelM.setBackground(Color.darkGray);
        frameM.getContentPane().add(panelM);
        panelM.setLayout(null);
        frameM.add(panelM);
        frameM.setVisible(true);

        item = new JTextField();
        item.setBounds(30, 100,200,40);
        item.setBackground(Color.PINK);
        JLabel label_2 = new JLabel("Product:  ");
        label_2.setBounds(30,60,100,60);
        label_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_2.setForeground(Color.PINK);
        panelM.add(label_2);
        panelM.add(item);

        addItem= new JButton("Add Product");
        addItem.setBounds(370,100,200,50);
        addItem.setBackground(Color.PINK);
        addItem.setFont(new Font("Times New Roman",Font.PLAIN,20));
        addItem.addActionListener(control);
        panelM.add(addItem);

        finishMenu= new JButton("Create Menu");
        finishMenu.setBounds(200,260,200,50);
        finishMenu.setBackground(Color.PINK);
        finishMenu.setFont(new Font("Times New Roman",Font.PLAIN,20));
        finishMenu.addActionListener(control);
        panelM.add(finishMenu);

        menuName = new JTextField();
        menuName.setBounds(30, 360,200,40);
        menuName.setBackground(Color.PINK);
        JLabel label_3 = new JLabel("Daily Menu Name:  ");
        label_3.setBounds(30,320,100,60);
        label_3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_3.setForeground(Color.PINK);
        panelM.add(label_3);
        panelM.add(menuName);

    }

    public JTextField getMenuName() {
        return menuName;
    }

    public JButton getImportProducts() {
        return importProducts;
    }

    public JButton getAdd() {
        return add;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getModify() {
        return modify;
    }

    public JButton getCreateMenu() {
        return createMenu;
    }

    public JButton getReports() {
        return reports;
    }

    public JTextField getName() {
        return name;
    }

    public JTextField getRating() {
        return rating;
    }

    public JTextField getCalories() {
        return calories;
    }

    public JTextField getProtein() {
        return protein;
    }

    public JTextField getFat() {
        return fat;
    }

    public JTextField getSodium() {
        return sodium;
    }

    public JTextField getPrice() {
        return price;
    }

    public JTextField getItem() {
        return item;
    }

    public JButton getAddItem() {
        return addItem;
    }

    public JButton getFinishMenu() {
        return finishMenu;
    }
}
