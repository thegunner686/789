package thegame;

public class ShopPlant extends ShopItem {
	private Plant myPlant;
	
	public ShopPlant(int c) {
		super(c);
		myPlant = new Plant();
	}
	
	public Plant getPlant() {
		Plant temp = myPlant;
		myPlant = new Plant();
		return temp;
	}
	
}
