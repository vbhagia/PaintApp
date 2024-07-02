package javiergs.gui.paint.gamma;

import java.awt.*;

public class ArcOutline extends Shape {

    public ArcOutline(){
    }

    public ArcOutline(int x, int y, int width, int height, Color color, String shapeName){
        super(x, y, width, height, color, shapeName);
    }

    @Override
    public void draw(Graphics g) {
        if ((getWidth() != 0) && (getHeight() != 0)) {
            g.setColor(getColor());
            g.drawArc(getX(), getY(), getWidth(), getHeight(), 0, 180);
        }
    }
}
