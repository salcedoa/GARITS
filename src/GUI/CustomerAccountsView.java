package GUI;

import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CustomerAccountsView extends JPanel {
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    // title and table + scrollpane
    private JLabel titleLabel = new JLabel("VIEW CUSTOMER ACCOUNTS");
    private CustomerAccountsTable table = new CustomerAccountsTable();
    private JScrollPane scrollPane = new JScrollPane(table);

    // buttons
    private JButton deleteButton = new JButton("DELETE");
    private JButton changeButton = new JButton("CHANGE");
    private JButton addVehicleButton = new JButton("ADD VEHICLE");
    private JButton addDiscountButton = new JButton("ADD DISCOUNT");
    private int buttonWidth = 150;

    public CustomerAccountsView(GARITS garits) {
        setLayout(null);
        builder = garits.getBuilder();

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        // adding component listener (table will update when the JPanel is shown)
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                table.updateTable();
            }
        });

        add(titleLabel);
        titleLabel.setBounds(350, 50, 400, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        add(scrollPane);
        scrollPane.setBounds(370, 150, 500, 300);

        // DELETE BUTTON
        add(deleteButton);
        deleteButton.setBackground(Color.BLACK);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.setBounds(200,150,buttonWidth,40);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(CustomerAccountsView.this, "No record selected");
                } else {
                    int id = Integer.parseInt(table.getValueAt(row,0).toString());
                    sqlHelper.deleteItem(id,"customerRecords","CustomerID");
                    table.updateTable();
                }
            }
        });

        // CHANGE BUTTON
        add(changeButton);
        changeButton.setBackground(Color.BLACK);
        changeButton.setForeground(Color.WHITE);
        changeButton.setOpaque(true);
        changeButton.setBorderPainted(false);
        changeButton.setBounds(200,200,buttonWidth,40);

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(CustomerAccountsView.this, "No record selected");
                } else {
                    int id = Integer.parseInt(table.getValueAt(row,0).toString());
                    // TODO: show 'change customer account' form
                }
            }
        });

        // BACK BUTTON
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(containerPanel);
            }
        });

        // ADD VEHICLE BUTTON
        add(addVehicleButton);
        addVehicleButton.setBackground(Color.BLACK);
        addVehicleButton.setForeground(Color.WHITE);
        addVehicleButton.setOpaque(true);
        addVehicleButton.setBorderPainted(false);
        addVehicleButton.setBounds(200,250,buttonWidth,40);

        addVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(CustomerAccountsView.this, "No record selected");
                } else {
                    int id = Integer.parseInt(table.getValueAt(row,0).toString());
                    // TODO: show 'add vehicle' form
                }
            }
        });

        // ADD DISCOUNT BUTTON
        add(addDiscountButton);
        addDiscountButton.setBackground(Color.BLACK);
        addDiscountButton.setForeground(Color.WHITE);
        addDiscountButton.setOpaque(true);
        addDiscountButton.setBorderPainted(false);
        addDiscountButton.setBounds(200,300,buttonWidth,40);

        addDiscountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(CustomerAccountsView.this, "No record selected");
                } else {
                    int id = Integer.parseInt(table.getValueAt(row,0).toString());
                    cl.show(containerPanel,"discount form");
                }
            }
        });
    }
}
