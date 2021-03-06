package thegame;

import javax.swing.*;

public class Actor {
	protected GridLocation gl;
	protected PixelLocation pl;
	protected Integer imageID;
	protected Grid myGrid;
	protected int health;
	protected int damage;
	
	
	// Postcondition: Constructs a new actor
	public Actor(){
	}
	
	public Integer getID() {
		return imageID;
	}
	
	public PixelLocation getPixelLocation() {
		return pl;
	}
	
	public GridLocation getGridLocation() {
		return gl;
	}
	
	public ImageIcon getImage(ImageLoader im) {
		return im.getImage(this.imageID);
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
		if(myGrid != null) {
			
		}
	}
	
	
	//postcondition: this actor is now at the location l.getRow(), l.getCol() in the Grid 
	// G, and myGrid has been updated to be g, gl is updated to be l, pixel location is
	// updated, jc is initialized and put into the GUI,
	public void putSelfInGrid(Grid g, GridLocation l){
		myGrid = g;
		gl = l;
		pl = new PixelLocation(gl.getCol() * 50, gl.getRow() * 50);
		if(this instanceof Plant)
			g.addPlant((Plant) this, gl.getRow(), gl.getCol());
		else
			g.getActorList().add(this);	
		health = 0;
		damage = 0;
	}
	
	public int hashCode() {
		int i = 1;
			i *= health;
			i *= damage;
		return i;
	}
	
	//postcondition: this actor is removed from myGrid, and myGrid is now null, gl is nul
	public void removeSelfFromGrid(){
		myGrid = null;
		gl = null;
	}
	
	public void setGridLocation(GridLocation g) {
		gl = g;
	}
}