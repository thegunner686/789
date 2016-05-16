
public class Plant extends Actor {
	private GridLocation gl;
	private PixelLocation pl;
	private Grid myGrid;
	private int health;
	private int damage;
	
	public Plant(Grid g, GridLocation l, int hlth, int dmg){
		myGrid = g;
		gl = l;
		health = hlth;
		damage = dmg;
		putSelfInGrid(myGrid, gl);
	}
	
	/ Precondition: Plant is instantiated in plant grid and alive
	// Postcondition: Plant does an action
	public void act(){
		Actor project = new Projectile();
		project.putSelfInGrid(myGrid, gl);
	}
}

