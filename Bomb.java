
package thegame;

//import java.util.Iterator;
import java.util.PriorityQueue;

public class Bomb extends Plant {
	
	public Bomb(long tm) {
		super(tm);
		name = "bomb";
		health = 0;
		iteration = 1;
		imageID = new Integer(9);
	}

	public void act(){
		if(myGrid!=null){
			if(iteration == 100) {
				for(int i = -1; i < 2; i++) {
					if(myGrid.isValid(gl.getRow() + i, 0)) {
					PriorityQueue<Zombie> queue = myGrid.getZombieQueue(gl.getRow() + i);
					for(Zombie z : queue) {
						if(z.getPixelLocation().withinRange(pl, 100))  {
							myGrid.incrementDeadZombies();
							z.removeSelfFromGrid();
						}
					}
					}
				}
				myGrid.getDeadPlantList().add(this);
				removeSelfFromGrid();
			}
			iteration++;
		}
	}
}