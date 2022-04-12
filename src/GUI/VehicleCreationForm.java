package GUI;

import businesslogic.Vehicle;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleCreationForm extends JPanel {
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    private Vehicle vehicle;

    private JLabel titleLabel = new JLabel("ADD NEW VEHICLE");

    private JLabel numberPlateLabel = new JLabel("Number Plate");
    private JLabel colourLabel = new JLabel("Colour");
    private JLabel lastMoTLabel = new JLabel("Date YYYY-MM-DD");
    private JLabel makeLabel = new JLabel("Vehicle Make");
    private JLabel modelLabel = new JLabel("Model");

    private JTextField numberPlate = new JTextField(50);
    private JTextField colour = new JTextField(20);
    private JTextField lastMoT = new JTextField(30);
    private JTextField make = new JTextField(50);
    private JTextField model = new JTextField(50);

    private JTextField jTextFieldsArray[] = {numberPlate,colour,lastMoT,make,model};

    public void clearTextFields(){
        for (JTextField i : jTextFieldsArray){
            i.setText("");
        }
    };

    public VehicleCreationForm(GARITS garits){
        setLayout(null);
        this.builder = garits.getBuilder();

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
        int xPos = 380;

        add(numberPlateLabel);
        numberPlateLabel.setBounds(xPos,125,250,20);
        add(numberPlate);
        numberPlate.setBounds(xPos,145,250,20);

        add(colourLabel);
        colourLabel.setBounds(xPos,170,200,20);
        add(colour);
        colour.setBounds(xPos,190,250,20);

        add(lastMoTLabel);
        lastMoTLabel.setBounds(xPos,215,200,20);
        add(lastMoT);
        lastMoT.setBounds(xPos,235,250,20);

        add(makeLabel);
        makeLabel.setBounds(xPos,260,200,20);
        add(make);
        make.setBounds(xPos,280,250,20);

        add(modelLabel);
        modelLabel.setBounds(xPos,305,200,20);
        add(model);
        model.setBounds(xPos,325,200,20);

    }
}
