package thegame;

public class ShopRock extends ShopPlant {
	
	public ShopRock(int c) {
		super(c);
		myPlant = new Rock(System.currentTimeMillis());
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Rock(System.currentTimeMillis());
		return temp;
	}
}
