package thegame;


import java.util.*;

public class Grid {

	Plant[][] plantGrid;
	PriorityQueue<Zombie>[] zombieTracker;
	ArrayList<Projectile> projectileList;
	ArrayList<Plant> plantWaitingList;
	LinkedList<Actor> actorList;
	
	public Grid() {
		plantGrid = new Plant[5][9];
		projectileList = new ArrayList<Projectile>();
		plantWaitingList = new ArrayList<Plant>();
		zombieTracker = new PriorityQueue[5];
		for(int i = 0; i < 5; i++) {
			zombieTracker[i] = new PriorityQueue<Zombie>();
		}
		actorList = new LinkedList<Actor>();
	}
	
	public ArrayList<Plant> getPlantWaitingList() {
		return plantWaitingList;
	}
	
	/* Precondition: r and c are valid row and column locations
	 * Postcondition: the actor at location r and c is removed and returns null if it
	 * doesn’t exist
	 */
	public Actor removePlant(int r, int c){
		Plant temp = plantGrid[r][c];
		plantGrid[r][c] = null;
		actorList.remove(temp);
		return temp;
	}
	
	/* Precondition: r and c are valid row and column locations
	 * Postcondition: Actor a has been placed at the location of r and c,
	 * the actor that had been there previously is returned, null if it doesn’t exist
	 */
	public Plant addPlant(Plant p, int r, int c){
		Plant pl = plantGrid[r][c];
		plantGrid[r][c] = p;
		actorList.add(p);
		return pl;
	}
	
	/*	Precondition: r and c are valid row and column locations
	 *	Postconditions: Returns the actor at that location,
	 *	null if it doesn’t exist
	 */
	public Plant getPlant(int r, int c){
		if (plantGrid[r][c] != null){
			return plantGrid[r][c];
		}
		return null;
	}
	
	/* Precondition: none
	 *Postcondition: returns true if r  >= 0 && r < 5 && c >= 0 && c < 9
	 */
	public boolean isValid(int r, int c) {
		return r >= 0 && r < 5 && c >= 0 && c < 9;
	}
	
	/* 	Precondition:
	 *	Postcondition: spawns new zombie, adds zombie to zombieTracker & actorList, 
	 *	and places new //zombie on the map
	 */
	public Zombie spawnZombie(){
		Zombie z = new Zombie();
		GridLocation ranLoc = new GridLocation((int) (Math.random() * 6), 11);
		z.putSelfInGrid(this, ranLoc);
		zombieTracker[ranLoc.getRow()].add(z);
		actorList.add((Actor) z);
		return z;
	}

	// postcondition: returns the closest zombie in row r
	public Zombie getFirstZombie(int r){
		return zombieTracker[r].poll();
	}

	

	//@return: actorList
	public LinkedList<Actor> getActorList(){
		return actorList;
	}
	
	public ArrayList<Projectile> getProjectileList() {
		return projectileList;
	}

	/* Precondition: r and c are valid row and column locations
	 * Postcondition: returns true if the location at r and c contains null (no actor), false 
	 * otherwise
	 */
	public boolean isEmpty(int r, int c){
		return plantGrid[r][c] == null;
	}
	
}
