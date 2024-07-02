package javiergs.gui.paint.gamma;

import java.awt.*;

public class CircleOutline extends Shape {

    public CircleOutline(){
    }

    public CircleOutline(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawOval(getX(), getY(), getWidth(), getHeight());
        }
    }
}
