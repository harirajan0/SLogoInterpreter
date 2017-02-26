package View;

public class Point {

	private int myX;
	private int myY;
	
	public Point(int x, int y){
		myX = x;
		myY = y;
	}
	
	public int getX(){
		return myX;
	}
	
	public int getY(){
		return myY;
	}
	
	public int getXCoord(){
		//TODO: find out how to calculate so that center of screen is 0,0
		return 0;
	}
	
	public int getYCoord(){
		//TODO: find out how to calculate so that center of screen is 0,0
		return 0;
	}
	
	public Point goPointUp(int amount){
		Point newPoint = new Point(this.myX, this.myY+amount);
		return newPoint;
	}
	
	public Point goPointDown(int amount){
		Point newPoint = new Point(this.myX, this.myY-amount);
		return newPoint;
	}
	
	public Point goPointRight(int amount){
		Point newPoint = new Point(this.myX+amount, this.myY);
		return newPoint;
	}
	
	public Point goPointLeft(int amount){
		Point newPoint = new Point(this.myX-amount, this.myY+1);
		return newPoint;
	}
}
