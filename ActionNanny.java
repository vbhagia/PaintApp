package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** @author Nashali Vicente **/
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
			} else if (colorBox.getActionCommand().equals("Rectangle")){
				Officer.setShape("Rectangle");
			} else if (colorBox.getActionCommand().equals("Circle")){
				Officer.setShape("Circle");
			} else if (colorBox.getActionCommand().equals("Arc")){
				Officer.setShape("Arc");
			}
		} else if (e.getActionCommand().equals("Undo")) {
			Officer.undo();
		} else if (e.getActionCommand().equals("Redo")) {
			Officer.redo();
		} else if (e.getActionCommand().equals("Erase")) {
			Officer.clear();
		}
	}
}
