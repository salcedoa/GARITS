package GUI;

import database.SQLHelper;
import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DBOperations extends JPanel{
    private GUICreator builder;
    private GARITS garits;
    private JPanel containerPanel;
    private SQLHelper sqlHelper = new SQLHelper();
    private CardLayout cl;

    private JLabel titleLabel = new JLabel("Backup Database");
    JFileChooser j = new JFileChooser();


    public DBOperations(GARITS garits){
        setLayout(null);
        this.builder = garits.getBuilder();

        add(titleLabel);
        titleLabel.setBounds(350,50,400,50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        JButton backupButton = builder.createChooseDirectoryButton(this,450,250);
        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.showSaveDialog(null);
            }
        });

        JButton restoreButton = builder.createChooseFileButton(this, 450, 300);
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.showOpenDialog(null);
            }
        });



        // back button
        JButton backButton = builder.createBackButton(this,700,30);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(containerPanel);
            }
        });

        int xPos = 300;

    }
}