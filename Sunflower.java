package thegame;

public class Sunflower extends Plant {
	
	public Sunflower(long tm) {
		super(tm);
		imageID = new Integer(4);
		name = "sunflower";
		health = 120;
	}
	
	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
				return;
			}
			if(iteration % 800 == 0) {
				Currency c = new Currency(25, this, System.currentTimeMillis());
				myGrid.getCurrencyList().add(c);
			}
			iteration++;
		}
	}
}
