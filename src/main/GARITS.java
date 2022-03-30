package main;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class GARITS {
    private JFrame frame;
    // the container panel will hold all the different GUI menus and interfaces
    private JPanel containerPanel;
    // as the interfaces will be switching, card layout is used
    private CardLayout cl;

    // denotes the role of the user that has logged into GARITS
    private String role;
    private Connection conn;

    // initialises the system by checking the configurations and settings in the data folder
    public GARITS(String role, Connection conn) {
        // parameters are passed on to local variables
        this.role = role;
        this.conn = conn;

        // creating the frame
        frame = new JFrame("GARITS");
        containerPanel = new JPanel();
        containerPanel.setLayout(cl);

        frame.setPreferredSize(new Dimension(1000,600));
        frame.add(containerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    // detects the account type logging in and shows the corresponding menu
    public void showMenu() {
        switch (role) {
            case "Administrator":
                break;
            case "Franchisee":
                break;
            case "Foreman":
                break;
            case "Receptionist":
                break;
            case "Mechanic":
        }
    }

    public static void main(String[] args) {
        // login page is created when program runs
        // GARITS object is created inside LoginPage upon successful login
        new LoginPage();
    }
}
