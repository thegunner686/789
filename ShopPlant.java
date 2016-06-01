package thegame;

public class ShopPlant extends ShopItem {
	protected Plant myPlant;
	protected int resetTime;
	protected int timeTillReset;
	public ShopPlant(int c) {
		super(c);
		resetTime = 50;
	}
	
	public Plant getPlant() {
		return null;
	}
	
	public void setTimeTillReset(int rt) {
		timeTillReset = rt;
	}
	
	public int getTimeTillReset() {
		return timeTillReset;
	}
	
	public int getResetTime() {
		return resetTime;
	}
	
}
