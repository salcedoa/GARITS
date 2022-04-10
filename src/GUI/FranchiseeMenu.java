package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FranchiseeMenu extends JPanel {
    private JPanel containerPanel;
    private CardLayout cl;
    private GUICreator builder;

    private static final JButton generateReportButton = new JButton("GENERATE REPORTS");
    private static final JButton specifySpareParts = new JButton("SPECIFY SPARE PARTS");
    private static final JButton createCustomerAccountsButton = new JButton("CREATE CUSTOMER ACCOUNTS");
    private static final JButton alterCustomerAccountsButton = new JButton("ALTER CUSTOMER ACCOUNTS");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public FranchiseeMenu(GARITS garits) {
        // setting the controller class as a local variable
        containerPanel = garits.getContainerPanel();
        cl = garits.getCl();

        builder = garits.getBuilder();

        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the FRANCHISEE Portal!",this, 400);
        builder.createTakeInNewJobsButton(this, buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(generateReportButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(specifySpareParts);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(createCustomerAccountsButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(alterCustomerAccountsButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(this, buttonWidth);

        // positioning the components

        generateReportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateReportButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        specifySpareParts.setAlignmentX(Component.CENTER_ALIGNMENT);
        specifySpareParts.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        createCustomerAccountsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createCustomerAccountsButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        alterCustomerAccountsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        alterCustomerAccountsButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS

        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Generate reports
            }
        });

        specifySpareParts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Specify spare parts (GUI creator)
                cl.show(containerPanel,"add part");
            }
        });

        createCustomerAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Create customer accounts
                cl.show(containerPanel,"customer creation form");
            }
        });

        alterCustomerAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Alter customer accounts
                cl.show(containerPanel,"view customer accounts");
            }
        });
    }
}
