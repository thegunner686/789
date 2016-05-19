package thegame;

public class Plant extends Actor{
	private int iteration;
	public Plant() {
		name = "plant";
		imageID = new Integer(2);
		iteration = 1;
		health = 100;
	}
	
	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
				return;
			}
			if(iteration % 300 == 0) {
				if(myGrid.getFirstZombie(gl.getRow()) != null) {
					Projectile newPro = new Projectile(1.0, this, 10);
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
