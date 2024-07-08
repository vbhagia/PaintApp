package javiergs.gui.paint.gamma;

import javax.swing.*;

/** @author Veer Bhagia **/
public class FileMenu extends JMenuBar {
    public FileMenu() {
        ActionNanny actionNanny = new ActionNanny();

        JMenu fileMenu = new JMenu("File");

        JMenuItem saveButton = new JMenuItem("Save");
        saveButton.addActionListener(actionNanny);
        JMenuItem loadButton = new JMenuItem("Load");
        loadButton.addActionListener(actionNanny);

        fileMenu.add(saveButton);
        fileMenu.add(loadButton);

        // Add the fileMenu to the menu bar
        add(fileMenu);
    }
}
