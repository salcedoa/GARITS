package GUI;

import main.GARITS;

import javax.swing.*;

public class StockControlMenu extends JPanel {
    private GUICreator builder;

    private static final JButton checkStockButon = new JButton("CHECK STOCK");
    private static final JButton manageStockButton = new JButton("MANAGE STOCK");

    private int buttonWidth = 240;
    private int buttonHeight = 50;

    public StockControlMenu(GARITS garits){
        builder = garits.getBuilder();

        // setting up a box layout that aligns all the components vertically
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        builder.createMenuTitle("Stock Control System!",this,400);
//        builder.create


    }
}
