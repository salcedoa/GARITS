package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForepersonMenu extends JPanel {
    private GUICreator builder = new GUICreator(this);

    private static final JButton allocateMechanicButton = new JButton("ALLOCATE MECHANIC");
    private static final JButton mechanicMenuButton = new JButton("MECHANIC MENU");
    private static final JButton receptionistMenuButton = new JButton("RECEPTIONIST MENU");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public ForepersonMenu() {
        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the FOREPERSON Portal!", 400);
        builder.createTakeInNewJobsButton(buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(allocateMechanicButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(mechanicMenuButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(receptionistMenuButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(buttonWidth);

        // positioning the components

        allocateMechanicButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        allocateMechanicButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        mechanicMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mechanicMenuButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        receptionistMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        receptionistMenuButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS

        allocateMechanicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Allocate mechanic
            }
        });
    }
}
