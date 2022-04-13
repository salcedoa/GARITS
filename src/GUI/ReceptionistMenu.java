package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceptionistMenu extends JPanel {
    private JPanel containerPanel;
    private CardLayout cl;
    private GUICreator builder;

    private static final JButton viewJobProgressButton = new JButton("VIEW JOB PROGRESS");
    private static final JButton createInvoiceButton = new JButton("CREATE INVOICE");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public ReceptionistMenu(GARITS garits) {
        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();
        builder = garits.getBuilder();;

        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the RECEPTIONIST Portal!",this, 400);
        builder.createTakeInNewJobsButton(this, buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        builder.createCustomerAccountButton(this, buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(viewJobProgressButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(createInvoiceButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        builder.createStockControlButton(this, buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(this, buttonWidth);

        // positioning the components

        createInvoiceButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createInvoiceButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        viewJobProgressButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewJobProgressButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS

        viewJobProgressButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(containerPanel,"jobs view");
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
