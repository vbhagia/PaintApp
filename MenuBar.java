package javiergs.gui.paint.gamma;
import javax.swing.*;


public class MenuBar extends JMenuBar{
    public MenuBar(String name){
       JMenu menu = new JMenu(name);
       menu.add(new StatusMenu("Status Options"));
       menu.add(new ToolMenu("Tool Options"));
       add(menu);
    }
}
