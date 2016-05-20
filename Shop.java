package thegame;

public class Shop {
	private boolean itemIsSelected;
	private int selectedItem;
	private ShopItem[] shopItems;
	private Controller control;
	private int total;
	
	public Shop(Controller xc) {
		total = 100;
		selectedItem = 0;
		itemIsSelected = false;
		control = xc;
		shopItems = new ShopItem[3];
		shopItems[0] = new ShopShooter(20);
		shopItems[1] = new ShopSunflower(10);
	}
	
	public ShopItem[] getShopItems() {
		return shopItems;
	}
	
	public boolean somethingSelected() {
		return itemIsSelected;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void removeFromTotal(int t) {
		total -= t;
	}
	
	public boolean canBuy(int t) {
		return t <= total;
	}
	
	public void addToTotal(int t) {
		total += t;
	}
	
	public void selectItem(int c) {
		selectedItem = c;
	}
	
	public void buttonClicked(int c) {
		itemIsSelected = true;
		selectedItem = c;
		
	}
	
	public void processSelected(int r, int c) {
		if(somethingSelected()) {
			ShopItem si = shopItems[selectedItem];
			if(si instanceof ShopItem) {
				control.plantProcessed(processPlantItem((ShopPlant)si), r, c);
			} else {
				
			}
		}
	}
	
	private Actor processPlantItem(ShopPlant s) {
		if(canBuy(s.getCost())) {
				removeFromTotal(s.getCost());
				return s.getPlant();
		} else {
				return null;
		}
	}
}
