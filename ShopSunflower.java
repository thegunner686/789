package thegame;

public class ShopSunflower extends ShopPlant {
	private Sunflower myPlant;
	
	public ShopSunflower(int c) {
		super(c);
		myPlant = new Sunflower();
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Sunflower();
		return temp;
	}
	
}
