package thegame;

public class Shop {
	private boolean itemIsSelected;
	private int selectedItem;
	private ShopItem[] shopItems;
	private Controller control;
	private int total;
	
	public Shop(int s, Controller xc) {
		total = 100;
		selectedItem = 0;
		itemIsSelected = false;
		control = xc;
		shopItems = new ShopItem[s];
		for(int i = 0; i < s; i++) {
			shopItems[i] =  new ShopPlant(10);
		}
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
			if(si instanceof ShopPlant) {
				control.plantProcessed(processPlantItem((ShopPlant)si), r, c);
			} else {
				
			}
		}
	}
	
	private Actor processPlantItem(ShopPlant s) {
		if(canBuy(s.getCost()))
				return s.getPlant();
		else
				return null;
	}
}
