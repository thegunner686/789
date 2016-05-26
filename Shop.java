package thegame;

public class Shop {
	private boolean itemIsSelected;
	private int selectedItem;
	private ShopItem[] shopItems;
	private Controller control;
	private int total;
	
	public Shop(Controller xc) {
		total = 50;
		selectedItem = 0;
		itemIsSelected = false;
		control = xc;
		shopItems = new ShopItem[6];
		shopItems[0] = new ShopShooter(100);
		shopItems[1] = new ShopSunflower(50);
		shopItems[2] = new ShopRock(50);
		shopItems[3] = new ShopBomb(50);
		shopItems[4] = new ShopDoubleShooter(200);
		shopItems[5] = new ShopRemover(0);
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
	
	public void processSelected(int r, int c, boolean empty) {
		if(somethingSelected()) {
			ShopItem si = shopItems[selectedItem];
			if(si instanceof ShopPlant && empty) {
				control.plantProcessed(processPlantItem((ShopPlant)si), r, c);
			} else if(si instanceof ShopRemover && !empty){
				control.removePlant(r, c);
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
