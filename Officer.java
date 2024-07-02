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
	private static Stack<Shape> shapes = new Stack<Shape>();
	private static RectOutline rectOutline = new RectOutline();
	private static CircleOutline circleOutline = new CircleOutline();
	private static ArcOutline arcOutline = new ArcOutline();
	
	public static Color getColor() {
		return color==null?Color.BLACK:color;
	}
	
	public static void setColor(Color color) {
		Officer.color = color;
	}
	
	public static String getShape() {
		return shape==null?"Rectangle":shape;
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

	public static Stack<Shape> getShapeStack() { return shapes;	}

	public static void setRectOutline(RectOutline roIn) { rectOutline = roIn; }

	public static RectOutline getRectOutline() {
		return rectOutline;
	}

	public static void setCircleOutline(CircleOutline coIn) { circleOutline = coIn; }

	public static CircleOutline getCircleOutline() {
		return circleOutline;
	}

	public static void setArcOutline(ArcOutline aoIn) { arcOutline = aoIn; }

	public static ArcOutline getArcOutline() {
		return arcOutline;
	}
}