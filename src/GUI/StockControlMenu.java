package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockControlMenu extends JPanel {
    private GUICreator builder;

    private static final JButton checkStockButton = new JButton("CHECK STOCK");
    private static final JButton manageStockButton = new JButton("MANAGE STOCK");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public StockControlMenu(GARITS garits){
        builder = garits.getBuilder();

        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        builder.createMenuTitle("Stock Control System!",this,250);
        builder.createCheckStockButton(this,buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        builder.createManageStockButton(this,buttonWidth);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        builder.createReturnButton(this,buttonWidth);

        //positioning components
        checkStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkStockButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));

        manageStockButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageStockButton.setMaximumSize(new Dimension(buttonWidth,buttonHeight));



        //Button Functions

        checkStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: View job progress
            }
        });

        manageStockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: View job progress
            }
        });

    }
}
