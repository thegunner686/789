package thegame;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Controller implements Runnable
{
	private boolean running;
    private GameWorld gw;
    private Grid myGrid;
    private ImageLoader theLoader;
    private long zombieTimer;
    private Shop myShop;

    public Grid getGrid() {
    	return myGrid;
    }
    
    public ImageLoader getImageLoader() {
    	return theLoader;
    }
    
    public Controller()
    {
    	theLoader = new ImageLoader();
    	running = false;
    	zombieTimer = 0;
    }

    public void startGame() {
        gw = new GameWorld(this);
        myGrid = new Grid();
        myShop = new Shop(3, this);
        running = true;
        run();
    }
    
    public void run() {
    	while(running) {
    		List<Actor> al = myGrid.getActorList();
    		for(Actor a : al) {
    			if(a instanceof Plant) {
    				System.out.println("plant");
    				if(((Plant)a).getIteration() % 300 == 0)  {
    					a.act();
    					((Plant) a).iterate();
    				} else {
    					((Plant)a).iterate();
    				}
    			} else {
    				a.act();
    			}
    			gw.updateActor(a);
    		}
    		ArrayList<Plant> pwl = myGrid.getPlantWaitingList();
    		for(int i = pwl.size() - 1; i >= 0; i--) {
    			Plant pct = pwl.remove(i);
    			GridLocation glw = pct.getGridLocation();
    			pct.putSelfInGrid(myGrid,  glw);
    			myGrid.addPlant((Plant)pct,  glw.getRow(),  glw.getCol());
    			gw.initializeActor(pct);
    		}
    		ArrayList<Projectile> pq = myGrid.getProjectileList();
    		for(int i = pq.size() - 1; i >= 0; i--){
    			Projectile p = pq.remove(i);
    			p.putSelfInGrid(myGrid, p.getParent().getGridLocation());
    			gw.initializeActor(p);
    			
    		}
    		if(zombieTimer % 200 == 0 && zombieTimer > 800) 
    			gw.initializeActor(myGrid.spawnZombie());
    		gw.refresh();
    		zombieTimer++;
    		try {
    		Thread.sleep(1000 / 60);
    		} catch(Exception e) {}
    	}
    }
    
    public static void main(String[] args) {
        Controller myGame = new Controller();
        
        myGame.startGame();
    }

    public void shopButtonClicked(int c) {
    	myShop.buttonClicked(c);
    }
    
    public void gridButtonClicked(int r, int c) {
    	myShop.processSelected(r,  c);
    }
    
    // called from shop class
	public void plantProcessed(Actor processed, int r, int c) {
		processed.setGridLocation(new GridLocation(r, c));
		myGrid.getPlantWaitingList().add((Plant)processed);
		/*processed.putSelfInGrid(myGrid,  new GridLocation(r, c));
		myGrid.addPlant((Plant)processed,  r,  c);
		gw.initializeActor(processed);*/
	}
}
