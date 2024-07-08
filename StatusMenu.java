package javiergs.gui.paint.gamma;
import javax.swing.*;

/** @author Nashali Vicente Lopez**/


public class StatusMenu extends JMenuBar {
    public StatusMenu(String name) {
        JMenu status = new JMenu(name);

        ActionNanny actionNanny = new ActionNanny();

        JMenuItem redoButton = new JMenuItem("Redo");
        redoButton.addActionListener(actionNanny);

        JMenuItem undoButton = new JMenuItem("Undo");
        undoButton.addActionListener(actionNanny);

        JMenuItem clearButton = new JMenuItem("Clear");
        clearButton.addActionListener(actionNanny);

        status.add(redoButton);
        status.add(undoButton);
        status.add(clearButton);

        add(status);
    }
}
