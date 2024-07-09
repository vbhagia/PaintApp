package javiergs.gui.paint.gamma;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileHandler {

    public static void save(JPanel drawPanel, File file) throws IOException {
        BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        drawPanel.paint(g2);
        g2.dispose();
        ImageIO.write(image, "png", file);
    }

    public static void load(JPanel drawPanel, File file) throws IOException {
        BufferedImage image = ImageIO.read(file);

        Graphics g = drawPanel.getGraphics();
        g.drawImage(image, 0, 0, drawPanel.getWidth(), drawPanel.getHeight(), null);
        g.dispose();
    }
}
