package thegame;

public class GridLocation
{
    private int myRow;
    private int myCol;
    
    public GridLocation(int r, int c)
    {
        myRow = r;
        myCol = c;
    }
    
    public int getRow() {
        return myRow;
    }
    
    public void setRow(int r) {
        myRow = r;
    }
    
    public int getCol() {
        return myCol;
    }
    
    public void setCol(int c) {
        myCol = c;
    }
}
