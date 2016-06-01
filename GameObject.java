package thegame;

import javax.swing.*;

public class GameObject {
	Actor myActor;
	JComponent myImage;
	ImageIcon img;
	GameWorld gw;
	int offsetY;
	int offsetX;
	Integer myImageID;
	
	public GameObject(Actor a, GameWorld g) {
		myActor = a;
		gw = g;
		offsetY = 100;
		offsetX = 25;
		myImageID = myActor.getID();
		img = gw.getController().getImageLoader().getImage(myActor.getID());
		if(myActor instanceof Plant) {
			JButton[][] jb = g.getGridButtons();
			GridLocation gl = myActor.getGridLocation();
			myImage = jb[gl.getRow()][gl.getCol()];
			((JButton)myImage).setIcon(img);
		} else {
			if(myActor instanceof Currency) {
				myImage = new SpecialButtons.CurrencyButton(img, this);
				((SpecialButtons.CurrencyButton)myImage).addActionListener(gw.getCurrencyActionListener());
			} else {
				myImage = new JLabel(img);
			}
			PixelLocation px = myActor.getPixelLocation();
			myImage.setBounds((int)(px.getX() + offsetX), (int)(px.getY() + offsetY), 50, 50);
			gw.add(myImage, gw.getComponentCount() - 1);
		}
	}
	
	public void update() {
		if(myActor instanceof Plant) {
			if(myImageID != myActor.getID()) {
				myImageID = myActor.getID();
				img = gw.getController().getImageLoader().getImage(myActor.getID());
				((JButton)myImage).setIcon(img);
			}
			return;
		}
		PixelLocation px = myActor.getPixelLocation();
		myImage.setBounds((int)(px.getX() + offsetX), (int)(px.getY() + offsetY), 50, 65);
	}
	
	public JComponent getComponent() {
		return myImage;
	}
	
	public Actor getActor() {
		return myActor;
	}
	
}
