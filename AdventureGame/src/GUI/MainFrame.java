package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame {
	buttonPanel buttonpanel = new buttonPanel();

	public MainFrame() {
		setTitle("Maze Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/**
		 * Sizing and centering app frame.
		 */
		int x = 0, y = 0, width = 800, height = 600;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		x = (int) ((d.getWidth() - width) / 2);
		y = (int) ((d.getHeight() - height) / 2);
		setBounds(x, y, width, height);

		createMenuBar();
		buttonpanel.createButtons();
		getContentPane().add(buttonpanel.getbuttonPanel());
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		JMenu menuFile2 = new JMenu("Figure");
		JMenu menuFile3 = new JMenu("Help");
		JMenu menuFile4 = new JMenu("Author");
		menuFile.add(MenuItemFactory.createMenuItem("Open...", 'o', "file_open"));
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
