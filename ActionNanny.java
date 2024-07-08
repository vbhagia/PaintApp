package javiergs.gui.paint.gamma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import java.io.File;
import java.io.IOException;

public class ActionNanny implements ActionListener {
	public ActionNanny() {
	}

	public void actionPerformed(ActionEvent e) {
		Object var3 = e.getSource();
		if (var3 instanceof JRadioButtonMenuItem colorBox) {
			if (colorBox.getActionCommand().equals("Black")) {
				Officer.setColor(Color.BLACK);
			} else if (colorBox.getActionCommand().equals("Red")) {
				Officer.setColor(Color.RED);
			} else if (colorBox.getActionCommand().equals("Blue")) {
				Officer.setColor(Color.BLUE);
			} else if (colorBox.getActionCommand().equals("Green")) {
				Officer.setColor(Color.GREEN);
			} else if (colorBox.getActionCommand().equals("Yellow")) {
				Officer.setColor(Color.YELLOW);
			} else if (colorBox.getActionCommand().equals("Orange")) {
				Officer.setColor(Color.ORANGE);
			} else if (colorBox.getActionCommand().equals("Pink")) {
				Officer.setColor(Color.PINK);
			} else if (colorBox.getActionCommand().equals("Rectangle")) {
				Officer.setShape("Rectangle");
			} else if (colorBox.getActionCommand().equals("Circle")) {
				Officer.setShape("Circle");
			} else if (colorBox.getActionCommand().equals("Arc")) {
				Officer.setShape("Arc");
			} else if (colorBox.getActionCommand().equals("Line")) {
				Officer.setShape("Line");
			}
		} else if (e.getActionCommand().equals("Undo")) {
			Officer.undo();
		} else if (e.getActionCommand().equals("Redo")) {
			Officer.redo();
		} else if (e.getActionCommand().equals("Clear")) {
			Officer.clear();
		} else if (e.getActionCommand().equals("Save")) {
			save();
		} else if (e.getActionCommand().equals("Load")) {
			load();
		}
	}

	private void save() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showSaveDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				FileHandler.save(Officer.getDrawPanel(), file);
				JOptionPane.showMessageDialog(null, "File saved successfully.");
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
			}
		}
	}

	private void load() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				FileHandler.load(Officer.getDrawPanel(), file);
				JOptionPane.showMessageDialog(null, "File loaded successfully.");
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "Error loading file: " + ex.getMessage());
			}
		}
	}
}

