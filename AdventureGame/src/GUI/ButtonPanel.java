/**
longdo
*/
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import actors.GameMaster;
import actors.Player;

public class ButtonPanel {

	private JPanel buttonPanel;
	GameMaster gm=new GameMaster();
	Player player=new Player();
	private JButton b1 = new JButton("North");
	private JButton b2 = new JButton("West");
	 private JButton b3 = new JButton("East");
	private JButton b4 = new JButton("South");

	public void createButtons() {

		buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		b1.setBounds(85, 435, 60, 30);
		b2.setBounds(35, 465, 60, 30);
		b3.setBounds(135, 465, 60, 30);
		b4.setBounds(85, 495, 60, 30);
	}
	
	public void createButtonListeners(){
		this.b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("N");
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("W");
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("E");
				gm.movePlayer(player.getDirection());
				}
		});
		
		this.b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				player.setDirection("S");
				gm.movePlayer(player.getDirection());
				}
		});
		
	}

	public JComponent getbuttonPanel() {
		return buttonPanel;
	}
	

}