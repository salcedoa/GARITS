package GUI;

import admin.UserAccount;
import main.GARITS;
import database.SQLHelper;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserAccountCreation extends JPanel{
    private GUICreator builder;
    private GARITS garits;
    private JPanel containerPanel;
    private CardLayout cl;
    private SQLHelper sqlHelper = new SQLHelper();

    private JLabel titleLabel = new JLabel("CREATE USER ACCOUNT");

    private UserAccount userAccount;

    // Labels
    private JLabel accountHolderLabel = new JLabel("Account Holder");
    private JLabel usernameLabel = new JLabel("Username");
    private JLabel passwordLabel = new JLabel("Password");
    private JLabel accountType = new JLabel("Account Type");
    private JLabel hourlyRateLabel = new JLabel("Hourly Rate");

    // Text fields
    // TODO: add column length as a paramter on each field
    private JTextField accountHolder = new JTextField(50);
    private JTextField username = new JTextField(50);
    private JPasswordField password = new JPasswordField(50);
    private JTextField hourlyRate = new JTextField(50);

    // Drop down menu
    private String roles [] = {"Franchisee", "Receptionist", "Foreman", "Mechanic"};
    private JComboBox accountTypeMenu = new JComboBox(roles);

    // TODO: create array to clear text fields and clearTextField
    // create the array
    private JTextField jTextFieldsArray [] = {accountHolder,username,password,hourlyRate};

    // method called clearTextFields (void)
    public void clearTextFields() {
        for (JTextField i : jTextFieldsArray) {
            i.setText("");
        }
    };

    public UserAccountCreation(GARITS garits) {
        setLayout(null);
        this.builder = garits.getBuilder();

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        add(titleLabel);
        titleLabel.setBounds(380, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // back button
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
                cl.first(containerPanel);
            }
        });

        int xPos = 380;

        add(accountHolderLabel);
        accountHolderLabel.setBounds(xPos,125,100,20);
        add(accountHolder);
        accountHolder.setBounds(xPos,145,250,20);

        add(usernameLabel);
        usernameLabel.setBounds(xPos,170,80,20);
        add(username);
        username.setBounds(xPos,190,250,20);

        add(passwordLabel);
        passwordLabel.setBounds(xPos,215,80,20);
        add(password);
        password.setBounds(xPos,235,250,20);

        add(accountType);
        accountType.setBounds(xPos,260,250,20);
        add(accountTypeMenu);
        accountTypeMenu.setBounds(xPos,280,250,20);

        add(hourlyRateLabel);
        hourlyRateLabel.setBounds(xPos,305,80,20);
        add(hourlyRate);
        hourlyRate.setBounds(xPos,325,250,20);


        JButton saveButton = builder.createSaveButton(this,450,420);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                userAccount = new UserAccount();
                userAccount.setAccountHolder(accountHolder.getText());
                userAccount.setUsername(username.getText());
                userAccount.setPassword(password.getText());
                userAccount.setAccountType((String) accountTypeMenu.getSelectedItem());
                if( sqlHelper.insertUser(userAccount)) {
                    JOptionPane.showMessageDialog(UserAccountCreation.this, "Added new user account to database");
                    clearTextFields();
                } else {
                    JOptionPane.showMessageDialog(UserAccountCreation.this, "Error: Fields not entered correctly or required fields missing");
                }

            }
        });
    }

}
