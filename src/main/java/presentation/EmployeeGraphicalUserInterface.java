package presentation;

import business.Order;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class EmployeeGraphicalUserInterface {
    private JTextField field;
    private JTextField orders;
    private JFrame framePP;
    private JPanel panelPP;
    public EmployeeController controler = new EmployeeController(this);

    public EmployeeGraphicalUserInterface() {
       // initialize();
    }

    public void initialize(){

        framePP = new JFrame();
        framePP.setSize(700, 600);
        framePP.setBounds(450, 550, 650, 550);
        framePP.getContentPane().setLayout(null);
        panelPP = new JPanel();
        panelPP.setBounds(0, 0, 700, 600);
        panelPP.setBackground(Color.darkGray);
        framePP.getContentPane().add(panelPP);
        panelPP.setLayout(null);
        framePP.add(panelPP);
        framePP.setVisible(true);

        field = new JTextField();
        field.setBounds( 70, 150,300,200);
        field.setBackground(Color.PINK);
        JLabel label_7 = new JLabel("Last Order:  ");
        label_7.setBounds(30,100,100,30);
        label_7.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_7.setForeground(Color.PINK);
        panelPP.add(label_7);
        panelPP.add(field);

        JLabel label_1 = new JLabel("No of Orders : ");
        label_1.setBounds(30,30,150,30);
        label_1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_1.setForeground(Color.PINK);
        panelPP.add(label_1);

        orders = new JTextField();
        orders.setBounds( 200, 30,70,50);
        orders.setBackground(Color.PINK);
        panelPP.add(orders);

        field.setText(controler.message_print);
        orders.setText(String.valueOf(controler.notifiedOrders));

    }
/*
    @Override
    public void update(Observable o, Object arg) {
        HashMap<Order, LinkedList<MenuItem>> orders = (HashMap<Order, LinkedList<MenuItem>>) arg;
        System.out.println(orders.size() + "\n");
        LinkedList<MenuItem> items = orders.get(orders.size());
        int notifiedOrders = orders.size();
        String message = "";
        if( items != null) {
            for (MenuItem item : items) {
                message += item.getName() + " ";
            }
            this.getField().setText(message);
            this.getOrders().setText(Integer.toString(++notifiedOrders));
        }
        else {
            this.getField().setText("No order.");
            this.getOrders().setText("0");
        }
    }
*/
    public JTextField getField() {
        return field;
    }

    public JTextField getOrders() {
        return orders;
    }
}
