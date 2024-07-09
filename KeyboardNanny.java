package javiergs.gui.paint.gamma;

import java.awt.event.*;

/** @author Grant Robinson **/

public class KeyboardNanny implements KeyListener {

    private void onCtrlC() {
        Officer.copyShape(Officer.getSelectedShape());
        System.out.println("Ctrl+c");
    }

    private void onCtrlV() {
        Officer.pasteShape();
        System.out.println("Ctrl+v");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            if (e.getKeyCode() == KeyEvent.VK_C) {
                onCtrlC();
            } else if (e.getKeyCode() == KeyEvent.VK_V) {
                onCtrlV();
            }
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
}
