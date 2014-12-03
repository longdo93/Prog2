package dungeon;

import java.util.Vector;

public abstract class AbstractMaze {
	
	public abstract Vector<Room> getMaze();

	public void makeRoom() {
	}
	
	public abstract void printMaze();

}
