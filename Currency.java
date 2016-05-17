package thegame;

public class Currency extends Actor {
	private Shop myShop;
	private int value;
	
	public Currency(int v, Shop s) {
		value = v;
		myShop = s;
	}
	
	public int getValue() {
		return value;
	}
	
	public void removeSelfFromGrid() {
		myShop.addToTotal(value);
		super.removeSelfFromGrid();
	}
}
