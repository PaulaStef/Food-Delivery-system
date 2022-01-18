package presentation;

import business.DeliveryService;
import business.UserRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage {
    private JFrame framePP;
    private JPanel panelPP;
    private JLabel title;
    private JButton logIn;
    private JButton register;
    private JTextField userName;
    private JTextField password;
    private AdministratorGraphicalUserInterface adminPage;
    private ClientGraphicalUserInterface clientPage;
    public static EmployeeGraphicalUserInterface employeePage;
    private Control control ;

    public StartPage(DeliveryService service) {
        control = new Control(this,service);
        initialize();
        employeePage = new EmployeeGraphicalUserInterface();
        adminPage  = new AdministratorGraphicalUserInterface(this.panelPP,service);
    }


    public void initialize(){
        framePP = new JFrame();
        framePP.setSize(700, 600);
        framePP.setBounds(450, 550, 650, 550);
        framePP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePP.getContentPane().setLayout(null);
        panelPP = new JPanel();
        panelPP.setBounds(0, 0, 700, 600);
        panelPP.setBackground(Color.darkGray);
        framePP.getContentPane().add(panelPP);
        panelPP.setLayout(null);
        setFields();
        framePP.add(panelPP);
        framePP.setVisible(true);
    }

    public void setFields(){
        title = new JLabel(" Restaurant ");
        title.setBounds(225,20,200,100);
        title.setFont(new Font("Times New Roman",Font.PLAIN,28));
        title.setForeground(Color.PINK);
        panelPP.add(title);

        register = new JButton("Register");
        register.setBounds(100,400,200,50);
        register.setFont(new Font("Times New Roman",Font.PLAIN,20));
        register.setBackground(Color.PINK);
        register.addActionListener(control);
        panelPP.add(register);

        logIn = new JButton("Log In");
        logIn.setBounds(350,400,200,50);
        logIn.setFont(new Font("Times New Roman",Font.PLAIN,20));
        logIn.setBackground(Color.PINK);
        logIn.addActionListener(control);
        panelPP.add(logIn);

        userName = new JTextField();
        userName.setBounds(160, 150,250,50);
        userName.setBackground(Color.PINK);
        JLabel label_1 = new JLabel("Username: ");
        label_1.setBounds(20,150,100,30);
        label_1.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_1.setForeground(Color.PINK);
        panelPP.add(label_1);
        panelPP.add(userName);

        password = new JTextField();
        password.setBounds(160, 270,250,50);
        password.setBackground(Color.PINK);
        JLabel label_2 = new JLabel("Password: ");
        label_2.setBounds(20,270,100,30);
        label_2.setFont(new Font("Times New Roman",Font.PLAIN,20));
        label_2.setForeground(Color.PINK);
        panelPP.add(label_2);
        panelPP.add(password);
    }

    public class Control implements ActionListener {
        presentation.StartPage page;
        DeliveryService service;

        public Control(StartPage startPage,DeliveryService service) {
            this.page = startPage;
            this.service = service;
        }

        public void actionPerformed(ActionEvent e) {
            String userName = page.getUserName().getText();
            String password = page.getPassword().getText();
            UserRole role;
            if(e.getSource() == page.getLogIn()){
                role = service.logIn(userName,password);
                if(role != null) {
                    if (role == UserRole.ADMINISTRATOR) {
                        page.getPanelPP().removeAll();
                        page.getFramePP().repaint();
                        page.getFramePP().revalidate();
                        adminPage.initializeAdmin();
                    } else if (role == UserRole.CLIENT) {
                        clientPage = new ClientGraphicalUserInterface(page.panelPP,service,userName,page);
                        page.getPanelPP().removeAll();
                        page.getFramePP().repaint();
                        page.getFramePP().revalidate();
                        clientPage.initializeClient();
                    }
                      else if (role == UserRole.EMPLOYEE) {
                       // page.getPanelPP().removeAll();
                       // page.getFramePP().repaint();
                       // page.getFramePP().revalidate();
                        employeePage.initialize();
                    }
                }
                else{
                    System.out.println("User not found! Username or password not found!");
                }
            }
            else if(e.getSource() == page.getRegister()){
                //System.out.println(userName + password);
               role = UserRole.CLIENT;
               if(service.register(userName,password,role) != null){
                   System.out.println("UserName already exists!");
               }else{
                   System.out.println("Registered.");
               }
            }
        }

    }

    public JPanel getPanelPP() {
        return panelPP;
    }

    public JLabel getTitle() {
        return title;
    }

    public JButton getLogIn() {
        return logIn;
    }

    public JButton getRegister() {
        return register;
    }

    public JTextField getUserName() {
        return userName;
    }

    public JTextField getPassword() {
        return password;
    }

    public JFrame getFramePP() {
        return framePP;
    }

    public EmployeeGraphicalUserInterface getEmployeePage() {
        return employeePage;
    }
}
