package javiergs.gui.paint.gamma;

import java.awt.event.*;

public class MouseNanny implements MouseListener, MouseMotionListener {
	int tmpx, tmpy;

	public void mousePressed(MouseEvent e) {
		tmpx = e.getX();
		tmpy = e.getY();
	}

	public void mouseReleased(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		if (Officer.getShape().equals("Rectangle")) {
			Officer.getShapeStack().push(new Rectangle(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Circle")) {
			Officer.getShapeStack().push(new Circle(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), Officer.getShape()));
		} else if (Officer.getShape().equals("Arc")) {
			Officer.getShapeStack().push(new Arc(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), Officer.getShape()));
		} else {
			System.out.println("Bad Shape name");
		}
		Officer.setRectOutline(new RectOutline(0, 0, 0, 0, Officer.getColor(), "Box"));
		Officer.setCircleOutline(new CircleOutline(0, 0, 0, 0, Officer.getColor(), "CircleOutline"));
		Officer.setArcOutline(new ArcOutline(0, 0, 0, 0, Officer.getColor(), "ArcOutline"));
		Officer.tellYourBoss();
	}

	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (Officer.getShape().equals("Rectangle")) {
			Officer.setRectOutline(new RectOutline(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), "Box"));
		} else if (Officer.getShape().equals("Circle")) {
			Officer.setCircleOutline(new CircleOutline(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), "CircleOutline"));
		} else if (Officer.getShape().equals("Arc")) {
			Officer.setArcOutline(new ArcOutline(tmpx, tmpy, x - tmpx, y - tmpy, Officer.getColor(), "ArcOutline"));
		}
		Officer.tellYourBoss();
	}

	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
}