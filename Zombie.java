package thegame;

public class Zombie extends Actor implements Comparable{
	private Double speed;

	public Zombie(int h) {
		speed = 0.25;
		health = h;
		imageID = new Integer(1);
	}
	
	public void act() {
		if(myGrid != null) {
			if(this.health <= 0) {
				removeSelfFromGrid();
				System.out.print("ZOMBIE DEAD: " + this.health);
				return;
			}
			this.getPixelLocation().incrementX(-1 * this.speed);
		}
	}
	
	public int compareTo(Object o) {
		PixelLocation myPL = getPixelLocation();
		PixelLocation oPL = ((Zombie)o).getPixelLocation();
		if(myPL.getX() < oPL.getX()) 
			return 1;
		else if(myPL.getX() == oPL.getX()) 
			return 0;
		else
			return -1;
	}
	
}
