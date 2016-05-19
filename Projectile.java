package thegame;

public class Projectile extends Actor {
	private double speed;
	private Plant parent;
	
	public Projectile(Double s, Plant ps, int dmg) {
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
			Zombie z = getTarget();
			if(z != null) {
				if(pl.withinRange(z.getPixelLocation(), 25)) {
					System.out.println("HIT");
					z.setHealth(z.getHealth() - damage);
					removeSelfFromGrid();
				}
				//System.out.println("DISTANCE: " + pl.distanceTo(z.getPixelLocation()));
			}
			pl.incrementX(speed);
			if(pl.getX() > 600) 
				removeSelfFromGrid();
		}
	}
	
	public Zombie getTarget() {
		Zombie z = myGrid.getFirstZombie(gl.getRow());
		while(z != null && z.getGrid() == null) {
				myGrid.removeFirstZombie(gl.getRow());
				z = myGrid.getFirstZombie(gl.getRow());
		}
		
		return z;
	}
}
