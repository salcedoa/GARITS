package GUI;

import businesslogic.Job;
import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class JobsView extends JPanel {
    private GUICreator builder;
    private SQLHelper sqlHelper = new SQLHelper();

    private JPanel containerPanel;
    private CardLayout cl;

    // title and table + scrollpane
    private JLabel titleLabel = new JLabel("VIEW JOBS");
    private JobsTable table = new JobsTable();
    private JScrollPane scrollPane = new JScrollPane(table);

    // buttons
    private JButton deleteButton = new JButton("DELETE");
    private JButton changeButton = new JButton("CHANGE");
    private JButton addVehicleButton = new JButton("INVOICE");
    private int buttonWidth = 150;

    public JobsView(GARITS garits) {
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

        // CHANGE BUTTON (only for receptionist)
        if (garits.getRole() == "Receptionist") {
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
                        JOptionPane.showMessageDialog(JobsView.this, "No record selected");
                    } else {
                        int id = Integer.parseInt(table.getValueAt(row,0).toString());
                        // TODO: show 'change jobs' form
                    }
                }
            });
        }

        // BACK BUTTON
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(containerPanel);
            }
        });

        // DELETE BUTTON
        if (garits.getRole() == "Receptionist") {
            add(deleteButton);
            deleteButton.setBackground(Color.BLACK);
            deleteButton.setForeground(Color.WHITE);
            deleteButton.setOpaque(true);
            deleteButton.setBorderPainted(false);
            deleteButton.setBounds(200,200,buttonWidth,40);

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    if (row == -1) {
                        JOptionPane.showMessageDialog(JobsView.this, "No record selected");
                    } else {
                        int id = Integer.parseInt(table.getValueAt(row,0).toString());
                        // TODO: show 'change jobs' form
                    }
                }
            });
        }


    }
}
