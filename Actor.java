
public class Actor {
	private GridLocation gl;
	private PixelLocation pl;
	private Grid myGrid;
	private int health;
	private int damage;
	
	
	// Postcondition: Constructs a new actor
	public Actor(){
	}
	
	
	public void setHealth(int h){
		health = h;
	}
	
	
	public int getHealth(){
		return health;
	}
	
	
	public void setDamage(int d){
		damage = d;
	}
	
	
	public int getDamage(){
		return damage;
	}
	
	
	//precondition: This actor has a grid
	//post condition: actor does nothing (overridden  method)
	public void act(){
	}
	
	
	//postcondition: this actor is now at the location l.getRow(), l.getCol() in the Grid 
	// G, and myGrid has been updated to be g, gl is updated to be l, pixel location is
	// updated, jc is initialized and put into the GUI,
	public void putSelfInGrid(Grid g, GridLocation l){
		myGrid = g;
		gl = l;
		pl = null;
		g.addPlant(gl.getRow(), gl.getColumn());
	}
	
	
	//postcondition: this actor is removed from myGrid, and myGrid is now null, gl is null
	public void removeSelfFromGrid(){
		myGrid = null;
		gl = null;
	}
	
	public int hashCode(){
		int hash = damage*21 + health;
		hash = hash*5 + gl.getRow();
		hash = hash*7 + gl.getCol();
		return hash;
	}
}
