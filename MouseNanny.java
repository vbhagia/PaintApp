package javiergs.gui.paint.gamma;

import java.awt.event.*;

public class MouseNanny implements MouseListener, MouseMotionListener {
	int tmpx, tmpy;

	public void mousePressed(MouseEvent e) {
		tmpx = e.getX();
		tmpy = e.getY();
	}

	public void mouseReleased(MouseEvent e){
		int[] p = Officer.getShapeParameters();
		if (Officer.getShape().equals("Rectangle")) {
			Officer.getShapeStack().push(new Rectangle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Circle")) {
			Officer.getShapeStack().push(new Circle(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Arc")) {
			Officer.getShapeStack().push(new Arc(p[0], p[1], p[2], p[3], Officer.getColor(), Officer.getShape()));
		} else {
			System.out.println("Bad Shape name");
		}
		Officer.clearShapeParameters();
		Officer.tellYourBoss();
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int[] p = calculateShapeParameters(x, y);
		Officer.setShapeParameters(p);
		Officer.tellYourBoss();
	}

	private int[] calculateShapeParameters(int x, int y) {
		int[] parameters = new int[4];
		if ((x - tmpx) > 0) {
			parameters[0] = tmpx;
			parameters[2] = x - tmpx;
		} else {
			parameters[0] = x;
			parameters[2] = tmpx - x;
		}

		if ((y - tmpy) > 0) {
			parameters[1] = tmpy;
			parameters[3] = y - tmpy;
		} else {
			parameters[1] = y;
			parameters[3] = tmpy - y;
		}
		return parameters;
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}