package thegame;

public class Zombie extends Actor implements Comparable<Zombie> {
	private Double speed;
	private int eatingIterator;

	public Zombie(int h, long tm) {
		super(tm);
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
			if(pl.getX() < -100) {
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
				gl.setCol((int) Math.ceil(((pl.getX() - 25) / 50.0)));
				//System.out.println("gl.c: " + gl.getCol());
			}
		}
	}
	
	public int compareTo(Zombie o) {
		PixelLocation oPL = o.getPixelLocation();
		return pl.compareTo(oPL);
	}
	
}
