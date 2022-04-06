package GUI;

import main.GARITS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MechanicMenu extends JPanel {
    private GARITS garits;
    private GUICreator builder;
    // TODO: shows list of available jobs taken from database

    public MechanicMenu(GARITS garits) {
        builder = garits.getBuilder();
        builder.createMenuTitle("Mechanic Portal", this,200);
    }
}
