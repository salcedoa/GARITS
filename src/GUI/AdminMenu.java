package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends JPanel {
    private JPanel containerPanel;
    private CardLayout cl;
    private GUICreator builder;

    private static final JButton addUserButton = new JButton("ADD USER");
    private static final JButton removeUserButton = new JButton("REMOVE USER");
    private static final JButton changeExistingUserButton = new JButton("CHANGE EXISTING USER");
    private static final JButton backupDataButton = new JButton("BACK UP DATA");
    private static final JButton restoreDataButton = new JButton("RESTORE DATA");

    private int buttonWidth = 180;
    private int buttonHeight = 50;

    public AdminMenu(GARITS garits) {
        // setting the controller class as a local variable
        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();
        builder = garits.getBuilder();

        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the ADMIN Portal!",this, 310);
        this.add(addUserButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(removeUserButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(changeExistingUserButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(backupDataButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(restoreDataButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(this,buttonWidth);

        // positioning the components
        addUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addUserButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        removeUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeUserButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        changeExistingUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        changeExistingUserButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        backupDataButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backupDataButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        restoreDataButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restoreDataButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Add new user
                cl.show(containerPanel,"user account form");
            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Remove user
            }
        });

        changeExistingUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Change existing user
            }
        });

        backupDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Back up data (put data on external file)
            }
        });

        restoreDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Restore data (enter all data back onto SQL)
            }
        });
    }
}