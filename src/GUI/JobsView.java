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
    // for receptionist
    private JButton deleteButton = new JButton("DELETE");
    private JButton changeButton = new JButton("CHANGE");
    private JButton invoiceButton = new JButton("INVOICE");
    // for mechanic + foreperson
    private JButton pickButton = new JButton("PICK");
    private JButton refreshButton = new JButton("REFRESH");
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

        // TITLE
        add(titleLabel);
        titleLabel.setBounds(420, 50, 200, 50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        // TABLE/SCROLL PANE
        add(scrollPane);
        scrollPane.setBounds(370, 150, 500, 300);

        // BACK BUTTON
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(containerPanel);
            }
        });

        // CHANGE BUTTON (only for receptionist)
        if (garits.getRole() == "Receptionist") {
            add(changeButton);
            changeButton.setBackground(Color.BLACK);
            changeButton.setForeground(Color.WHITE);
            changeButton.setOpaque(true);
            changeButton.setBorderPainted(false);
            changeButton.setBounds(200,150,buttonWidth,40);

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

            // DELETE BUTTON
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
                        sqlHelper.deleteItem(id,"jobs","JobID");
                    }
                }
            });

            // INVOICE BUTTON
            add(invoiceButton);
            invoiceButton.setBackground(Color.BLACK);
            invoiceButton.setForeground(Color.WHITE);
            invoiceButton.setOpaque(true);
            invoiceButton.setBorderPainted(false);
            invoiceButton.setBounds(200,250,buttonWidth,40);

            invoiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    if (row == -1) {
                        JOptionPane.showMessageDialog(JobsView.this, "No record selected");
                    } else {
                        int id = Integer.parseInt(table.getValueAt(row,0).toString());
                        // TODO: show 'invoice creation' form
                    }
                }
            });
        }

        // REFRESH BUTTON
        add(refreshButton);
        refreshButton.setBackground(Color.BLACK);
        refreshButton.setForeground(Color.WHITE);
        refreshButton.setOpaque(true);
        refreshButton.setBorderPainted(false);
        refreshButton.setBounds(200,300,buttonWidth,40);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.updateTable();
            }
        });

    }
}
