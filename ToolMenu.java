package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Stack;

public class ToolMenu extends JMenuBar{
    public ToolMenu(){
        ActionNanny actionNanny = new ActionNanny();

        JMenu Colors = new JMenu("Colors");
        JMenu Shapes = new JMenu("Shapes");

        JRadioButtonMenuItem blk = new JRadioButtonMenuItem("Black");
        blk.addActionListener(actionNanny);
        JRadioButtonMenuItem r = new JRadioButtonMenuItem("Red");
        r.addActionListener(actionNanny);
        JRadioButtonMenuItem b = new JRadioButtonMenuItem("Blue");
        b.addActionListener(actionNanny);
        JRadioButtonMenuItem g = new JRadioButtonMenuItem("Green");
        g.addActionListener(actionNanny);
        JRadioButtonMenuItem y = new JRadioButtonMenuItem("Yellow");
        y.addActionListener(actionNanny);
        JRadioButtonMenuItem o = new JRadioButtonMenuItem("Orange");
        o.addActionListener(actionNanny);
        JRadioButtonMenuItem p = new JRadioButtonMenuItem("Pink");
        p.addActionListener(actionNanny);

        Colors.add(blk);
        Colors.add(r);
        Colors.add(b);
        Colors.add(g);
        Colors.add(y);
        Colors.add(o);
        Colors.add(p);

        JCheckBoxMenuItem rect = new JCheckBoxMenuItem("Rectangle");
        rect.addActionListener(actionNanny);
        JCheckBoxMenuItem circle = new JCheckBoxMenuItem("Circle");
        circle.addActionListener(actionNanny);
        JCheckBoxMenuItem arc = new JCheckBoxMenuItem("Arc");
        arc.addActionListener(actionNanny);

        Shapes.add(rect);
        Shapes.add(circle);
        Shapes.add(arc);

        add(Shapes);
        add(Colors);

    }
}
