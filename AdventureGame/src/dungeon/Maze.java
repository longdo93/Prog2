package dungeon;

import input.RoomReader;

import java.util.Vector;

public class Maze extends AbstractMaze {
	Vector<Room> vec = new Vector<Room>();

	/**
	 * This method loads the room coordinates and creates the rooms for the
	 * maze.
	 */
	public void makeRoom() {
		RoomReader rr = new RoomReader();
		Vector<String> roomPlans = (rr.getRoomPlans());
		for (int i = 0; i < roomPlans.size(); i++) {
			Room room = new Room(roomPlans.elementAt(i).toString());
			vec.addElement(room);
		}
	}

	/**
	 * return this maze
	 */
	@Override
	public Vector<Room> getMaze() {
		return this.vec;
	}

	/**
	 * Print room ids for test purpose
	 */
	public void printMaze() { // TEST
		for (int i = 0; i < vec.size(); i++) {
			System.out.println(this.vec.elementAt(i).toString());
		}
	}

}
