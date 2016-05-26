package thegame;

public class Currency extends Actor {
	private int value;
	private Actor parent;
	private int iterator;
	private boolean falling;
	private int destRow;
	
	public Currency(int v, Actor p, int dR, long tm) {
		super(tm);
		value = v;
		parent = p;
		imageID = new Integer(5);
		name = "currency";
		iterator = 0;
		falling = true;
		destRow = dR;
	}
	
	public Currency(int v, Actor p, long tm) {
		super(tm);
		value = v;
		imageID = new Integer(5);
		name = "currency";
		iterator = 0;
		falling = true;
		parent = p;
		destRow = -1;
	}
	
	public void act() {
		if(myGrid != null) {
			if(iterator > 500) 
				if(falling && destRow >= 0) {
					pl.incrementY(1);
					gl.setRow((int)Math.ceil((pl.getY() - 100) / 50));
					if(gl.getRow() == destRow) {
						falling = false;
					}
				} else {
					
				}
			iterator++;
		}
	}
	
	public int getDestinationRow() {
		return destRow;
	}
	
	public int getValue() {
		return value;
	}

	public Actor getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
}
