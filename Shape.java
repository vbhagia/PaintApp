package javiergs.gui.paint.gamma;

import java.awt.*;

public class Shape {
    private String shapeName;
    private Color color;
    private int x;
    private int y;
    private int width;
    private int height;

    public Shape() {
    }

    public Shape (int xin, int yin, int widthin, int heightin, Color colorin, String namein){
        shapeName = namein;
        color = colorin;
        x = xin;
        y = yin;
        width = widthin;
        height = heightin;
    }

    public void draw(Graphics g) {
        System.out.println("Shape draw");
    }

    public Color getColor() {
        return color==null?Color.BLACK:color;
    }

    public void setColor(Color colorIn) {
        color = colorIn;
    }

    public String getShape() {
        return shapeName==null?"Rectangle":shapeName;
    }

    public void setShape(String shape) {
        shapeName = shape;
    }

    public int getX() {
        return x;
    }

    public void setX(int xIn) {
        x = xIn;
    }

    public int getY() {
        return y;
    }

    public void setY(int yIn) {
        y = yIn;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int widthIn) {
        width = widthIn;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int heightIn) {
        height = heightIn;
    }
}
