package thegame;

public class Sunflower extends Plant {
	
	public Sunflower() {
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
			if(iteration % 2000 == 0) {
				Currency c = new Currency(10, this);
				myGrid.getCurrencyList().add(c);
			}
			iteration++;
		}
	}
}
