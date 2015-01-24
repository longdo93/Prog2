package GUI;

import input.ImageReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dungeon.Room;
import actors.GameMaster;

public class MapPanel {
	
	private static MapPanel instance;
	
	static final int X = 9;
	static final int Y = 7;
	boolean east;
	boolean west;
	boolean north;
	boolean south;
	JLabel map[][]=new JLabel[Y][X];
	
	
	public static MapPanel getInstance() {
		if (instance == null) {
			instance = new MapPanel();
		}
		return instance;
	}
	
	JPanel mapPanel = new JPanel(new GridLayout(Y, X));
	
	private MapPanel() {
		mapPanel.setBackground(Color.BLACK);
		mapPanel.setBorder(BorderFactory.createLineBorder(Color.red));
		mapPanel.setPreferredSize(new Dimension(765, 595));
		createJLabels();
		
	}
	
	public JPanel getMapPanel(){
		return mapPanel;
		
	}
	
	private void createJLabels() {
		

		
		for (int i = 0; i < this.Y; i++) {
			for (int j = 0; j < this.X; j++) {
				JLabel label = new JLabel();
				label.setBorder(BorderFactory.createLineBorder(Color.white));
				map[i][j]=label;
				mapPanel.add(label);
			}
			
		}
			
	}
	
	public void drawMap() {
	
		Vector<Room> roomCache = null;
		if (GameMaster.getInstance().getLabyrinth() != null) {
		 roomCache= GameMaster.getInstance().getLabyrinth();
		}
		
		int y=0;
		int x=0;

		ImageReader.getInstance().setImage(map[0][0]);
		for (int i = 0; i < roomCache.size(); i++) {
			
			if (!roomCache.elementAt(i).getN().equals("0")) {
				if(y>0){
				ImageReader.getInstance().setImage(map[y-1][x]);
				north=true;
				}if(y==0){
					ImageReader.getInstance().setImage(map[y][x]);
				}
			}
			else{
				north=false;
				}
			
			if (!roomCache.elementAt(i).getE().equals("0")) {
				ImageReader.getInstance().setImage(map[y][x+1]);
				this.east=true;

			}
			else{
				this.east=false;
			}
			
			if (!roomCache.elementAt(i).getS().equals("0")) {
				ImageReader.getInstance().setImage(map[y+1][x]);
				System.out.println("paintsouth");
				south=true;
			}
			else{
				south=false;
			}

			if (!roomCache.elementAt(i).getW().equals("0")) {
				 if(east==false){
				ImageReader.getInstance().setImage(map[y][x-1]);
				west=true;
				 }else if(east==true){
					 west=true;
						ImageReader.getInstance().setImage(map[y][x]); 
				 }
			}
			else{
				  west=false;
				 }
			if(north==true && south==false){
				y--;
			}
			if ( east==true){
				x++;			
			}
			if ( east==true&&west==false&&south==false&&north==false){
				x--;
			}
			if(south==true){
				y++;
			}
		}

	}
	

}

