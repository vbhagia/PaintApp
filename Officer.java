package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

/** @author Nashali Vicente Lopez **/
/** @author Grant Robinson **/
/** @author Veer Bhagia **/

public class Officer {
	private static Color color;
	private static String shape;
	private static JPanel drawPanel;
	private static Stack<Shape> shapes = new Stack<>();
	private static Stack<Shape> undoneShapes = new Stack<>();
	private static int[] shapeParameters = new int[4];
	private static Shape selectedShape = new Shape();
	private static Shape shapeCopy = new Shape();
	private static Shape shapePaste = new Shape();
	private static final int COPY_OFFSET = 10;

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

	public static JPanel getDrawPanel() {
		return drawPanel;
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

	public static void setSelectedShape(Shape s) {
		selectedShape = s;
		System.out.println("setSelectedShape " + selectedShape.getShape() + " width: " + selectedShape.getWidth() + " height: " + selectedShape.getHeight());
	}

	public static Shape getSelectedShape() {
		System.out.println("getSelectedShape");
		return selectedShape;
	}

	public static void copyShape(Shape s) {
		if (s != null) {
			if ((s.getWidth() > 0) && (s.getHeight() > 0)) {
				if (Officer.getShape().equals("Rectangle")) {
					shapeCopy = new Rectangle(s.getX(), s.getY(),
							s.getWidth(), s.getHeight(), s.getColor(), s.getShape());
				} else if (Officer.getShape().equals("Circle")) {
					shapeCopy = new Circle(s.getX(), s.getY(),
							s.getWidth(), s.getHeight(), s.getColor(), s.getShape());
				} else if (Officer.getShape().equals("Arc")) {
					shapeCopy = new Arc(s.getX(), s.getY(),
							s.getWidth(), s.getHeight(), s.getColor(), s.getShape());
				} else if (Officer.getShape().equals("Line")) {
					shapeCopy = new Line(s.getX(), s.getY(),
							s.getWidth(), s.getHeight(), s.getColor(), s.getShape());
				}
			}
		}
	}

	public static void pasteShape() {
		if (shapeCopy != null) {
			if (Officer.getShape().equals("Rectangle")) {
				shapePaste = new Rectangle(shapeCopy.getX() + COPY_OFFSET, shapeCopy.getY() + COPY_OFFSET,
						shapeCopy.getWidth(), shapeCopy.getHeight(), shapeCopy.getColor(), shapeCopy.getShape());
			} else if (Officer.getShape().equals("Circle")) {
				shapePaste = new Circle(shapeCopy.getX() + COPY_OFFSET, shapeCopy.getY() + COPY_OFFSET,
						shapeCopy.getWidth(), shapeCopy.getHeight(), shapeCopy.getColor(), shapeCopy.getShape());
			} else if (Officer.getShape().equals("Arc")) {
				shapePaste = new Arc(shapeCopy.getX() + COPY_OFFSET, shapeCopy.getY() + COPY_OFFSET,
						shapeCopy.getWidth(), shapeCopy.getHeight(), shapeCopy.getColor(), shapeCopy.getShape());
			} else if (Officer.getShape().equals("Line")) {
				shapePaste = new Line(shapeCopy.getX() + COPY_OFFSET, shapeCopy.getY() + COPY_OFFSET,
						shapeCopy.getWidth(), shapeCopy.getHeight(), shapeCopy.getColor(), shapeCopy.getShape());
			}
		}
		if (shapePaste != null) {
			shapeCopy.setX(shapeCopy.getX() + COPY_OFFSET);
			shapeCopy.setY(shapeCopy.getY() + COPY_OFFSET);
			getShapeStack().push(shapePaste);
			Officer.tellYourBoss();
		}
	}
}
