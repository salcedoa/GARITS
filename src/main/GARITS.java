package main;

import GUI.*;

import javax.swing.*;
import java.awt.*;

public class GARITS {
    private JFrame frame;
    // the container panel will hold all the different GUI menus and interfaces
    private JPanel containerPanel;
    // as the interfaces will be switching, card layout is used
    private CardLayout cl = new CardLayout();

    // denotes the role of the user that has logged into GARITS
    private String role;

    // initialises the system by checking the configurations and settings in the data folder
    public GARITS(String role) {
        // parameters are passed on to local variables
        this.role = role;

        // creating the frame
        frame = new JFrame("GARITS");
        containerPanel = new JPanel();
        containerPanel.setLayout(cl);

        showMenu();

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
                containerPanel.add("admin menu", new AdminMenu());
                cl.show(containerPanel, "admin menu");
                break;
            case "Franchisee":
                containerPanel.add("franchisee menu", new FranchiseeMenu());
                cl.show(containerPanel, "franchisee menu");
                break;
            case "Foreman":
                containerPanel.add("foreman menu", new ForepersonMenu());
                cl.show(containerPanel, "foreman menu");
                break;
            case "Receptionist":
                containerPanel.add("receptionist menu", new ReceptionistMenu());
                cl.show(containerPanel, "receptionist menu");
                break;
            case "Mechanic":
                containerPanel.add("mechanic menu", new MechanicMenu());
                cl.show(containerPanel,"mechanic menu");
        }
    }

    public static void main(String[] args) {
        // login page is created when program runs
        // GARITS object is created inside LoginPage upon successful login
        new LoginPage();

        // TESTS
        //String role = "Mechanic";
        //new GARITS(role);
    }
}
