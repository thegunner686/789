package thegame;

public class Sunflower extends Plant{
	private int iteration;
	
	public Sunflower() {
		imageID = new Integer(4);
		iteration = 1;
	}
	
	public void act() {
		if(myGrid != null) {
			if(iteration % 500 == 0) {
					Currency newCur = new Currency(250);
					myGrid.getCurrencyWaitingList().add(newCur);
			}
			iterate();
		}
	}
	
	public int getIteration() {
		return iteration;
	}
	
	public void iterate() {
		iteration++;
	}
}
