package GUI;

import java.awt.Color;

import javax.swing.JPanel;

public class MapPanel {
	
	JPanel mapPanel=new JPanel();
	
	MapPanel(){
		mapPanel.setBackground(Color.BLACK);
	}
	
	public JPanel getMapPanel(){
		return mapPanel;
		
	}
	
	
}
