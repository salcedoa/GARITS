package GUI;

import businesslogic.CustomerAccount;
import businesslogic.Discounts;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscountForm extends JPanel {
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    private Discounts discount;

    private JLabel titleLabel = new JLabel("CHOOSE DISCOUNT TYPE");

    private String discountTypes[] = {"Fixed","Variable","Flexible"};
    private JComboBox discountType = new JComboBox(discountTypes);

    private JLabel discountTypeLabel = new JLabel("Discount Type");
    private JLabel discountPercentageLabel = new JLabel("Discount Percentage");
    private JLabel flexibleLowRangeLabel = new JLabel("Flexible Low Range");
    private JLabel flexibleHighRangeLabel = new JLabel("Flexible High Range");
    private JLabel variableBusinessTypeLabel = new JLabel("Business Type");

    private JTextField discountPercentage = new JTextField(50);
    private JTextField flexibleLowRange = new JTextField(50);
    private JTextField flexibleHighRange = new JTextField(50);
    private JTextField variableBusinessType = new JTextField(50);

    private JTextField jTextFieldsArray[] = {discountPercentage, flexibleLowRange, flexibleHighRange, variableBusinessType};

    public void clearTextFields() {
        for (JTextField i : jTextFieldsArray) {
            i.setText("");
        }
    }

    ;

    public DiscountForm(GARITS garits) {
        setLayout(null);
        this.builder = garits.getBuilder();

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        add(titleLabel);
        titleLabel.setBounds(380, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // back button
        JButton backButton = builder.createBackButton(this, 700, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
                cl.first(containerPanel);
            }
        });

        int xPos = 380;

        add(discountTypeLabel);
        discountTypeLabel.setBounds(xPos, 125, 250, 20);
        add(discountType);
        discountType.setBounds(xPos, 145, 250, 20);

        add(discountPercentageLabel);
        discountPercentageLabel.setBounds(xPos, 170, 200, 20);
        add(discountPercentage);
        discountPercentage.setBounds(xPos, 190, 250, 20);

        add(flexibleLowRangeLabel);
        flexibleLowRangeLabel.setBounds(xPos, 215, 200, 20);
        add(flexibleLowRange);
        flexibleLowRange.setBounds(xPos, 235, 250, 20);

        add(flexibleHighRangeLabel);
        flexibleHighRangeLabel.setBounds(xPos, 260, 200, 20);
        add(flexibleHighRange);
        flexibleHighRange.setBounds(xPos, 280, 250, 20);

        add(variableBusinessTypeLabel);
        variableBusinessTypeLabel.setBounds(xPos, 305, 200, 20);
        add(variableBusinessType);
        variableBusinessType.setBounds(xPos, 325, 250, 20);

        JButton saveButton = builder.createSaveButton(this, 450, 480);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discount = new Discounts();
                discount.setDiscountType((String) discountType.getSelectedItem());

                if (!discountPercentage.getText().equals("")) {
                    try {
                        int discountPercentageInt = Integer.valueOf(discountPercentage.getText());
                        discount.setDiscountPercentage(discountPercentageInt);
                    } catch (NumberFormatException ex) {
                        discount.setDiscountPercentage(0);
                    }
                } else {
                    discount.setDiscountPercentage(0);
                }

                if (!flexibleLowRange.equals("")) {
                    try {
                        int flexibleLowRangeInt = Integer.valueOf(flexibleLowRange.getText());
                        discount.setFlexibleLowRange(flexibleLowRangeInt);
                    } catch (NumberFormatException ex) {
                        discount.setFlexibleLowRange(0);
                    }
                }

                if (!flexibleHighRange.equals("")) {
                    try {
                        int flexibleHighRangeInt = Integer.valueOf(flexibleHighRange.getText());
                        discount.setFlexibleHighRange(flexibleHighRangeInt);
                    } catch (NumberFormatException ex) {
                        discount.setFlexibleHighRange(0);
                    }
                }

                //if (sqlHelper.insertDiscount(discount)) {
                //JOptionPane.showMessageDialog(DiscountForm.this, "Added New Discount To Database");
                clearTextFields();
                //} else{
                //JOptionPane.showMessageDialog(DiscountForm.this,"Error: Fields not entered correctly or required fields missing");
                //}
                //}
            }
        });
    }
}
