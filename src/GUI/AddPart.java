package GUI;

import businesslogic.Job;
import businesslogic.Stock;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPart extends JPanel{
    private GUICreator builder;
    private GARITS garits;
    private JPanel containerPanel;
    private CardLayout cl;
    private SQLHelper sqlHelper = new SQLHelper();

    private JLabel titleLabel = new JLabel("Specify Spare Part");

    private Stock part;

    private JTextField partName = new JTextField(50);
    private JTextField partType = new JTextField(50);
    private JTextField vehicle  = new JTextField(50);
    private JTextField soldIn = new JTextField(30);
    private JTextField manufacturer = new JTextField(50);
    private JTextField manufacturerPrice = new JTextField(15);
    private JTextField customerCost = new JTextField(15);
    private JTextField lowLevelThreshold = new JTextField(15);
    //    private JTextField stockLevel = new JTextField(15);
    //    private JTextField ordered = new JTextField(15);


    private JLabel partNameLabel = new JLabel("Part Name");
    private JLabel partTypeLabel = new JLabel("Part Type");
    private JLabel vehicleLabel = new JLabel("Vehicle");
    private JLabel soldInLabel = new JLabel("Sold In");
    private JLabel manufacturerLabel = new JLabel("Manufacturer");
    private JLabel manufacturerPriceLabel = new JLabel("Manufacturer Price");
    private JLabel customerCostLabel = new JLabel("Customer Price");
    private JLabel lowLevelThresholdLabel = new JLabel("Low Level Threshold");
    //    private JLabel stockLevelLabel = new JLabel("");

    private JTextField jTextFieldArray [] = {partName,partType,vehicle,soldIn,manufacturer,manufacturerPrice,customerCost,lowLevelThreshold};

    public void clearTextFields(){
        for(JTextField i:jTextFieldArray){
            i.setText("");
        }
}
    public AddPart(GARITS garits){
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

        add(partNameLabel);
        partNameLabel.setBounds(xPos, 125, 80,20);
        add(partName);
        partName.setBounds(xPos,145,275,20);

        add(partTypeLabel);
        partTypeLabel.setBounds(xPos+200,125,80,20);
        add(partType);
        partType.setBounds(xPos+200,145,275,20);

        add(vehicleLabel);
        vehicleLabel.setBounds(xPos,170,80,20);
        add(vehicle);
        vehicle.setBounds(xPos,190,275,20);

        add(soldInLabel);
        soldInLabel.setBounds(xPos,215,80,20);
        add(soldIn);
        soldIn.setBounds(xPos,235,275,20);

        add(manufacturerLabel);
        manufacturerLabel.setBounds(xPos,260,80,20);
        add(manufacturer);
        manufacturer.setBounds(xPos,280,275,20);

        add(manufacturerPriceLabel);
        manufacturerPriceLabel.setBounds(xPos+200,260,80,20);
        add(manufacturerPrice);
        manufacturerPrice.setBounds(xPos+200,280,275,20);

        add(customerCostLabel);
        customerCostLabel.setBounds(xPos,305,80,20);
        add(customerCost);
        customerCost.setBounds(xPos,325,80,20);

        add(lowLevelThresholdLabel);
        lowLevelThresholdLabel.setBounds(xPos,350,80,20);
        add(lowLevelThreshold);
        lowLevelThreshold.setBounds(xPos,370,275,20);

        JButton saveButton = builder.createSaveButton(this,450,480);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                part = new Stock();

                part.setPartName(partName.getText());
                part.setPartType(partType.getText());
                part.setVehicle(vehicle.getText());
                part.setSoldIn(soldIn.getText());
                part.setManufacturer(manufacturer.getText());
                float manufacturePriceFloat = Float.parseFloat(manufacturerPrice.getText());
                part.setManufacturerPrice(manufacturePriceFloat);
                float customerCostFloat = Float.parseFloat(customerCost.getText());
                part.setCustomerCost(customerCostFloat);
                Integer lowLevelThresholdInt = Integer.parseInt(lowLevelThreshold.getText());
                part.setLowLevelThreshold(lowLevelThresholdInt);


//                if(SQLHelper.insertStock(part)) { no insert stock in sql helper or other name etc
//                    JOptionPane.showMessageDialog(AddPart.this, "Added new part to stock table");
//                    clearTextFields();
//                } else {
//                    JOptionPane.showMessageDialog(AddPart.this,Error: "Fields not entered correctly or required fields missing");
//
//                }
            }
        });

    }
}
