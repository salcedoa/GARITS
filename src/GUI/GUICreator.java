package GUI;

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

    private JPanel target;
    public GUICreator(JPanel target) {
        this.target = target;
    }

    // BUTTONS

    // seen in all role menus
    public JButton createCloseButton(int width) {
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
    public JButton createTakeInNewJobsButton(int width) {
        JButton newJobsButton = new JButton("TAKE IN NEW JOBS");
        target.add(newJobsButton);
        newJobsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        newJobsButton.setMaximumSize(new Dimension(width,50));

        newJobsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: TAKE IN NEW JOB
            }
        });

        return newJobsButton;
    }

    // used by Franchisee and Receptionist
    public JButton createCustomerAccountButton(int width) {
        JButton button = new JButton("CREATE CUSTOMER RECORD");
        target.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(width,50));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: CREATE CUSTOMER RECORD MENU
            }
        });

        return button;
    }

    // used by Receptionist
    public JButton createStockControlButton(int width) {
        JButton stockControlButton = new JButton("STOCK CONTROL");
        target.add(stockControlButton);
        stockControlButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        stockControlButton.setMaximumSize(new Dimension(width,50));

        stockControlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Stock control control panel shows up
            }
        });

        return stockControlButton;
    }

    // LABELS

    public JLabel createMenuTitle(String message, int width) {
        JLabel menuTitle = new JLabel(message);
        target.add(menuTitle);
        menuTitle.setMaximumSize(new Dimension(width,100));
        menuTitle.setFont(new Font("Verdana", Font.BOLD, 18));
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        return menuTitle;
    }
}
