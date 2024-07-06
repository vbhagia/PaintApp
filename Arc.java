package javiergs.gui.paint.gamma;

import java.awt.*;

public class Arc extends Shape {

    public Arc(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.fillArc(getX(), getY(), getWidth(), getHeight(), 0, 180);
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawArc(getX(), getY(), getWidth(), getHeight(), 0, 180);
        }
    }
}
