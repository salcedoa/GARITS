package main;

import javax.swing.*;
import java.awt.*;

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

        frame.add(loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
