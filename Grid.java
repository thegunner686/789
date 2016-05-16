package thegame;
import java.util.*;

public class Grid {

	Plant[][] plantGrid;
	PriorityQueue<Zombie>[] zombieTracker;
	LinkedList<Actor>[] actorList;
	
	/* Precondition: r and c are valid row and column locations
	 * Postcondition: the actor at location r and c is removed and returns null if it
	 * doesn’t exist
	 */
	public Actor removePlant(int r, int c){
		Plant temp = plantGrid[r][c];
		plantGrid[r][c] = null;
		actorList[r].remove(temp);
		
	}
	
	/* Precondition: r and c are valid row and column locations
	 * Postcondition: Actor a has been placed at the location of r and c,
	 * the actor that had been there previously is returned, null if it doesn’t exist
	 */
	public Actor  addPlant(Actor a, int r, int c){
		plantGrid[r][c] = a;
		actorList[r].add(a);
	}
	
	/*	Precondition: r and c are valid row and column locations
	 *	Postconditions: Returns the actor at that location,
	 *	null if it doesn’t exist
	 */
	public void getPlant(int r, int c){
		if (plantGrid[r][c] != null){
			return plantGrid[r][c];
		}
		return;
	}
	
	/* Precondition: none
	 *Postcondition: returns true if r  >= 0 && r < 5 && c >= 0 && c < 9
	 */
	public boolean isValid(int r, int c) {}
	
	/* 	Precondition:
	 *	Postcondition: spawns new zombie, adds zombie to zombieTracker & actorList, 
	 *	and places new //zombie on the map
	 */
	public Zombie addZombie(){}

	// postcondition: returns the closest zombie in row r
	public Zombie getFirstZombie(int r){}

	

	//@return: actorList
	public LinkedList<Actor> getActorList(){}

	

	/* Precondition: r and c are valid row and column locations
	 * Postcondition: returns true if the location at r and c contains null (no actor), false 
	 * otherwise
	 */
	public boolean isEmpty(int r, int c){}
	public Projectile addProjectile(){}

}
