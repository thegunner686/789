package thegame;

import java.util.ArrayList;
import java.util.List;

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
        myShop = new Shop(this);
        running = true;
        run();
    }
    
    public void run() {
    	for(int i = 0; i < 5; i++) {
    		Lawnmower lm = new Lawnmower(System.currentTimeMillis());
    		lm.putSelfInGrid(myGrid, new GridLocation(i, -1));
    		gw.initializeActor(lm);
    		myGrid.getActorList().add(lm);
    		
    	}
    	int cpt = 300;
		int currencyTimer = 1;
		int dx = 800;
    	while(true) {
    		if(running) {
    		List<Actor> al = myGrid.getActorList();
    		//ListIterator<Actor> iter = al.listIterator();
    		for(Actor a : al) {
    			if(a.getGrid() != null) {
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
    		
    		ArrayList<Currency> cq = myGrid.getCurrencyList();
    		for(int i = cq.size() - 1; i >= 0; i--) {
    			Currency ct = cq.remove(i);
    			GridLocation pLoc = ct.getParent().getGridLocation();
    			ct.putSelfInGrid(myGrid, pLoc);
    			if(ct.getDestinationRow() >= 0) {
    				ct.getGridLocation().setRow(-5);
    			}
    			gw.initializeActor(ct);
    		}
    		
    		ArrayList<Actor> dPlant = myGrid.getDeadPlantList();
    		for(int i = dPlant.size() - 1; i >= 0; i--) {
    			GridLocation gdl = dPlant.remove(i).getGridLocation();
    			myGrid.removePlant(gdl.getRow(), gdl.getCol());
    		}
    		
    		if(currencyTimer % cpt == 0) {
    			generateCurrency();
    			System.out.println("CURRENCY CREATED");
    			cpt += 20;
    			currencyTimer = 0;
    		}
    		currencyTimer++;
    		
    		gw.updateShopTotal(myShop.getTotal());
    		
    		if(zombieTimer % dx == 0 && zombieTimer >= 900) {
    			if(dx > 700) {
    				dx -= 25;
        			gw.initializeActor(myGrid.spawnZombie(100, 25));
    			} else if(dx > 600) {
    				dx -= 25;
    				for(int re = 0; re < 2; re++) 
    					gw.initializeActor(myGrid.spawnZombie(150, 35));
    			} else if(dx > 500) {
    				dx -= 25;
    				for(int re = 0; re < 3; re++)
        				gw.initializeActor(myGrid.spawnZombie(200, 45));
    			} else if(dx > 400) {
    				dx -= 25;
    				for(int re = 0; re < 4; re++)
    					gw.initializeActor(myGrid.spawnZombie(250, 55));
    			} else if(dx > 300){
    				dx -= 25;
    				for(int re = 0; re < 5; re++)
        				gw.initializeActor(myGrid.spawnZombie(300, 65));
    			} else {
    				for(int re = 0; re < 5; re++)
        				gw.initializeActor(myGrid.spawnZombie(350, 75));
    			}
    		}
    		gw.refresh();
    		zombieTimer++;
    		}
    		try {
        		Thread.sleep(1000 / 30);
        		} catch(Exception e) {}
    	}
    }
    
    public void generateCurrency() {
    	Actor a = new Actor(System.currentTimeMillis());
    	a.setGridLocation(new GridLocation((int) (Math.random() * 5), (int) (Math.random() * 9)));
    	Currency ck = new Currency(25, a, a.getGridLocation().getRow(), System.currentTimeMillis());
    	myGrid.getCurrencyList().add(ck);
    	//ck.putSelfInGrid(myGrid, new GridLocation((int) (Math.random() * 5), (int) (Math.random() * 9)));
    	//gw.initializeActor(ck);
    }
    
    public static void main(String[] args) {
        Controller myGame = new Controller();
        
        myGame.startGame();
    }

    public void shopButtonClicked(int c) {
    	myShop.buttonClicked(c);
    }
    
    public void gridButtonClicked(int r, int c) {
    	myShop.processSelected(r,  c, myGrid.isEmpty(r, c));
    }
    
    public void currencyClicked(Actor a) {
    	a.removeSelfFromGrid();
    	myShop.addToTotal(((Currency)a).getValue());
    }
    
    // called from shop class
	public void plantProcessed(Actor processed, int r, int c) {
		if(processed == null) 
			return;
		processed.setGridLocation(new GridLocation(r, c));
		myGrid.getPlantWaitingList().add((Plant)processed);
		/*processed.putSelfInGrid(myGrid,  new GridLocation(r, c));
		myGrid.addPlant((Plant)processed,  r,  c);
		gw.initializeActor(processed);*/
	}
	
	public void removePlant(int r, int c) {
		Plant p = myGrid.getPlant(r,  c);
		p.removeSelfFromGrid();
		myGrid.getDeadPlantList().add(p);
		System.out.println("LOL");
	}
	
	public void pause() {
		running = false;
	}
	
	public void unpause() {
		running = true;
	}
	
	public boolean isRunning() {
		return running;
	}
}
