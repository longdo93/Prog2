package dungeon;

public class Factory extends AbstractFactory {

	@Override
	public AbstractMaze generateMaze() {
		return new Maze();
	}

}
