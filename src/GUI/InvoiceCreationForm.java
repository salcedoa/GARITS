package GUI;

import businesslogic.Invoice;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InvoiceCreationForm extends JPanel {
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    private Invoice invoice;

    private JLabel titleLabel = new JLabel("CREATE NEW INVOICE");

    private JLabel customerNameLabel = new JLabel("Customer Name");
    private JLabel makeLabel = new JLabel("Vehicle Make");
    private JLabel modelLabel = new JLabel("Model");
    private JLabel descriptionDoneWorkLabel = new JLabel("Description Of Done Work");
    private JLabel totalPartCostLabel = new JLabel("Total Cost Of Used Parts");
    private JLabel labourCostLabel = new JLabel("Labour Cost");
    private JLabel addedVATLabel = new JLabel("Added VAT");
    private JLabel totalLabel = new JLabel("Total cost");
    private JLabel discountAppliedLabel = new JLabel("Discount Applied Amount");

    private JTextField customerName = new JTextField(50);
    private JTextField make = new JTextField(50);
    private JTextField model = new JTextField(50);
    private JTextField descriptionDoneWork = new JTextField(80);
    private JTextField totalPartCost = new JTextField(50);
    private JTextField labourCost = new JTextField(20);
    private JTextField addedVAT = new JTextField(20);
    private JTextField total = new JTextField(20);
    private JTextField discountApplied = new JTextField(20);

    private JTextField jTextFieldsArray[] = {customerName,make,model,descriptionDoneWork,totalPartCost,labourCost,addedVAT,total,discountApplied};

    public void clearTextFields(){
        for(JTextField i:jTextFieldsArray){
            i.setText("");
        }
    };

    public InvoiceCreationForm(GARITS garits) {
        setLayout(null);
        this.builder = garits.getBuilder();

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        add(titleLabel);
        titleLabel.setBounds(380, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton backButton = builder.createBackButton(this, 700, 30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
                cl.first(containerPanel);
            }
        });
        int xPos = 300;

        add(customerNameLabel);
        customerNameLabel.setBounds(xPos,125,250,20);
        add(customerName);
        customerName.setBounds(xPos,145,250,20);

        add(makeLabel);
        makeLabel.setBounds(xPos,170,250,20);
        add(make);
        make.setBounds(xPos,190,250,20);

        add(modelLabel);
        modelLabel.setBounds(xPos,215,250,20);
        add(model);
        model.setBounds(xPos,235,250,20);

        add(descriptionDoneWorkLabel);
        descriptionDoneWorkLabel.setBounds(xPos,260,250,20);
        add(descriptionDoneWork);
        descriptionDoneWork.setBounds(xPos,280,250,20);

        add(totalPartCostLabel);
        totalPartCostLabel.setBounds(xPos,305,250,20);
        add(totalPartCost);
        totalPartCost.setBounds(xPos,325,250,20);

        add(labourCostLabel);
        labourCostLabel.setBounds(xPos,345,250,20);
        add(labourCost);
        labourCost.setBounds(xPos,365,250,20);

        add(addedVATLabel);
        addedVATLabel.setBounds(xPos,390,250,20);
        add(addedVAT);
        addedVAT.setBounds(xPos,410,250,20);

        add(totalLabel);
        totalLabel.setBounds(xPos,430,250,20);
        add(total);
        total.setBounds(xPos,450,250,20);

        add(discountAppliedLabel);
        discountAppliedLabel.setBounds(xPos,475,250,20);
        add(discountApplied);
        discountApplied.setBounds(xPos,495,250,20);

        JButton saveButton = builder.createSaveButton(this,450,520);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                invoice = new Invoice();
                invoice.setCustomerName(customerName.getText());
                invoice.setMake(make.getText());
                invoice.setModel(model.getText());
                invoice.setDescriptionDoneWork(descriptionDoneWork.getText());

                if (!totalPartCost.getText().equals("")) {
                    try {
                        float totalPartCostFloat = Float.parseFloat(totalPartCost.getText());
                        invoice.setTotalPartCost(totalPartCostFloat);
                    } catch (NumberFormatException ex) {
                        invoice.setTotalPartCost(0.00f);
                    }
                }
                else{
                    invoice.setTotalPartCost(0.00f);
                }


                if(!labourCost.getText().equals("")){
                    try{
                        float labourCostFloat = Float.parseFloat(labourCost.getText());
                        invoice.setLabourCost(labourCostFloat);
                    } catch (NumberFormatException ex) {
                        invoice.setLabourCost(0.00f);
                    }
                }
                else{
                    invoice.setLabourCost(0.00f);
                }


               if(!addedVAT.getText().equals("")){
                   try{
                       float addedVATFloat = Float.parseFloat(addedVAT.getText());
                       invoice.setAddedVAT(addedVATFloat);
                   } catch(NumberFormatException ex){
                       invoice.setAddedVAT(0.00f);
                   }
               }
               else {
                   invoice.setAddedVAT(0.00f);
               }


               if(!total.getText().equals("")){
                   try{
                       float totalFloat = Float.parseFloat(total.getText());
                       invoice.setTotal(totalFloat);
                   } catch(NumberFormatException ex){
                       invoice.setTotal(0.00f);
                   }
               }
               else {
                   invoice.setTotal(0.00f);
               }

                if(!discountApplied.getText().equals("")){
                    try{
                        float discountAppliedFloat = Float.parseFloat(discountApplied.getText());
                        invoice.setDiscountApplied(discountAppliedFloat);
                    } catch(NumberFormatException ex){
                        invoice.setDiscountApplied(0.00f);
                    }
                }
                else{
                    invoice.setDiscountApplied(0.00f);
                }

//                invoice.setDiscountApplied(discountApplied.getText());

//                if (SQLHelper.insertInvoice(invoice)){
//                    JOptionPane.showMessageDialog(VehicleCreationForm.this,"Added new invoice to database");
//                    clearTextFields();
//                } else{
//                    JOptionPane.showMessageDialog(VehicleCreationForm.this,"Error: Fields not entered correctly or required fields missing");
//                }

            }
        });





    }
}
