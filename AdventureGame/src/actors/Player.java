package actors;


public class Player {
	
	private String position = "1";
	private String direction;

	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String posToString() {
		return "Player is in room: " + position + ".";
	}

}
