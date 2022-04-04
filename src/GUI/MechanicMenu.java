package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MechanicMenu extends JPanel {
    private GUICreator builder = new GUICreator(this);
    // TODO: shows list of available jobs taken from database

    public MechanicMenu() {
        builder.createMenuTitle("Mechanic Portal",200);
    }
}
