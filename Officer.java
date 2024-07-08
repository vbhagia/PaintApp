package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/**
 * Officer is a class that holds the data of the drawing application.
 * And communicates to the DrawPanel when a repaint is needed.
 *
 * @author javiergs
 * @version 1.0
 */
public class Officer {
	private static Color color;
	private static String shape;
	private static JPanel drawPanel;
	private static Stack<Shape> shapes = new Stack<>();
	private static Stack<Shape> undoneShapes = new Stack<>();
	private static int[] shapeParameters = new int[4];

	public static Color getColor() {
		return color == null ? Color.BLACK : color;
	}

	public static void setColor(Color color) {
		Officer.color = color;
	}

	public static String getShape() {
		return shape == null ? "Rectangle" : shape;
	}

	public static void setShape(String shape) {
		Officer.shape = shape;
	}

	public static void tellYourBoss() {
		drawPanel.repaint();
		System.out.println("Tell your boss to repaint.");
	}

	public static void setDrawPanel(JPanel d) {
		drawPanel = d;
	}

	public static Stack<Shape> getShapeStack() {
		return shapes;
	}

	public static int[] getShapeParameters() {
		return shapeParameters;
	}

	public static void setShapeParameters(int[] p) {
		if (p.length != 4) {
			System.out.println("Invalid parameter input");
		} else {
			shapeParameters = p;
		}
	}

	public static void clearShapeParameters() {
		int[] p = {0, 0, 0, 0};
		shapeParameters = p;
	}

	public static void clear() {
		shapes.push(new ClearAction());
		undoneShapes.clear();
		tellYourBoss();
	}

	public static void undo() {
		if (!shapes.isEmpty()) {
			Shape lastAction = shapes.pop();
			undoneShapes.push(lastAction);
			if (lastAction instanceof ClearAction) {
				while (!shapes.isEmpty() && !(shapes.peek() instanceof ClearAction)) {
					undoneShapes.push(shapes.pop());
				}
			}
			tellYourBoss();
		}
	}

	public static void redo() {
		if (!undoneShapes.isEmpty()) {
			Shape redoAction = undoneShapes.pop();
			shapes.push(redoAction);
			if (redoAction instanceof ClearAction) {
				while (!undoneShapes.isEmpty() && !(undoneShapes.peek() instanceof ClearAction)) {
					shapes.push(undoneShapes.pop());
				}
			}
			tellYourBoss();
		}
	}
}
