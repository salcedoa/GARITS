package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPage extends JPanel {
    // creating the frame
    private JFrame frame = new JFrame("GARITS Login");
    private JPanel loginPanel = new JPanel();

    // create components
    private JLabel titleLabel = new JLabel("Welcome to GARITS");
    private JLabel loginMessage = new JLabel("Please log in using correct credentials");
    private JLabel userLabel = new JLabel("USER");
    private JLabel passLabel = new JLabel("PASSWORD");
    private JTextField userField = new JTextField(50);
    private JTextField passField = new JPasswordField(50);
    private JButton loginButton = new JButton("LOG IN");
    private JButton quitButton = new JButton("QUIT");

    LoginPage() {
        frame.setPreferredSize(new Dimension(600,380));
        loginPanel.setLayout(null);

        // defining the positions of the components.
        // the panel has no layout so positions are defined manually.
        loginPanel.add(titleLabel);
        titleLabel.setBounds(240, 70, 200, 20);

        loginPanel.add(loginMessage);
        loginMessage.setBounds(190,110,400,20);

        loginPanel.add(loginButton);
        loginButton.setBounds(260,230,90,20);
        loginButton.setMaximumSize(new Dimension(70,40));

        loginPanel.add(quitButton);
        quitButton.setMaximumSize(new Dimension(90,40));
        quitButton.setBounds(480, 40, 50,20);

        loginPanel.add(userLabel);
        userLabel.setBounds(190,150,150,20);

        loginPanel.add(userField);
        userField.setBounds(230, 150,200,20);

        loginPanel.add(passLabel);
        passLabel.setBounds(155, 180,200,20);

        loginPanel.add(passField);
        passField.setBounds(230, 180,200,20);

        // BUTTON FUNCTIONS
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //TODO: establish a connection to the database and compare to username and password input
                try {
                    // open connection by creating a DriverManager object with database details passed as parameters
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GARITS_DB?useSSL=false","root","Lancaster6");

                    // retrieve text input for username and password fields
                    String username = userField.getText();
                    String password = passField.getText();

                    // creating mySQL query - should return ResultSet object
                    Statement statement = conn.createStatement();
                    // username and password are collated with a case-sensitive character set (utf8mb4_bin) for extra security
                    String sql = "SELECT * FROM users WHERE Username='"+username+"' COLLATE utf8mb4_bin AND Password='"+password+"' COLLATE utf8mb4_bin";
                    ResultSet resultSet = statement.executeQuery(sql);

                    // if username and password are true then access system
                    // TODO: CREATE GARTIS object instead
                    if (resultSet.next()) {
                        System.out.println("Successful Login!");
                    } else {
                        // a popup message is shown if the username or password are incorrect
                        JOptionPane.showMessageDialog(LoginPage.this, "Username or Password was incorrect");
                        userField.setText("");
                        passField.setText("");
                    }

                    // TODO: keep connection open once the system is accessed
                    conn.close();


                } catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        frame.add(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
