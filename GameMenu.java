package thegame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameMenu extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel myPanel;
	JButton startButton;
	Controller control;

	public GameMenu(Controller t) {
        this.setSize(new Dimension(600, 600));
        
		myPanel = new JPanel();
		myPanel.setOpaque(true);
		
		control = t;
		
		startButton = new JButton("Start Game");
		StartButtonListener lForStart = new StartButtonListener();
		startButton.addActionListener(lForStart);
		
		myPanel.add(startButton);
		
		add(myPanel);
		
	}
	
	public class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			control.startGame();
		}
		
	}
}
