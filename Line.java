package javiergs.gui.paint.gamma;
import java.awt.*;
/**@author Nashali Vicente Lopez**/
public class Line extends Shape{
    public Line(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawLine(getX(), getY(), getX() + getWidth(), getY() + getHeight());
        }
    }

    @Override
    public void drawOutline(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawLine(getX(), getY(), getX() + getWidth(), getY() + getHeight());
        }
    }
}
