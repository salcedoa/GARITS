package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAccountCreation extends JPanel{
    private GUICreator builder;
    private GARITS garits;
    private JPanel containerPanel;
    private CardLayout cl;

    private JLabel titleLabel = new JLabel("CREATE USER ACCOUNT");

    // Labels
    private JLabel accountHolderLabel = new JLabel("Account Holder");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel accountType = new JLabel("Account Type");

    // Text fields
    // TODO: add column length as a paramter on each field
    private JTextField accountHolderField = new JTextField();
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();

    // Drop down menu
    private String roles [] = {"Franchisee", "Receptionist", "Foreman", "Mechanic"};
    private JComboBox accountTypeMenu = new JComboBox();

    // TODO: create array to clear text fields and clearTextField

    public UserAccountCreation(GARITS garits) {
        this.garits = garits;

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        add(titleLabel);
        titleLabel.setBounds(350, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // back button
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clearTextFields();
                cl.previous(containerPanel);
            }
        });

        int xPos;
    }

}
