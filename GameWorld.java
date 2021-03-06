package thegame;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GameWorld extends JFrame
{
	private HashMap<Actor, GameObject> gameObjects;
    private GridButton[][] gridButtons;
    private JButton[] shopButtons;
    private JLayeredPane myPanel;
    private JLayeredPane gamePanel;
    private Controller control;

    public GameWorld(Controller c)
    {
    	gameObjects = new HashMap<Actor, GameObject>();
        myPanel = new JLayeredPane();
        gamePanel = new JLayeredPane();
        myPanel.setLayout(null);
        control = c;
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myPanel.add(gamePanel);
        
        gridButtons = new GridButton[5][9];
        shopButtons = new JButton[3];
        
        for(int i = 0; i < 3; i++) {
        	ShopButton j = new ShopButton(i);
        	j.setBounds(i * 50, 0, 50, 50);
        	j.setMargin(new Insets(0, 0, 0, 0));
        	shopButtons[i] = j;
        	myPanel.add(j);
        }
        
        int buttonSize = 50;
        
        for(int i = 0; i < 5; i++) {
            for(int q = 0; q < 9; q++) {
                GridButton j = new GridButton(i, q);
                j.setBounds(q * buttonSize + 25, i * buttonSize + 100, buttonSize, buttonSize);
                j.setMargin(new Insets(0, 0, 0, 0));
                j.setBackground(Color.GREEN);
                //j.setBorderPainted(false);
                //j.setBorder(null);
                gridButtons[i][q] = j;
                myPanel.add(j);
            }
        }
      
        
        this.add(myPanel);
        
        this.setVisible(true);
    }
    
    public Controller getController() {
    	return control;
    }
    
    public JButton[][] getGridButtons() {
    	return gridButtons;
    }
    
    public void initializeActor(Actor a) {
    	GameObject gm = new GameObject(a, this);
    	gameObjects.put(a,  gm);
    }
    
    public void updateActor(Actor a) {
    	GameObject gm = gameObjects.get(a);
    	gm.update();
    }
    
    public JLayeredPane getMainPanel() {
    	return myPanel;
    }
    
    public void refresh() {
    	myPanel.validate();
    	myPanel.repaint();
    	gamePanel.validate();
    	gamePanel.repaint();
    }
    
    public class ShopButton extends JButton {
    	protected int col;
    	protected ActionListener listenForShopButton;
    	
    	public ShopButton(int c) {
    		col = c;
    		listenForShopButton = new ShopButtonListener();
    		this.addActionListener(listenForShopButton);
    	}
    	
    	public int getCol() {
    		return col;
    	}
    }
    
    public class ShopButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ShopButton jb = (ShopButton)e.getSource();
			control.shopButtonClicked(jb.getCol());
		}
    	
    }
    
    public class GridButton extends JButton {
    	protected int row;
    	protected int col;
    	protected ActionListener listenForGridButton;
    	
    	public GridButton(int r, int c) {
    		super();
    		row = r;
    		col = c;
    		listenForGridButton = new GridButtonListener();
    		this.addActionListener(listenForGridButton);
    	}
    	
    	public int getRow() {
    		return row;
    	}
    	
    	public int getCol() {
    		return col;
    	}
    }
    
    public class GridButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			GridButton ex = (GridButton) e.getSource();
			control.gridButtonClicked(ex.getRow(), ex.getCol());
			System.out.print("clicked");
		}
    	
    }
    
    
}

