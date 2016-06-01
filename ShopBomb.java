package thegame;

public class ShopBomb extends ShopPlant {
	
	public ShopBomb(int c) {
		super(c);
		myPlant = new Bomb(System.currentTimeMillis());
	}

	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Bomb(System.currentTimeMillis());
		return temp;
	}
}
