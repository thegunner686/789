package thegame;

public class Projectile extends Actor {
	private double speed;
	private Plant parent;
	
	public Projectile(Double s, Plant ps) {
		speed = s;
		imageID = new Integer(1);
		parent = ps;
	}
	
	public Plant getParent() {
		return parent;
	}
	
	public void act() {
		if(myGrid != null) {
			pl.incrementX(speed);
		}
	}
}
