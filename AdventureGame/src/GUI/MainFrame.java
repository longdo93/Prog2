package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public MainFrame() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		MapPanel map = MapPanel.getInstance();
		ControllerPanel controller = new ControllerPanel();
		
		this.setTitle("Maze Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(10*85, 8*85);				//sizing app frame
		this.setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);		//centering app frame
		this.setBackground(Color.BLACK);
		this.getContentPane().setLayout(new BorderLayout());
	
		createMenuBar();
		controller.createButtons();
		getContentPane().add(map.getMapPanel());
		getContentPane().add(controller.getControllerPanel(),BorderLayout.PAGE_END);

		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");

		JMenu menuFile3 = new JMenu("Help");
		JMenu menuFile4 = new JMenu("Author");
		
		menuFile.add(MenuItemFactory.createMenuItem("Open Raumaufbau.txt...", 'o', "open_map"));
		menuFile.add(MenuItemFactory.createMenuItem("Open Spielfigur (gif oder jpg-Datei)...", 'o', "figure_open"));
		
		menuBar.add(menuFile);
		menuBar.add(menuFile3);
		menuBar.add(menuFile4);
		setJMenuBar(menuBar);
	}
	
}
