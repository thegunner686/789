package thegame;

public class DoubleShooter extends Shooter{
	
	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
				return;
			}
			if(iteration % 270 == 0) {
				getTargetM();
				if(target != null) {
					Projectile newPro = new Projectile(1.0, this, 25);
					myGrid.getProjectileList().add(newPro);

				}
			}
			else if(iteration % 300 == 0){
				getTargetM();
				if(target != null) {
					Projectile newPro = new Projectile(1.0, this, 25);
					myGrid.getProjectileList().add(newPro);
				}
				iteration = 0;
			}
			iterate();
		}
	}


}
