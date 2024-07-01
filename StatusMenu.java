package javiergs.gui.paint.gamma;

import javax.swing.*;

public class StatusMenu extends JMenu{
    public StatusMenu(String name){
        JLabel statusLabel = new JLabel(name);

        ActionNanny actionNanny = new ActionNanny();

        JMenuItem redoButton =  new JMenuItem("Redo");
        redoButton.addActionListener(actionNanny);

        JMenuItem undoButton = new JMenuItem("Undo");
        undoButton.addActionListener(actionNanny);

        JMenuItem eraseButton = new JMenuItem("Erase");
        eraseButton.addActionListener(actionNanny);

        add(statusLabel);
        add(redoButton);
        add(undoButton);
        add(eraseButton);
    }
}
