package thegame;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Bomb extends Plant {
	public Bomb() {
		name = "bomb";
		health = 0;
		iteration = 1;
	}

	public void act(){
		if(myGrid!=null){
		
			for (int i=-1 ; i < 2; i++){
				PriorityQueue<Zombie> queue = myGrid.getZombieQueue(gl.getRow() + i);
				Iterator<Zombie> iter = queue.iterator();
				while (iter.hasNext()){
					Zombie z = iter.next();
					if (z.getPixelLocation().withinRange(this.getPixelLocation(), 75*Math.sqrt(2))){
						System.out.print("boom");
						z.setHealth(0);
						z.removeSelfFromGrid();
					}	
				}
			}
		}
		myGrid.getDeadPlantList().add(this);
		removeSelfFromGrid();

	}
}
