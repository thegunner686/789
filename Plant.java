package thegame;

public class Plant extends Actor{
	private int iteration;
	public Plant() {
		imageID = new Integer(1);
		iteration = 1;
	}
	
	public void act() {
		if(myGrid != null) {
			Projectile newPro = new Projectile(1.0, this);
			myGrid.getProjectileList().add(newPro);
		}
	}
	
	public int getIteration() {
		return iteration;
	}
	
	public void iterate() {
		iteration++;
	}
}
