package thegame;

public class Plant extends Actor{
	protected int iteration;
	
	public Plant(long tm) {
		super(tm);
		name = "plant";
		health = 100;
		iteration = 1;
	}
	
	public int getIteration() {
		return iteration;
	}
	
	public void iterate() {
		iteration++;
	}
}
