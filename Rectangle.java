package javiergs.gui.paint.gamma;

import java.awt.*;

public class Rectangle extends Shape {

    public Rectangle(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawRect(getX(), getY(), getWidth(), getHeight());
        }
    }
}
