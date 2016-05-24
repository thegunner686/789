package thegame;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Shooter extends Plant{
	
	protected Zombie target;
	
	public Shooter() {
		name = "shooter";
		imageID = new Integer(2);
		iteration = 1;
		health = 100;
		target = null;
	}
	
	public void act() {
		if(myGrid != null) {
			if(health <= 0) {
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
				return;
			}
			if(iteration % 300 == 0) {
				getTargetM();
				if(target != null) {
					Projectile newPro = new Projectile(1.0, this, 25);
					myGrid.getProjectileList().add(newPro);
				}
			}
			iterate();
		}
	}
	
	public Zombie getTarget() {
		return target;
	}
	
	protected void getTargetM() {
		PriorityQueue<Zombie> zQue = myGrid.getZombieQueue(gl.getRow());
		Iterator<Zombie> iter = zQue.iterator();
		Zombie z = null;
		target = null;
		while(iter.hasNext()) {
			z = iter.next();
			if(z.getGrid() != null) {
				if(pl.compareTo(z.getPixelLocation()) <= 0) {
					target = z;
					break;
				}
			}
		}
	}
}
