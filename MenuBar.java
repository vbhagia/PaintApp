package javiergs.gui.paint.gamma;
import javax.swing.*;

/** @author Nashali Vicente Lopez**/

public class MenuBar extends JMenuBar{
    public MenuBar(){
        StatusMenu statusMenu = new StatusMenu("Status");
        ToolMenu toolMenu = new ToolMenu();

        add(statusMenu);
        add(toolMenu);

    }
}
