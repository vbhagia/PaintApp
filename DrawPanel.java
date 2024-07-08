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
			int[] p = Officer.getShapeParameters();
			Rectangle rect = new Rectangle(p[0], p[1], p[2], p[3], Officer.getColor(), "Rectangle");
			rect.drawOutline(g);
		} else if (Officer.getShape().equals("Circle")) {
			int[] p = Officer.getShapeParameters();
			Circle circ = new Circle(p[0], p[1], p[2], p[3], Officer.getColor(), "Circle");
			circ.drawOutline(g);
		} else if (Officer.getShape().equals("Arc")) {
			int[] p = Officer.getShapeParameters();
			Arc arc = new Arc(p[0], p[1], p[2], p[3], Officer.getColor(), "Arc");
			arc.drawOutline(g);
		} else if (Officer.getShape().equals("Line")) {
			int[] p = Officer.getShapeParameters();
			Line line = new Line(p[0], p[1], p[2], p[3], Officer.getColor(), "Line");
			line.drawOutline(g);
		}
	}
}
