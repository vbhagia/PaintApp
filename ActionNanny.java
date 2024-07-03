package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionNanny listens for action events.
 * Send information to Officer.
 *
 * @author javiergs
 * @version 2.0
 */
public class ActionNanny implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButtonMenuItem colorBox) {
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
			}
		} else if (e.getSource() instanceof JCheckBoxMenuItem) {
			Officer.setShape(e.getActionCommand());
		} else if (e.getActionCommand().equals("Undo")) {
			Officer.undo();
		} else if (e.getActionCommand().equals("Redo")) {
			Officer.redo();
		} else if (e.getActionCommand().equals("Clear")) {
			Officer.clear();
		}
	}
}

