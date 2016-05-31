package thegame;

public class ShopDoubleShooter extends ShopPlant {

	public ShopDoubleShooter(int c) {
		super(c);
		myPlant = new DoubleShooter(System.currentTimeMillis());
	}

	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new DoubleShooter(System.currentTimeMillis());
		return temp;
	}
}
