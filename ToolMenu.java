package javiergs.gui.paint.gamma;

import javax.swing.*;

/** @author Nashali Vicente Lopez**/

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

        ButtonGroup buttongroup = new ButtonGroup();
        buttongroup.add(blk);
        buttongroup.add(r);
        buttongroup.add(b);
        buttongroup.add(g);
        buttongroup.add(y);
        buttongroup.add(o);
        buttongroup.add(p);

        Colors.add(blk);
        Colors.add(r);
        Colors.add(b);
        Colors.add(g);
        Colors.add(y);
        Colors.add(o);
        Colors.add(p);

        JRadioButtonMenuItem rect = new JRadioButtonMenuItem("Rectangle");
        rect.addActionListener(actionNanny);
        JRadioButtonMenuItem circle = new JRadioButtonMenuItem("Circle");
        circle.addActionListener(actionNanny);
        JRadioButtonMenuItem arc = new JRadioButtonMenuItem("Arc");
        arc.addActionListener(actionNanny);

        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(rect);
        shapeGroup.add(circle);
        shapeGroup.add(arc);

        Shapes.add(rect);
        Shapes.add(circle);
        Shapes.add(arc);

        add(Shapes);
        add(Colors);

    }
}
