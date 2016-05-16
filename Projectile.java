
public class Projectile extends Actor{
	private GridLocation gl;
	private PixelLocation pl;
	private Grid myGrid;
	private int damage;
	
	public Projectile(){
	}
	/*precondition: projectile is instantiated in grid
	 *postcondition: projectile moves forward until it hits a zombie or goes off screen, 
	 *if it hits a zombie removeselffromgrid and deal damage to zombie, if goes off screen 
	 *remove self from grid. 
	*/

	public void act(){
		pl.incrementX(1);
		if(pl.withinRange(myGrid.getFirstZombie(gl.getRow())))
			removeSelfFromGrid();
		if(pl.getX() > 9*50);
			removeSelfFromGrid();
	}
	public void putSelfInGrid(Grid g, GridLocation l){
		gl = l;
		myGrid = g;
		pl.setX(l.getColumn()*50);
		pl.setY(l.getRow()*50);
	}
}
