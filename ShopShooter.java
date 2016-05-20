package thegame;

public class ShopShooter extends ShopPlant {
	private Shooter myPlant;
	
	public ShopShooter(int c) {
		super(c);
		myPlant = new Shooter();
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Shooter();
		return temp;
	}
	
}
