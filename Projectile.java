package thegame;

public class Projectile extends Actor {
	private double speed;
	private Plant parent;
	
	public Projectile(Double s, Plant ps, int dmg) {
		speed = s;
		imageID = new Integer(1);
		damage = dmg;
		health = 0;
		parent = ps;
	}
	
	public Plant getParent() {
		return parent;
	}
	
	public void act() {
		if(myGrid != null) {
			Zombie z = myGrid.getFirstZombie(gl.getRow());
			//System.out.println(z);
			if(z != null) {
				if(pl.withinRange(z.getPixelLocation(), 25)) {
					System.out.println("HIT");
					z.setHealth(z.getHealth() - damage);
					removeSelfFromGrid();
				}
				//System.out.println("DISTANCE: " + pl.distanceTo(z.getPixelLocation()));
			}
			pl.incrementX(speed);
		}
	}
}
