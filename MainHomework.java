package javiergs.gui.paint.gamma;

import javax.swing.*;

/** @author Nashali Vicente Lopez **/
public class MainHomework extends JFrame {

	public static void main(String[] args) {
		MainHomework app = new MainHomework();
		app.setSize(800, 600);
		app.setTitle("PaintApp");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		app.setVisible(true);
	}

	public MainHomework() {
		JPanel drawPanel = new DrawPanel();
		MouseNanny mouseNanny = new MouseNanny();
		drawPanel.addMouseListener(mouseNanny);
		drawPanel.addMouseMotionListener(mouseNanny);
		Officer.setDrawPanel(drawPanel);

		JMenuBar menuBar = new JMenuBar();

		FileMenu fileMenu = new FileMenu();
		StatusMenu statusMenu = new StatusMenu("Status");
		ToolMenu toolMenu = new ToolMenu();

		menuBar.add(fileMenu);
		menuBar.add(statusMenu);
		menuBar.add(toolMenu);

		setJMenuBar(menuBar);
		add(drawPanel);
	}
}
