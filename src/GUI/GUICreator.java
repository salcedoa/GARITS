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

    public JLabel createMenuTitle(String message, int width) {
        JLabel menuTitle = new JLabel(message);
        target.add(menuTitle);
        menuTitle.setMaximumSize(new Dimension(width,100));
        menuTitle.setFont(new Font("Verdana", Font.BOLD, 18));
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        return menuTitle;
    }
}
