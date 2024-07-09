package javiergs.gui.paint.gamma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import java.io.File;
import java.io.IOException;

/** @author Grant Robinson
 *  @author Nashali Vincente Lopez **/

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
		} else if (e.getActionCommand().equals("About Me")) {
			showAbout();
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

	private void showAbout() {
		String aboutMessage = "This is a simple paint application. \n\n"
				+ "Instructions:\n"
				+ "1. Choose a color from the 'Status' menu.\n"
				+ "2. Select a shape from the 'Tool' menu.\n"
				+ "3. Click and drag on the drawing area to draw the selected shape.\n"
				+ "4. Use 'Undo' and 'Redo' to correct mistakes.\n"
				+ "5. Use 'Clear' to clear the drawing area.\n"
				+ "6. Use 'Save' to save your drawing to a file.\n"
				+ "7. Use 'Load' to load a previously saved drawing.";
		JOptionPane.showMessageDialog(null, aboutMessage, "About PaintApp", JOptionPane.INFORMATION_MESSAGE);
	}
}

