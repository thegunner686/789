package thegame;
import javax.swing.*;
import java.awt.Dimension;
import java.util.*;

public class GameWorld extends JFrame
{
    private JButton[][] gridButtons;
    private JButton[] shopButtons;
    private JPanel myPanel;
    private Controller control;

    public GameWorld(Controller c)
    {
        myPanel = new JPanel();
        myPanel.setLayout(null);
        control = c;
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gridButtons = new JButton[5][9];
        
        int buttonSize = 50;
        
        for(int i = 4; i >= 0; i--) {
            for(int q = 8; q >= 0; q--) {
                JButton j = new JButton();
                j.setBounds(q * buttonSize + 25, i * buttonSize + 100, buttonSize, buttonSize);
                gridButtons[i][q] = j;
                myPanel.add(j);
            }
        }
      
        
        this.add(myPanel);
        
        this.setVisible(true);
    }
    
    public void updateActor(Actor a) {
    	Grid g = control.getGrid();
    	ArrayList<Actor> al = g.getActorList();
    	
    }
    
    
    
}
