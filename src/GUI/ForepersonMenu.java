package GUI;


import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForepersonMenu extends JPanel {
    private GUICreator builder;
    private JPanel containerPanel;
    private CardLayout cl;


    private static final JButton allocateMechanicButton = new JButton("ALLOCATE MECHANIC");
    private static final JButton viewJobsButton = new JButton("VIEW JOB PROGRESS");
    private static final JButton receptionistMenuButton = new JButton("RECEPTIONIST MENU");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public ForepersonMenu(GARITS garits) {
        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        builder = garits.getBuilder();

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the FOREPERSON Portal!",this, 400);
        builder.createTakeInNewJobsButton(this,buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(allocateMechanicButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(viewJobsButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(receptionistMenuButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(this,buttonWidth);

        // positioning the components

        allocateMechanicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        allocateMechanicButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        viewJobsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewJobsButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        receptionistMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        receptionistMenuButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS

        receptionistMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(containerPanel,"receptionist menu");
            }
        });
    }
}
