package GUI;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import actors.GameMaster;

public class ControllerPanel {
	
	JPanel buttonPanel = new JPanel();
	
	
	public void createButtons() {
		
		JButton north = new JButton("North");
		JButton west = new JButton("West");
		JButton east = new JButton("East");
		JButton south = new JButton("South");
	
		north.setActionCommand("N");
		north.addActionListener(GameMaster.getInstance());
		
		west.setActionCommand("W");
		west.addActionListener(GameMaster.getInstance());
		
		east.setActionCommand("E");
		east.addActionListener(GameMaster.getInstance());
		
		south.setActionCommand("S");
		south.addActionListener(GameMaster.getInstance());

		this.buttonPanel.setPreferredSize(new Dimension(800,100));
		this.buttonPanel.setLayout(null);
		this.buttonPanel.add(north);
		this.buttonPanel.add(west);
		this.buttonPanel.add(east);
		this.buttonPanel.add(south);
		north.setBounds(85, 10, 60, 30);
		west.setBounds(35, 40, 60, 30);
		east.setBounds(135, 40, 60, 30);
		south.setBounds(85, 70, 60, 30);

	}
	
	public JComponent getControllerPanel() {
		return buttonPanel;
	}

}
