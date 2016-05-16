
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
	
	public void act(){
		Actor project = new Projectile();
		project.putSelfInGrid(myGrid, gl);
	}
}

