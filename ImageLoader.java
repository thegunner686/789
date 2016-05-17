package thegame;

import javax.swing.*;
//import java.net.URL;
import java.util.HashMap;

public class ImageLoader {	
	private HashMap<Integer, ImageIcon> imageMap;
	
	public ImageLoader() {
		imageMap = new HashMap<Integer, ImageIcon>();
		//ClassLoader cldr = this.getClass().getClassLoader();
		try {
			imageMap.put(new Integer(1), new ImageIcon("src/zombie.png"));
		} catch(Exception e) {
			System.out.print("There was an error with the loading of the image");
		}
	}
	
	public ImageIcon getImage(Integer k) {
		System.out.println();
		System.out.print(k);
		System.out.println(imageMap.get(k));
		return imageMap.get(k);
	}
}
