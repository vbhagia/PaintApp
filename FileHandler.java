package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

/** @author Veer Bhagia **/

public class FileHandler {

    public static void save(JPanel drawPanel, File file) throws IOException {
        // Create a BufferedImage object
        BufferedImage image = new BufferedImage(drawPanel.getWidth(), drawPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        drawPanel.paint(g2);
        g2.dispose();

        // Save the BufferedImage to the specified file
        ImageIO.write(image, "png", file);
    }

    public static void load(JPanel drawPanel, File file) throws IOException {
        clearPanel(drawPanel);
        BufferedImage image = ImageIO.read(file);

        Graphics g = drawPanel.getGraphics();
        g.drawImage(image, 0, 0, drawPanel.getWidth(), drawPanel.getHeight(), null);
        g.dispose();
    }

    private static void clearPanel(JPanel drawPanel) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(drawPanel.getBackground());
        g.fillRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
        g.dispose();
    }
}

