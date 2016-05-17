package thegame;

public class PixelLocation
{
    private double myX;
    private double myY;
    public PixelLocation(int x, int y)
    {
        myX = x;
        myY = y;
    }
    
    public double getX() {
        return myX;
    }
    
    public void setX(int x) {
        myX = x;
    }
    
    public double getY() {
        return myY;
    }
    
    public void setY(int y) {
        myY = y;
    }
    
    public void incrementX(double d) {
    	this.myX += d;
    }
    
    public void incrementY(double d) {
    	this.myY += d;
    }
    
    private double distanceTo(PixelLocation p){
        return Math.sqrt(Math.pow(p.getX() - myX, 2) + Math.pow(p.getY() - myY, 2));
    }
    
    public boolean withinRange(PixelLocation p, int range) {
        return (int) distanceTo(p) <= range;
    }
}
