package thegame;

public class Lawnmower extends Actor {
	private boolean murdering;
	private int speed;
	public Lawnmower(long tm) {
		super(tm);
		imageID = new Integer(7);
		name = "lawnmower";
		murdering = false;
		speed = 2;
	}
	
	public void act() {
		if(myGrid != null) {
			if(murdering) {
				System.out.println("murdering");
				pl.incrementX(speed);
				
				for(Zombie z : myGrid.getZombieQueue(gl.getRow())) {
					if(z.getPixelLocation().withinRange(pl, 25)) {
						z.removeSelfFromGrid();
					}
				}
				if(pl.getX() > 650) {
					murdering = false;
					removeSelfFromGrid();
				}
			} else {
				Zombie z = myGrid.getFirstZombie(gl.getRow());
				if(z != null && z.getPixelLocation().withinRange(pl, 25)) {
					z.removeSelfFromGrid();
					murdering = true;
				}
			}
		}
	}
	
}
