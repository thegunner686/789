package thegame;

public class ShopSunflower extends ShopPlant {
	
	public ShopSunflower(int c) {
		super(c);
		myPlant = new Sunflower(System.currentTimeMillis());
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Sunflower(System.currentTimeMillis());
		return temp;
	}
	
}
