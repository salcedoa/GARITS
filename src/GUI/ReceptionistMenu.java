package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistMenu extends JPanel {
    private GUICreator builder = new GUICreator(this);

    private static final JButton viewJobProgressButton = new JButton("VIEW JOB PROGRESS");
    private static final JButton createInvoiceButton = new JButton("CREATE INVOICE");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public ReceptionistMenu() {
        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the RECEPTIONIST Portal!", 400);
        builder.createTakeInNewJobsButton(buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        builder.createCustomerAccountButton(buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(viewJobProgressButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(createInvoiceButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        builder.createStockControlButton(buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(buttonWidth);

        // positioning the components

        createInvoiceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createInvoiceButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        viewJobProgressButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewJobProgressButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS

        viewJobProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: View job progress
            }
        });

        createInvoiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Specify spare parts (GUI creator)
            }
        });
    }
}
