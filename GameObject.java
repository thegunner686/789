package thegame;

import javax.swing.*;

public class GameObject {
	Actor myActor;
	JComponent myImage;
	ImageIcon img;
	GameWorld gw;
	
	public GameObject(Actor a, GameWorld g) {
		myActor = a;
		gw = g;
		
		img = new ImageIcon(myActor.getImage());
		if(myActor instanceof Plant) {
			JButton[][] jb = g.getGridButtons();
			GridLocation gl = myActor.getGridLocation();
			myImage = jb[gl.getRow()][gl.getCol()];
		} else {
			myImage = new JLabel(img);
		}
		
	}
	
	public void update() {
		if(myActor instanceof Plant)
			return;
		PixelLocation px = myActor.getPixelLocation();
		myImage.setBounds(px.getX(), px.getY());
	}
}
