package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FileMenu extends JMenu implements ActionListener {
    private final JFrame parent;

    public FileMenu(String title, JFrame parent) {
        super(title);
        this.parent = parent;

        JMenuItem loadItem = new JMenuItem("Load");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem aboutItem = new JMenuItem("About Me");

        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        aboutItem.addActionListener(this);

        add(loadItem);
        add(saveItem);
        addSeparator();
        add(aboutItem);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Load")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(parent);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    Officer.clear();
                    FileHandler.load(Officer.getDrawPanel(), file);
                    Officer.tellYourBoss();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(parent, "Error loading file: " + ex.getMessage());
                }
            }
        } else if (command.equals("Save")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(parent);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    FileHandler.save(Officer.getDrawPanel(), file);
                    JOptionPane.showMessageDialog(parent, "File saved successfully.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(parent, "Error saving file: " + ex.getMessage());
                }
            }
        } else if (command.equals("About Me")) {
            AboutMe.show(parent);
        }
    }
}
