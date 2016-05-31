package thegame;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameMenu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel myPanel;
	JButton startButton;
	Object tester;

	public GameMenu(Object t) {
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		myPanel = new JPanel();
		myPanel.setOpaque(true);
		
		tester = t;
		
		startButton = new JButton("Start Game");
		StartButtonListener lForStart = new StartButtonListener();
		startButton.addActionListener(lForStart);
		
		myPanel.add(startButton);
		
		add(myPanel);
		
		setVisible(true);
	}
	
	public class StartButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
}
