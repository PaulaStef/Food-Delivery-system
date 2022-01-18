package presentation;

import business.DeliveryService;

import javax.swing.*;
import java.awt.*;

public class ClientGraphicalUserInterface {
    private JPanel panelC;
    private JButton viewProducts;
    private JTextField searchField;
    private JButton searchButton;
    private JTextField item;
    private JButton addItem;
    private JButton finishOrder;
    private ClientController control;
    protected JRadioButton rButton;
    protected JRadioButton rButton_1;
    protected JRadioButton rButton_2;
    protected JRadioButton rButton_3;
    protected JRadioButton rButton_4;
    protected JRadioButton rButton_5;
    protected JRadioButton rButton_6;
    protected ButtonGroup checkboxes;
    private JTable table;
    private JTable table2;

    public ClientGraphicalUserInterface(JPanel panelC, DeliveryService service,String name,StartPage page) {
        this.panelC = panelC;
        control = new ClientController(this,service,name,page);
    }

    private void radioButtons() {
        // radio buttons
        rButton = new JRadioButton("Name");
        rButton.setBounds(40, 300, 109, 23);
        rButton.setBackground(Color.PINK);
        panelC.add(rButton);

        rButton_1 = new JRadioButton("Price");
        rButton_1.setBounds(40, 325, 109, 23);
        rButton_1.setBackground(Color.PINK);
        panelC.add(rButton_1);

        rButton_2 = new JRadioButton("Rating");
        rButton_2.setBounds(40, 350, 109, 23);
        rButton_2.setBackground(Color.PINK);
        panelC.add(rButton_2);

        rButton_3 = new JRadioButton("Protein");
        rButton_3.setBounds(40, 375, 109, 23);
        rButton_3.setBackground(Color.PINK);
        panelC.add(rButton_3);

        rButton_4 = new JRadioButton("Fat");
        rButton_4.setBounds(40, 400, 109, 23);
        rButton_4.setBackground(Color.PINK);
        panelC.add(rButton_4);

        rButton_5 = new JRadioButton("Sodium");
        rButton_5.setBounds(40, 425, 109, 23);
        rButton_5.setBackground(Color.PINK);
        panelC.add(rButton_5);

        rButton_6 = new JRadioButton("Calories");
        rButton_6.setBounds(40, 450, 109, 23);
        rButton_6.setBackground(Color.PINK);
        panelC.add(rButton_6);

        checkboxes = new ButtonGroup();
        checkboxes.add(rButton);
        checkboxes.add(rButton_1);
        checkboxes.add(rButton_2);
        checkboxes.add(rButton_3);
    }

    public void initializeClient(){
        radioButtons();
        viewProducts = new JButton("View Products");
        viewProducts.setBounds(40,20,300,50);
        viewProducts.setFont(new Font("Times New Roman",Font.PLAIN,20));
        viewProducts.setBackground(Color.PINK);
        viewProducts.addActionListener(control);
        panelC.add(viewProducts);

        addItem = new JButton("Add item");
        addItem.setBounds(370,120,200,50);
        addItem.setBackground(Color.PINK);
        addItem.setFont(new Font("Times New Roman",Font.PLAIN,20));
        addItem.addActionListener(control);
        panelC.add(addItem);

        item = new JTextField();
        item.setBounds(30, 120,200,50);
        item.setBackground(Color.PINK);
        JLabel label_3 = new JLabel("Product: ");
        label_3.setBounds(30,90,150,30);
        label_3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_3.setForeground(Color.PINK);
        panelC.add(label_3);
        panelC.add(item);

        searchButton = new JButton("Search");
        searchButton.setBounds(370,200,200,50);
        searchButton.setBackground(Color.PINK);
        searchButton.setFont(new Font("Times New Roman",Font.PLAIN,20));
        searchButton.addActionListener(control);
        panelC.add(searchButton);

        searchField = new JTextField();
        searchField.setBounds(30, 200,200,50);
        searchField.setBackground(Color.PINK);
        JLabel label_2 = new JLabel("Name: ");
        label_2.setBounds(30,170,150,30);
        label_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_2.setForeground(Color.PINK);
        panelC.add(label_2);
        panelC.add(searchField);

        finishOrder = new JButton("Order");
        finishOrder.setBounds(370,300,200,50);
        finishOrder.setBackground(Color.white);
        finishOrder.setFont(new Font("Times New Roman",Font.PLAIN,20));
        finishOrder.addActionListener(control);
        panelC.add(finishOrder);

    }

    public void viewProducts() {
        JFrame tableFrame = new JFrame("Products");
        JScrollPane tablePane = new JScrollPane(table);
        tableFrame.add(tablePane);
        //tableFrame.pack();
        tableFrame.setVisible(true);
    }

    public void viewSearchProducts() {
        JFrame tableFrame = new JFrame("Products");
        JScrollPane tablePane = new JScrollPane(table2);
        tableFrame.add(tablePane);
        //tableFrame.pack();
        tableFrame.setVisible(true);
    }

    public JButton getViewProducts() {
        return viewProducts;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextField getItem() {
        return item;
    }

    public JButton getAddItem() {
        return addItem;
    }

    public JButton getFinishOrder() {
        return finishOrder;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }
}
