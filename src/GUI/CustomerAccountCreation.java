package GUI;

import businesslogic.CustomerAccount;
import database.SQLHelper;
import main.GARITS;
import main.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/***
 *
 * Menu screen that shows the fields for the creation of a customer record
 *
 * **/

public class CustomerAccountCreation extends JPanel{
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    private CustomerAccount customerAccount;

    private JLabel titleLabel = new JLabel("CREATE CUSTOMER ACCOUNT");

    // Text fields
    private JTextField customerName = new JTextField(50);
    private JTextField addressLine1 = new JTextField(100);
    private JTextField addressLine2 = new JTextField(100);
    private JTextField addressLine3 = new JTextField(100);
    private JTextField postCode = new JTextField(10);
    private JTextField telephone = new JTextField(20);
    private JTextField mobile = new JTextField(20);
    private JCheckBox payLate = new JCheckBox("Pay Late");

    // Labels
    private JLabel customerNameLabel = new JLabel("Full Name");
    private JLabel telephoneLabel = new JLabel("Telephone");
    private JLabel mobileLabel = new JLabel("Mobile");
    private JLabel Address1Label = new JLabel("Address Line 1");
    private JLabel Address2Label = new JLabel("Address Line 2");
    private JLabel Address3Label = new JLabel("Address Line 3");
    private JLabel postcodeLabel = new JLabel("Post Code");
    private JLabel contactTitleLabel = new JLabel("Contact Title");
    private JLabel contactNameLabel = new JLabel("Contact Name");

    private JCheckBox isBusiness = new JCheckBox("Business");
    private JTextField contactTitle = new JTextField(30);
    private JTextField contactName = new JTextField(30);

    // create the array
    private JTextField jTextFieldsArray [] = {customerName,addressLine1,addressLine2,addressLine3,postCode,telephone,mobile,contactName};

    // method called clearTextFields (void)
    public void clearTextFields(){
        for(JTextField i :jTextFieldsArray) {
            i.setText("");
        }
        isBusiness.setSelected(false);
        payLate.setSelected(false);
    };

    public CustomerAccountCreation(GARITS garits) {
        setLayout(null);
        builder = garits.getBuilder();
        //sqlHelper = garits.getSQLHelper();

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
                clearTextFields();
                cl.previous(containerPanel);
            }
        });

        int xPos = 300;

        add(customerNameLabel);
        customerNameLabel.setBounds(xPos,125,80,20);
        add(customerName);
        customerName.setBounds(xPos,145,275,20);

        add(isBusiness);
        isBusiness.setBounds(xPos+285,145,100,20);

        add(telephoneLabel);
        telephoneLabel.setBounds(xPos,170,80,20);
        add(telephone);
        telephone.setBounds(xPos,190,200,20);

        add(mobileLabel);
        mobileLabel.setBounds(xPos+200,170,80,20);
        add(mobile);
        mobile.setBounds(xPos+200,190,200,20);

        add(Address1Label);
        Address1Label.setBounds(xPos,215,120,20);
        add(addressLine1);
        addressLine1.setBounds(xPos,235,400,20);

        add(Address2Label);
        Address2Label.setBounds(xPos,260,120,20);
        add(addressLine2);
        addressLine2.setBounds(xPos,280,400,20);

        add(Address3Label);
        Address3Label.setBounds(xPos,305,120,20);
        add(addressLine3);
        addressLine3.setBounds(xPos,325,400,20);

        add(postcodeLabel);
        postcodeLabel.setBounds(xPos,350,80,20);
        add(postCode);
        postCode.setBounds(xPos,370,100,20);

        add(payLate);
        payLate.setBounds(xPos+285,370,100,20);

        add(contactTitleLabel);
        contactTitleLabel.setBounds(xPos+200,395,120,20);
        add(contactTitle);
        contactTitle.setBounds(xPos+200,415,200,20);

        add(contactNameLabel);
        contactNameLabel.setBounds(xPos,395,120,20);
        add(contactName);
        contactName.setBounds(xPos,415,200,20);

        // SAVE BUTTON AND FUNCTION
        JButton saveButton = builder.createSaveButton(this, 450, 480);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerAccount = new CustomerAccount();
                customerAccount.setCustomerName(customerName.getText());
                customerAccount.setAddressLine1(addressLine1.getText());
                customerAccount.setAddressLine2(addressLine2.getText());
                customerAccount.setAddressLine3(addressLine3.getText());
                customerAccount.setTelephone(telephone.getText());
                customerAccount.setMobile(mobile.getText());
                customerAccount.setPostCode(postCode.getText());
                customerAccount.setContact(contactName.getText());
                customerAccount.setContactTitle(contactTitle.getText());
                customerAccount.setBusiness(isBusiness.isSelected());
                customerAccount.setPayLate(payLate.isSelected());

                // TODO: put a try and catch statement here for SQLException
                try {
                    sqlHelper.insertCustomer(customerAccount);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(CustomerAccountCreation.this, "Error: Fields not entered correctly or required fields missing");
                }
                clearTextFields();
            }
        });
    }
}
