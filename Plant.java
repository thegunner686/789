package thegame;

public class Plant extends Actor{
	private int iteration;
	public Plant() {
		imageID = new Integer(1);
		iteration = 1;
	}
	
	public void act() {
		if(myGrid != null) {
			if(iteration % 300 == 0) {
				if(myGrid.getFirstZombie(gl.getRow()) != null) {
					Projectile newPro = new Projectile(1.0, this, 25);
					myGrid.getProjectileList().add(newPro);
				}
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
