package thegame;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class Screen extends JFrame {
	private ArrayList<JComponent> myPanels;
	
	public Screen(ArrayList<JComponent> panels) {
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
		
        myPanels = panels;
        
        for(JComponent j : panels) {
        	this.add(j);
        	j.setVisible(false);
        }
        
		this.setVisible(true);
	}
	
	
	public void showPanel(JComponent panel) {
		for(JComponent j : myPanels) {
			if(j == panel) {
				j.setVisible(true);
			} else {
				j.setVisible(false);
			}
		}
	}
	
}
