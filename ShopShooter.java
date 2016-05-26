package thegame;

public class ShopShooter extends ShopPlant {
	
	public ShopShooter(int c) {
		super(c);
		myPlant = new Shooter(System.currentTimeMillis());
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Shooter(System.currentTimeMillis());
		return temp;
	}
	
}
