package thegame;

public class Currency extends Actor {
	private int value;
	private Actor parent;
	private int iterator;
	
	public Currency(int v, Actor p) {
		value = v;
		parent = p;
		imageID = new Integer(5);
		name = "currency";
		iterator = 0;
	}
	
	public void act() {
		if(iterator > 3000) 
			removeSelfFromGrid();
		iterator++;
	}
	
	public int getValue() {
		return value;
	}

	public Actor getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
}
