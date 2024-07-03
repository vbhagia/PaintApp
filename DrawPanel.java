package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;

/**
 * DrawPanel creates a panel where the drawing is done.
 * According to the data in Officer.
 *
 * @author javiergs
 * @version 3.0
 */
public class DrawPanel extends JPanel {

	public DrawPanel() {
		setBackground(new Color(176, 250, 192));
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("Telling boss to repaint");
		super.paintComponent(g);
		g.setColor(new Color(176, 250, 192));
		g.fillRect(0, 0, getWidth(), getHeight());

		for (Shape shape : Officer.getShapeStack()) {
			if (shape instanceof ClearAction) {
				g.setColor(new Color(176, 250, 192));
				g.fillRect(0, 0, getWidth(), getHeight());
			} else {
				shape.draw(g);
			}
		}

		if (Officer.getShape().equals("Rectangle")) {
			Officer.getRectOutline().draw(g);
		} else if (Officer.getShape().equals("Circle")) {
			Officer.getCircleOutline().draw(g);
		} else if (Officer.getShape().equals("Arc")) {
			Officer.getArcOutline().draw(g);
		}
	}
}
