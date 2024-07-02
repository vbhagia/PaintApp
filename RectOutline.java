package javiergs.gui.paint.gamma;

import java.awt.*;

public class RectOutline extends Shape {

    public RectOutline(){
    }

    public RectOutline(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawRect(getX(), getY(), getWidth(), getHeight());
        }
    }
}