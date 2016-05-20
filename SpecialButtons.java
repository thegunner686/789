package thegame;

import javax.swing.*;

public class SpecialButtons {
	public static class CurrencyButton extends JButton {
    	private GameObject myObj;
    	
    	public CurrencyButton(ImageIcon img, GameObject obj) {
    		super(img);
    		myObj = obj;
    		setBorderPainted(false);
    	}
    	
    	public GameObject getObject() {
    		return myObj;
    	}
    }
}
