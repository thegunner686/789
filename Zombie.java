package thegame;

public class Zombie extends Actor implements Comparable{
	private Double speed;
	private int eatingIterator;

	public Zombie(int h) {
		name = "zombie";
		speed = 0.25;
		damage = 25;
		health = h;
		imageID = new Integer(1);
		eatingIterator = 1;
	}
	
	public void act() {
		if(myGrid != null) {
			if(this.health <= 0) {
				removeSelfFromGrid();
				System.out.print("ZOMBIE DEAD: " + this.health);
				return;
			}
			if(pl.getX() < 0) {
				removeSelfFromGrid();
				System.out.print("ZOMBIE OFF GRID");
				return;
			}
			Plant myP = myGrid.getPlant(gl.getRow(), gl.getCol());
			if(myP != null) {
				if(eatingIterator % 200 == 0) {
					myP.setHealth(myP.getHealth() - damage);
				}
				eatingIterator++;
			} else {
				pl.incrementX(-1 * this.speed);
				gl.setCol((int) ((pl.getX() - 25) / 50));
				System.out.println("gl.c: " + gl.getCol());
			}
		}
	}
	
	public int compareTo(Object o) {
		PixelLocation oPL = ((Zombie)o).getPixelLocation();
		return pl.compareTo(oPL);
	}
	
}
