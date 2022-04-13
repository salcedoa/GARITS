package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * This class is used to create GUI components that appear frequently in GARITS interfaces.
 *
 * It's methods return these components.
 *
 * The GUI creator object is utilised in most main menus.
 * ***/


public class GUICreator {
    private JPanel containerPanel;
    private CardLayout cl;

    public GUICreator(GARITS garits) {
        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();
    }

    // BUTTONS

    // seen in all role menus
    public JButton createCloseButton(JPanel target, int width) {
        JButton closeButton = new JButton("CLOSE");

        target.add(closeButton);

        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.setMaximumSize(new Dimension(width,50));
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.setOpaque(true);
        closeButton.setBorderPainted(false);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return closeButton;
    }

    // used by Franchisee, Receptionist and Foreperson
    public JButton createTakeInNewJobsButton(JPanel target, int width) {
        JButton newJobsButton = new JButton("TAKE IN NEW JOBS");
        target.add(newJobsButton);
        newJobsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newJobsButton.setMaximumSize(new Dimension(width,50));

        newJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(containerPanel,"create new job");
            }
        });

        return newJobsButton;
    }


    // used in customer record creation menu
    public JButton createBackButton(JPanel target, int posX, int posY) {
        JButton backButton = new JButton("BACK");
        target.add(backButton);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.setBounds(posX,posY,100,30);

        return backButton;
    }

    public JButton createChooseDirectoryButton(JPanel target, int posX, int posY){
        JButton chooseDirectoryButton = new JButton("Choose Directory");
        target.add(chooseDirectoryButton);
        chooseDirectoryButton.setBackground(Color.BLACK);
        chooseDirectoryButton.setForeground(Color.WHITE);
        chooseDirectoryButton.setOpaque(true);
        chooseDirectoryButton.setBorderPainted(false);
        chooseDirectoryButton.setBounds(posX,posY,200,40);
        return chooseDirectoryButton;
    }

    public JButton createChooseFileButton(JPanel target, int posX, int posY){
        JButton chooseFileButton = new JButton("Choose File");
        target.add(chooseFileButton);
        chooseFileButton.setBackground(Color.BLACK);
        chooseFileButton.setForeground(Color.WHITE);
        chooseFileButton.setOpaque(true);
        chooseFileButton.setBorderPainted(false);
        chooseFileButton.setBounds(posX,posY,200,40);
        return chooseFileButton;
    }

    public JButton createBackupButton(JPanel target, int posX, int posY){
        JButton backupButton = new JButton("Backup");
        target.add(backupButton);
        backupButton.setBackground(Color.black);
        backupButton.setForeground(Color.white);
        backupButton.setOpaque(true);
        backupButton.setBorderPainted(false);
        backupButton.setBounds(posX,posY,100,30);
        return backupButton;
    }

    public JButton createRestoreButton(JPanel target, int posX, int posY){
        JButton restoreButton = new JButton("Restore");
        target.add(restoreButton);
        restoreButton.setBackground(Color.black);
        restoreButton.setForeground(Color.white);
        restoreButton.setOpaque(true);
        restoreButton.setBorderPainted(false);
        restoreButton.setBounds(posX,posY,100,30);
        return restoreButton;
    }



    // used by Franchisee and Receptionist
    public JButton createCustomerAccountButton(JPanel target, int width) {
        JButton button = new JButton("CREATE CUSTOMER RECORD");
        target.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(width,50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(containerPanel,"customer creation form");
            }
        });

        return button;
    }

    // used by Receptionist
    public JButton createStockControlButton(JPanel target, int width) {
        JButton stockControlButton = new JButton("STOCK CONTROL");
        target.add(stockControlButton);
        stockControlButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockControlButton.setMaximumSize(new Dimension(width,50));

        stockControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(containerPanel,"stock control system");
            }
        });

        return stockControlButton;
    }

    public JButton createCheckStockButton(JPanel target, int width){
        JButton checkStockButton = new JButton("CHECK STOCK");
        target.add(checkStockButton);
        checkStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkStockButton.setMaximumSize(new Dimension(width,50));

        checkStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: check stock menu shows up
            }
        });
        return checkStockButton;
    }

    public JButton createReturnButton(JPanel target,int width){
        JButton returnButton = new JButton("RETURN");
        target.add(returnButton);
        returnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        returnButton.setMaximumSize(new Dimension(width,50));
        returnButton.setBackground(Color.BLACK);
        returnButton.setForeground(Color.WHITE);
        returnButton.setOpaque(true);
        returnButton.setBorderPainted(false);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.first(containerPanel);
            }
        });
        return returnButton;
    }

    public JButton createManageStockButton(JPanel target,int width){
        JButton manageStockButton = new JButton("MANAGE STOCK");
        target.add(manageStockButton);
        manageStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageStockButton.setMaximumSize(new Dimension(width,50));

        manageStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: manage stock menu shows up
            }
        });
        return manageStockButton;
    }

    // LABELS

    public JLabel createMenuTitle(String message, JPanel target, int width) {
        JLabel menuTitle = new JLabel(message);
        target.add(menuTitle);
        menuTitle.setMaximumSize(new Dimension(width,100));
        menuTitle.setFont(new Font("Verdana", Font.BOLD, 18));
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        return menuTitle;
    }



    public JButton createSaveButton(JPanel target, int posX, int posY) {
        JButton saveButton = new JButton("SAVE");
        target.add(saveButton);
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);
        saveButton.setBounds(posX,posY,100,30);
        return saveButton;
    }


}
