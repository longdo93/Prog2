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
	JLabel map[][]=new JLabel[7][9];
	
	
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
		

		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 9; j++) {
				JLabel label = new JLabel();
				label.setBorder(BorderFactory.createLineBorder(Color.white));
				map[i][j]=label;
				mapPanel.add(label);
			}
			
		}
			
	}
	
	public void drawMap() {
		/*
		Vector<Room> roomCache = null;
		if (GameMaster.getInstance().getLabyrinth() != null) {
		 roomCache= GameMaster.getInstance().getLabyrinth();
		}
		labels.get(0).setIcon(ImageReader.getInstance().getImage());
		for (int room = 0; room < roomCache.size(); room++) {
			if (!roomCache.elementAt(room).getN().equals("0")) {
				//labels.get(room - 9).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getE().equals("0")) {
				labels.get(room + 1).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getS().equals("0")) {
				//labels.get(room +9).setIcon(ImageReader.getInstance().getImage());
			}
			if (!roomCache.elementAt(room).getW().equals("0")) {
				labels.get(room - 1).setIcon(ImageReader.getInstance().getImage());
			}
		}
		*/
		
		Vector<Room> roomCache = null;
		if (GameMaster.getInstance().getLabyrinth() != null) {
		 roomCache= GameMaster.getInstance().getLabyrinth();
		}
		int y=0;
		int x=0;
		int xpos=0;
		int ypos=0;
		int w=9;
		int h=7;

		ImageReader.getInstance().setImage(map[0][0]);
		for (int i = 0; i < roomCache.size(); i++) {
			
			if (!roomCache.elementAt(i).getN().equals("0")) {
				if(y!=0){
				ImageReader.getInstance().setImage(map[y-1][x]);
				north=true;
					System.out.println("paintnorth");
				}if(y>0){
					ImageReader.getInstance().setImage(map[y][x]);
					
				}
				}else{
					north=false;
				}
			
			if (!roomCache.elementAt(i).getE().equals("0")) {
				ImageReader.getInstance().setImage(map[y][x+1]);
					this.east=true;
					System.out.println("painteast");
			}else{
				this.east=false;
			}
			
			if (!roomCache.elementAt(i).getS().equals("0")) {
				ImageReader.getInstance().setImage(map[y+1][x]);
				System.out.println("paintsouth");
				south=true;
			}else{
				south=false;
			}

			if (!roomCache.elementAt(i).getW().equals("0")) {
				 if(east==false){
				ImageReader.getInstance().setImage(map[y][x-1]);
				west=true;
					System.out.println("paintwest");
				 }else if(east==true){
					 west=true;
						ImageReader.getInstance().setImage(map[y][x-1]);
						
						System.out.println("paintwest");
					 
				 }
				 }else{
					 west=false;
				 }
			
			if(north==true && south==false){
				y--;
				System.out.println("y="+y);
			}
			if ( east==true){
				x++;
				System.out.println("x="+x);
				
			}
			if(south==true){
				y++;
				System.out.println("y="+y);
			}
			
		}

	}
	

}

