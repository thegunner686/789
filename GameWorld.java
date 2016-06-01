package thegame;
import javax.swing.*;
//import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GameWorld extends JLayeredPane
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Actor, GameObject> gameObjects;
    private GridButton[][] gridButtons;
    private JButton[] shopButtons;
    private Controller control;
    private JLabel shopTotal;
    private JButton pauseButton;

    public GameWorld(Controller c)
    {
    	gameObjects = new HashMap<Actor, GameObject>();
        this.setLayout(null);
        this.setOpaque(true);
        control = c;
        
        
        pauseButton = new JButton("Pause Game");
        pauseButton.setBounds(400, 20, 150, 50);
        PauseButtonListener listenForPause = new PauseButtonListener();
        pauseButton.addActionListener(listenForPause);
        this.add(pauseButton);
        
        shopTotal = new JLabel("0");
        shopTotal.setBounds(300, 0, 70, 50);
        
        this.add(shopTotal);
        
        gridButtons = new GridButton[5][9];
        shopButtons = new JButton[6];
        
        for(int i = 0; i < shopButtons.length; i++) {
        	ShopButton j = new ShopButton(i);
        	j.setBounds(i * 50, 0, 50, 50);
        	j.setBorder(new LineBorder(Color.BLACK, 2));
        	j.setMargin(new Insets(0, 0, 0, 0));
        	shopButtons[i] = j;
        	this.add(j);
        	CoverButton jb = new CoverButton(i);
        	jb.setBounds(i * 50, 0, 50, 50);
        	jb.setBorder(new LineBorder(Color.BLACK, 0));
        	jb.setMargin(new Insets(0, 0, 0, 0));
        	jb.setVisible(false);
        	this.add(jb);
        }
        	shopButtons[0].setIcon(control.getImageLoader().getImage(new Integer(12)));
        	
        	shopButtons[1].setIcon(control.getImageLoader().getImage(new Integer(13)));
        	shopButtons[2].setIcon(control.getImageLoader().getImage(new Integer(8)));
        	shopButtons[3].setIcon(control.getImageLoader().getImage(new Integer(10)));
        	shopButtons[4].setIcon(control.getImageLoader().getImage(new Integer(14)));
        	shopButtons[5].setIcon(control.getImageLoader().getImage(new Integer(6)));
        
        int buttonSize = 50;
        
        for(int i = 0; i < 5; i++) {
            for(int q = 0; q < 9; q++) {
                GridButton j = new GridButton(i, q);
                j.setBounds(q * buttonSize + 25, i * buttonSize + 100, buttonSize, buttonSize);
                j.setMargin(new Insets(0, 0, 0, 0));
                j.setBorderPainted(false);
                //j.setBorder(null);
                gridButtons[i][q] = j;
                this.add(j);
            }
        }
        
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
    
    public void updateShopTotal(int t) {
    	shopTotal.setText("" + t);
    }
    
    public void updateActor(Actor a) {
    	if(a.getGrid() == null) {
    		GameObject gm = gameObjects.remove(a);
    		if(gm != null) {
    			if(a instanceof Plant) {
    				((JButton)gm.getComponent()).setIcon(null);
    			} else {
    				gm.getComponent().setVisible(false);
    			}
    		}
    	} else {
    	GameObject gm = gameObjects.get(a);
    	if(gm != null)
    		gm.update();
    	else
    		System.out.println("THERE WAS A NULL GAME OBJECT");
    	}
    }
    
    public void refresh() {
    	validate();
    	repaint();
    }
    
    public class CoverButton extends JButton {
		private static final long serialVersionUID = 1L;
		protected int col;
		protected double height;
    	
    	public CoverButton(int c) {
    		col = c;
    		height = 50.0;
    	}
    	
    	public int getCol() {
    		return col;
    	}
    	
    	public void decrement() {
    		height -= 0.5;
    	}
    	
    	public int getRealHeight() {
    		return (int) height / 3;
    	}
    	
    	public void setHeight(double h) {
    		height = h;
    	}
    }
    
    public class ShopButton extends JButton {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
			if(!control.isRunning())
				return;
			ShopButton jb = (ShopButton)e.getSource();
			for(int q = 0; q < shopButtons.length; q++) {
				shopButtons[q].setBorder(new LineBorder(Color.BLACK, 2));
			}
			jb.setBorder(new LineBorder(Color.YELLOW, 5));
			control.shopButtonClicked(jb.getCol());
		}
    	
    }
    
    public class GridButton extends JButton {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
			if(!control.isRunning())
				return;
			GridButton ex = (GridButton) e.getSource();
			control.gridButtonClicked(ex.getRow(), ex.getCol());
			System.out.print("clicked");
		}
		
    	
    }
    
    public class PauseButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton j = (JButton) e.getSource();
			if(j.getText().equals("Pause Game")) {
				j.setText("Unpause Game");
				control.pause();
			} else {
				j.setText("Pause Game");
				control.unpause();
			}
		}
    	
    }
    
    public ActionListener getCurrencyActionListener() {
    	return new CurrencyListener();
    }
    
    public class CurrencyListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(!control.isRunning())
				return;
			control.currencyClicked(((SpecialButtons.CurrencyButton)e.getSource()).getObject().getActor());
		}
    	
    }
    
    public class drawPanel extends JLayeredPane {
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
        	super.paintComponent(g);
        	Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        	g2.setColor(Color.GREEN);
        	g2.fillRect(25, 100, 450, 250);
        	g2.setColor(Color.BLACK);
        	for(int i = 0; i <= 9; i++) {
        		g2.drawLine(i * 50 + 25, 100, i * 50 + 25, 350);
        	}
        	for(int i = 0; i <= 5; i++) {
        		g2.drawLine(25, i * 50 + 100, 475, i * 50 + 100);
        	}
    	}
    	
    }
    
    public void displayGameOver() {
    	this.setVisible(false);
    	JPanel gameOverScreen = new JPanel();
    	gameOverScreen.setBounds(100, 100, 400, 400);
    	JLabel gmo = new JLabel("GAME OVER");
    	gmo.setBounds(0, 0, 100, 100);
    	gameOverScreen.add(gmo);
    	JButton restartButton = new JButton("Play Again");
    	restartButton.setBounds(100, 100, 100, 100);
    	ListenForPlayAgain playAgainListener = new ListenForPlayAgain();
    	restartButton.addActionListener(playAgainListener);
    	gameOverScreen.add(restartButton);
    	this.add(gameOverScreen);
    	repaint();
    }
    
    
    public class ListenForPlayAgain implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			control.restartGame();
		}
    	
    }
    
}

