package thegame;

public class Rock extends Plant {
	
	public Rock(long tm) {
		super(tm);
		health = 1000;
		imageID = new Integer(8);
		name = "rock";
	}
	
	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
			}
		}
	}
}
