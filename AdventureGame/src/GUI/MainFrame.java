package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	public MainFrame() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		MapPanel map= new MapPanel();
		ControllerPanel controller = new ControllerPanel();
		
		this.setTitle("Maze Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);				//sizing app frame
		this.setLocation((d.width - getSize().width) / 2, (d.height - getSize().height) / 2);		//centering app frame
		this.setBackground(Color.BLACK);
		this.getContentPane().setLayout(new BorderLayout());
	
		createMenuBar();
		controller.createButtons();
		getContentPane().add(map.getMapPanel());
		getContentPane().add(controller.getControllerPanel(),BorderLayout.PAGE_END);
		
		/*
		//test		
		JInternalFrame inFrame1 = new JInternalFrame("Dokument 1", true, true, true, true);
		inFrame1.setSize(200,200);
		inFrame1.setLocation(0, 0);
		inFrame1.show();
		
		getContentPane().add(inFrame1);
		*/

		
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenu menuFile2 = new JMenu("Figure");
		JMenu menuFile3 = new JMenu("Help");
		JMenu menuFile4 = new JMenu("Author");
		
		menuFile.add(MenuItemFactory.createMenuItem("Open Raumaufbau.txt...", 'o', "open_map"));
		menuFile.add(MenuItemFactory.createMenuItem("Save...", 's', "file_save"));
		menuFile.add(MenuItemFactory.createMenuItem("Quit...", 'q', "file_close"));
		menuFile2.add(MenuItemFactory.createMenuItem("Open...", 'o', "figure_open"));
		
		menuBar.add(menuFile);
		menuBar.add(menuFile2);
		menuBar.add(menuFile3);
		menuBar.add(menuFile4);
		setJMenuBar(menuBar);
	}
	
}
