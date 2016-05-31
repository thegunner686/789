package thegame;

 //import javax.imageio.ImageIO;
import javax.swing.*;

//import java.awt.Toolkit;
//import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {	
	private HashMap<Integer, ImageIcon> imageMap;
	private final String pathname = "resources/";
	public ImageLoader() {
		imageMap = new HashMap<Integer, ImageIcon>();
		try {
			//URL n1 = ImageLoader.class.getResource("/Resources/Zombie.gif");
			//ImageIcon tempImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(n1));
			//Toolkit.getDefaultToolkit().getImage(getClass().getResource("/src/Resources/SunflowerActor.gif"));
			
			//System.out.print("babushka" + n1);
			imageMap.put(new Integer(1), getImageIcon(pathname + "Zombie.gif"));
			//imageMap.put(new Integer(1), new ImageIcon("src/Resources/Zombie.gif"));
			imageMap.put(new Integer(2), getImageIcon(pathname + "ShooterActor.gif"));
			imageMap.put(new Integer(3), getImageIcon(pathname + "Projectile.gif"));
			imageMap.put(new Integer(4), getImageIcon(pathname + "SunflowerActor.gif"));
			imageMap.put(new Integer(5), getImageIcon(pathname + "Currency.gif"));
			imageMap.put(new Integer(6),  getImageIcon(pathname + "Shovel.gif"));
			imageMap.put(new Integer(7), getImageIcon(pathname + "LawnMowerMoving.gif"));
			imageMap.put(new Integer(8),  getImageIcon(pathname + "Walnut.gif"));
			imageMap.put(new Integer(9),  getImageIcon(pathname + "Cherry Bomb.gif"));
			imageMap.put(new Integer(10), getImageIcon(pathname + "Cherry Bomb Shop.gif"));
			imageMap.put(new Integer(11),  getImageIcon(pathname + "DoubleShooter.gif"));
			imageMap.put(new Integer(12), getImageIcon(pathname + "ShooterShop.gif"));
			imageMap.put(new Integer(13),  getImageIcon(pathname + "SunflowerShop.gif"));
			imageMap.put(new Integer(14), getImageIcon(pathname + "DoubleShooterShop.gif"));
			imageMap.put(new Integer(15), getImageIcon(pathname + "WalnutSemiDamaged.gif"));
			imageMap.put(new Integer(16),  getImageIcon(pathname + "AnalyDestroyedWalnut.gif"));
		} catch(Exception e) {
			System.out.print("There was an error with the loading of the image");
			e.printStackTrace();
		}
	}
	
	private ImageIcon getImageIcon(String path) {
		//return new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource(path)));
		return new ImageIcon(getClass().getClassLoader().getResource(path));

	}
	
	public ImageIcon getImage(Integer k) {
		System.out.println();
		System.out.print(k);
		System.out.println(imageMap.get(k));
		return imageMap.get(k);
	}
}
