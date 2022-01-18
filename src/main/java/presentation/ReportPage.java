package presentation;

import business.DeliveryService;
import business.UserRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ReportPage {
    private JFrame framePP;
    private JPanel panelPP;
    private JButton timeReport;
    private JButton popularityReport;
    private JButton loyalReport;
    private JButton todayReport;
    private JTextField startHour;
    private JTextField finishHour;
    private JTextField noOfOrders;
    private JTextField noOfTimes;
    private JTextField value;
    private JTextField date;
    private Control control;

    public ReportPage(DeliveryService service) {
        control = new Control(this,service);
        initialize();
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


        timeReport = new JButton("Time Interval Report");
        timeReport.setBounds(370,60,200,50);
        timeReport.setBackground(Color.PINK);
        timeReport.setFont(new Font("Times New Roman",Font.PLAIN,20));
        timeReport.addActionListener(control);
        panelPP.add(timeReport);


        startHour = new JTextField();
        startHour.setBounds(30, 40,200,40);
        startHour.setBackground(Color.PINK);
        JLabel label_2 = new JLabel("Start hour:  ");
        label_2.setBounds(30,10,100,30);
        label_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_2.setForeground(Color.PINK);
        panelPP.add(label_2);
        panelPP.add(startHour);

        finishHour = new JTextField();
        finishHour.setBounds(30, 120,200,40);
        finishHour.setBackground(Color.PINK);
        JLabel label_1 = new JLabel("Finish Hour: ");
        label_1.setBounds(30,90,130,30);
        label_1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_1.setForeground(Color.PINK);
        panelPP.add(label_1);
        panelPP.add(finishHour);

        popularityReport = new JButton("Popularity Report");
        popularityReport.setBounds(370,190,200,50);
        popularityReport.setBackground(Color.PINK);
        popularityReport.setFont(new Font("Times New Roman",Font.PLAIN,20));
        popularityReport.addActionListener(control);
        panelPP.add(popularityReport);

        noOfOrders = new JTextField();
        noOfOrders.setBounds(30, 210,200,40);
        noOfOrders.setBackground(Color.PINK);
        JLabel label_3 = new JLabel("No. of Orders: ");
        label_3.setBounds(30,180,150,30);
        label_3.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_3.setForeground(Color.PINK);
        panelPP.add(label_3);
        panelPP.add(noOfOrders);

        noOfTimes = new JTextField();
        noOfTimes.setBounds(30, 290,200,40);
        noOfTimes.setBackground(Color.PINK);
        JLabel label_4 = new JLabel("No. of Times:  ");
        label_4.setBounds(30,260,130,30);
        label_4.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_4.setForeground(Color.PINK);
        panelPP.add(label_4);
        panelPP.add(noOfTimes);

        value = new JTextField();
        value.setBounds(30, 360,200,40);
        value.setBackground(Color.PINK);
        JLabel label_5 = new JLabel("Value: ");
        label_5.setBounds(30,330,130,30);
        label_5.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_5.setForeground(Color.PINK);
        panelPP.add(label_5);
        panelPP.add(value);

        loyalReport = new JButton("Loyal Clients Report");
        loyalReport.setBounds(370,300,200,50);
        loyalReport.setBackground(Color.PINK);
        loyalReport.setFont(new Font("Times New Roman",Font.PLAIN,18));
        loyalReport.addActionListener(control);
        panelPP.add(loyalReport);

        date = new JTextField();
        date.setBounds(30, 435,200,40);
        date.setBackground(Color.PINK);
        JLabel label_6 = new JLabel("Date : ");
        label_6.setBounds(30,405,130,30);
        label_6.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_6.setForeground(Color.PINK);
        panelPP.add(label_6);
        panelPP.add(date);

        todayReport = new JButton("Today's Products Report");
        todayReport.setBounds(370,420,200,50);
        todayReport.setBackground(Color.PINK);
        todayReport.setFont(new Font("Times New Roman",Font.PLAIN,18));
        todayReport.addActionListener(control);
        panelPP.add(todayReport);
    }

    public class Control implements ActionListener {
        presentation.ReportPage page;
        DeliveryService service;

        public Control(ReportPage page,DeliveryService service) {
            this.page = page;
            this.service = service;
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == page.getLoyalReport()){
                int nb = Integer.parseInt(page.getNoOfTimes().getText());
                Double price = Double.parseDouble(page.getValue().getText());
                service.generateLoyalClientsReport(nb,price);
            }
            else if(e.getSource() == page.getPopularityReport()){
                int nb = Integer.parseInt(page.getNoOfOrders().getText());
                service.generatePopularityReport(nb);
            }
            else if(e.getSource() == page.getTimeReport()){
                int start = Integer.parseInt(page.getStartHour().getText());
                int finish = Integer.parseInt(page.getFinishHour().getText());
                service.getBetween(start,finish);
            }
            else if(e.getSource() == page.getTodayReport()){
                String date = page.getDate().getText();
                try {
                    service.generateTodayProductsReport(date);
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        }

    }

    public JButton getTimeReport() {
        return timeReport;
    }

    public JButton getPopularityReport() {
        return popularityReport;
    }

    public JButton getLoyalReport() {
        return loyalReport;
    }

    public JButton getTodayReport() {
        return todayReport;
    }

    public JTextField getStartHour() {
        return startHour;
    }

    public JTextField getFinishHour() {
        return finishHour;
    }

    public JTextField getNoOfOrders() {
        return noOfOrders;
    }

    public JTextField getNoOfTimes() {
        return noOfTimes;
    }

    public JTextField getValue() {
        return value;
    }

    public JTextField getDate() {
        return date;
    }
}




