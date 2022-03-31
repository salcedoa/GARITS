package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FranchiseeMenu extends JPanel {
    private GUICreator builder = new GUICreator(this);

    private static final JButton takeInJobButton = new JButton("TAKE IN JOB");
    private static final JButton generateReportButton = new JButton("GENERATE REPORTS");
    private static final JButton specifySpareParts = new JButton("SPECIFY SPARE PARTS");
    private static final JButton createCustomerAccountsButton = new JButton("CREATE CUSTOMER ACCOUNTS");
    private static final JButton alterCustomerAccountsButton = new JButton("ALTER CUSTOMER ACCOUNTS");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public FranchiseeMenu() {
        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // initialising components + adding spacing between buttons
        builder.createMenuTitle("Welcome to the FRANCHISEE Portal!", 400);
        this.add(takeInJobButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(generateReportButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(specifySpareParts);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(createCustomerAccountsButton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        this.add(alterCustomerAccountsButton);
        this.add(Box.createRigidArea(new Dimension(0, 20)));
        builder.createCloseButton(buttonWidth);

        // positioning the components
        takeInJobButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        takeInJobButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        generateReportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateReportButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        specifySpareParts.setAlignmentX(Component.CENTER_ALIGNMENT);
        specifySpareParts.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        createCustomerAccountsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createCustomerAccountsButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        alterCustomerAccountsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        alterCustomerAccountsButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        // BUTTON FUNCTIONS
        takeInJobButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Take in new jobs (GUI creator)
            }
        });

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
            }
        });

        createCustomerAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Create customer accounts
            }
        });

        alterCustomerAccountsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Alter customer accounts
            }
        });
    }
}
