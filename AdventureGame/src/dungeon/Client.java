package dungeon;

public class Client {
	
	private AbstractFactory factory = null;
	
	public void setFactory(AbstractFactory factory) {
		System.out.println("setFactory()");						//delete this later
		this.factory = factory;
	}
	
	public void makeRoom() {
		if (this.factory != null) {
			System.out.println("makeRoom()");					//delete this later
			this.factory.generateMaze().makeRoom();
		}
	}

}
