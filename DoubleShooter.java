package thegame;

public class DoubleShooter extends Shooter{
	
	public DoubleShooter(long tm) {
		super(tm);
		imageID = new Integer(2);
		health = 200;
	}

	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
				return;
			}
			if(iteration % 100 == 0) {
				getTargetM();
				if(target != null) {
					Projectile newPro = new Projectile(2.0, this, 10, System.currentTimeMillis());
					myGrid.getProjectileList().add(newPro);
				}
			}
			else if(iteration % 120 == 0){
				getTargetM();
				if(target != null) {
					Projectile newPro = new Projectile(2.0, this, 10, System.currentTimeMillis());
					myGrid.getProjectileList().add(newPro);
				}
				iteration = 0;
			}
			iterate();
		}
	}


}