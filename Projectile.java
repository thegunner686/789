package thegame;

public class Projectile extends Actor {
	private double speed;
	private Plant parent;
	
	public Projectile(Double s, Plant ps, int dmg, long tm) {
		super(tm);
		name = "projectile";
		speed = s;
		imageID = new Integer(3);
		damage = dmg;
		health = 0;
		parent = ps;
	}
	
	public Plant getParent() {
		return parent;
	}
	
	public void act() {
		if(myGrid != null) {
			//System.out.println(z);
			Zombie z = ((Shooter)parent).getTarget();
			if(z != null) {
				if(pl.withinRange(z.getPixelLocation(), 25)) {
					System.out.println("HIT");
					z.setHealth(z.getHealth() - damage);
					myGrid.incrementDeadZombies();
					removeSelfFromGrid();
				}
				//System.out.println("DISTANCE: " + pl.distanceTo(z.getPixelLocation()));
			}
			pl.incrementX(speed);
			if(pl.getX() > 600) 
				removeSelfFromGrid();
		}
	}
}
