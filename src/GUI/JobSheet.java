package GUI;

import businesslogic.Job;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobSheet extends JPanel {
    private GUICreator builder;
    private GARITS garits;
    private JPanel containerPanel;
    private CardLayout cl;
    private SQLHelper sqlHelper = new SQLHelper();

    private JLabel titleLabel = new JLabel("Create A Job");

    private Job job;

    private JTextField customerName = new JTextField(50);
    private JTextField numberPlate = new JTextField(25);
    private JTextField make = new JTextField(50);
    private JTextField model = new JTextField(50);
    private JTextField telephone = new JTextField(20);
    private JTextArea notes = new JTextArea(50,50);

    private JLabel customerNameLabel = new JLabel("Full name");
    private JLabel numberPlateLabel = new JLabel("Number Plate");
    private JLabel telephoneLabel = new JLabel("Telephone");
    private JLabel makeLabel = new JLabel("Car Make");
    private JLabel modelLabel = new JLabel("Car Model");
    private JLabel notesLabel = new JLabel("Description Of Work Required");

    // create the array
    private JTextField jTextFieldsArray [] = {customerName,numberPlate,make,model,telephone};
    private String jTextAreaString = notes.getText();

    // method called clearTextFields
    public void clearTextFields() {
        for (JTextField i : jTextFieldsArray) {
            i.setText("");
            System.out.println(jTextAreaString);
            notes.setText("");
        }
    };
    public JobSheet(GARITS garits){
        setLayout(null);
        this.builder = garits.getBuilder();
        //sqlHelper = garits.getSQLHelper();

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        add(titleLabel);
        titleLabel.setBounds(380,50,400,50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearTextFields();
                cl.first(containerPanel);
            }
        });
        int xPos = 300;

        add(customerNameLabel);
        customerNameLabel.setBounds(xPos,125,80,20);
        add(customerName);
        customerName.setBounds(xPos,145,275,20);

        add(numberPlateLabel);
        numberPlateLabel.setBounds(xPos,170,80,20);
        add(numberPlate);
        numberPlate.setBounds(xPos,190,200,20);

        add(makeLabel);
        makeLabel.setBounds(xPos,215,80,20);
        add(make);
        make.setBounds(xPos,235,200,20);

        add(modelLabel);
        modelLabel.setBounds(xPos,260,80,20);
        add(model);
        model.setBounds(xPos,280,200,20);

        add(telephoneLabel);
        telephoneLabel.setBounds(xPos,305,80,20);
        add(telephone);
        telephone.setBounds(xPos,325,200,20);

        add(notesLabel);
        notesLabel.setBounds(xPos,350,270,20);
        add(notes);
        notes.setBounds(xPos,370,300,150);

        JButton saveButton = builder.createSaveButton(this,450,500);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                job = new Job();
                job.setCustomerName(customerName.getText());
                job.setNumberPlate(numberPlate.getText());
                job.setMake(make.getText());
                job.setModel(model.getText());
                job.setTelephone(telephone.getText());
                job.setNotes(notes.getText());

                if(sqlHelper.insertJob(job)){
                    JOptionPane.showMessageDialog(JobSheet.this,"Added new job to database");
                    clearTextFields();
                }
                else{
                    JOptionPane.showMessageDialog(JobSheet.this,"Error: Fields not entered correctly or required fields missing");
                }
            }
        });

    }
}
