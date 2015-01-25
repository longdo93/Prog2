package GUI;

import input.ImageReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dungeon.Room;
import actors.GameMaster;

public class MapPanel implements Observer{
	
	private static MapPanel instance;
	
	static final int X = 10;
	static final int Y =10;
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
		mapPanel.setPreferredSize(new Dimension(X*85, Y*85));
		createJLabels();
		
	}
	
	public JPanel getMapPanel(){
		return mapPanel;
		
	}
	
	private void createJLabels() {
		

		
		for (int i = 0; i < this.Y; i++) {
			for (int j = 0; j < this.X; j++) {
				JLabel label = new JLabel();
				//label.setBorder(BorderFactory.createLineBorder(Color.white));
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
		
		int y=3;
		int x=2;
		ImageIcon room=ImageReader.getInstance().getImage("room");
		ImageIcon magicroom=ImageReader.getInstance().getImage("magicRoom");
		map[y][x].setIcon(room);
		
		for (int i = 0; i < roomCache.size(); i++) {
			
			if (!roomCache.elementAt(i).getN().equals("0")) {
				if(y>0){
				map[y-1][x].setIcon(room);
				north=true;
				}if(y==0){
					map[y][x].setIcon(room);
				}
			}
			else{
				north=false;
				}
			
			if (!roomCache.elementAt(i).getE().equals("0")) {
				map[y][x+1].setIcon(room);
				this.east=true;
			}
			else{
				this.east=false;
			}
			
			if (!roomCache.elementAt(i).getS().equals("0")) {
				map[y+1][x].setIcon(room);
				System.out.println("paintsouth");
				south=true;
			}
			else{
				south=false;
			}

			if (!roomCache.elementAt(i).getW().equals("0")) {
				 if(east==false){
				map[y][x-1].setIcon(room);
				west=true;
				 }else if(east==true){
					 west=true;
						map[y][x+1].setIcon(room);
				 }
			}
			else{
				  west=false;
				 }

			if(north==true && south==false){
				y--;
			}
			if ( east==true&&south==false&&north==false){
				x++;			
			}else
			if(east==true){
				x++;
			}
//			if ( east==true&&west==false&&south==false&&north==false){
//				x--;
//			}
			if(south==true){
				y++;
			}else
			if(south==true&&north==false){
				y++;
			}

		}

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}

