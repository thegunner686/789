package thegame;
public class Controller
{
    private GameWorld gw;
    private Grid myGrid;

    public Grid getGrid() {
    	return myGrid;
    }
    
    public Controller()
    {
    	
    }

    public void startGame() {
        gw = new GameWorld(this);
        myGrid = new Grid(5, 9);
    }
    
    public static void main(String[] args) {
        Controller myGame = new Controller();
        
        myGame.startGame();
    }
}
