/**
 * 
 */
package commands;

/**
 * @author harirajan
 *
 */
public class TurtleInfo {
	public static final int BOUNDS = 100;
	public static final int NEG_BOUNDS = 0;
	
	private double x;
	private double y;
	private double heading;
	private boolean penDown;
	private boolean visible;
	
	public TurtleInfo() {
		x = 0;
		y = 0;
		heading = 0;
		penDown = true;
		visible = true;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getHeading() {
		return heading;
	}
	public boolean isPenDown() {
		return penDown;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setX(double newX) {
		if (newX >= NEG_BOUNDS && newX <= BOUNDS) {
			x = newX;
		} else {
			x = BOUNDS;
		}
	}
	public void setY(double newY) {
		if (newY >= NEG_BOUNDS && newY <= BOUNDS) {
			y = newY;
		} else {
			y = BOUNDS;
		}
	}
	public void setHeading(double newHeading) {
		if (newHeading >= 0 && newHeading <= 360) {
			heading = newHeading;
		} else {
			heading = newHeading % 360;
		}
	}
	public void setPenDown(boolean upOrDown) {
		penDown = upOrDown;
	}
	public void setVisible(boolean hiddenOrShown) {
		visible = hiddenOrShown;
	}
}