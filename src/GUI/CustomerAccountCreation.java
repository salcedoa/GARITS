package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;

/***
 *
 * Menu screen that shows the fields for the creation of a customer record
 *
 * **/

public class CustomerAccountCreation extends JPanel{
    private GUICreator builder;

    private JLabel titleLabel = new JLabel("CREATE CUSTOMER ACCOUNT");

    // create the array

    // Text fields
    private JTextField customerName = new JTextField(50);
    private JTextField addressLine1 = new JTextField(100);
    private JTextField addressLine2 = new JTextField(100);
    private JTextField addressLine3 = new JTextField(100);
    private JTextField postCode = new JTextField(10);
    private JTextArea notes = new JTextArea(50,4);
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
    private JLabel contactNameLabel = new JLabel("Contact Name");
    private JLabel notesLabel = new JLabel("Notes");

    private JCheckBox isBusiness = new JCheckBox("Business");
    private String titles[] = {"Mr", "Mrs", "Miss", "Ms"};
    private JComboBox contactTitle = new JComboBox(titles);
    private JTextField contactName = new JTextField(50);

    // method called clearTextFields (void)


    public CustomerAccountCreation(GARITS garits) {
        setLayout(null);
        builder = garits.getBuilder();

        add(titleLabel);
        titleLabel.setBounds(350, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        builder.createBackButton(this,700,30);

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

        add(contactTitle);
        contactTitle.setBounds(xPos,415,80,20);

        add(contactNameLabel);
        contactNameLabel.setBounds(xPos+80,395,120,20);
        add(contactName);
        contactName.setBounds(xPos+80,415,320,20);

        add(notesLabel);
        notesLabel.setBounds(xPos,440,80,20);
        add(notes);
        notes.setBounds(xPos,460,400,60);

        builder.createSaveButton(this, xPos, 7);
    }
}
