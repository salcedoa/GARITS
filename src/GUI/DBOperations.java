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
        titleLabel.setBounds(410,50,200,50);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 18));

        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JButton backupButton = builder.createChooseDirectoryButton(this,400,250);
        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.showSaveDialog(DBOperations.this);
            }
        });

        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
        JButton restoreButton = builder.createChooseFileButton(this, 400, 300);
        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.showOpenDialog(DBOperations.this);
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
