/**
 * 
 */
package backend;

/**
 * @author harirajan
 *
 */
public class TurtleInfo {
	public static final int BOUNDS = 99999;
	public static final int NEG_BOUNDS = -99999;
	
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
		if (newHeading >= 0) {
			heading = newHeading % 360;
		} else {
			heading = 360 + newHeading;
		}
	}
	public void setPenDown(boolean upOrDown) {
		penDown = upOrDown;
	}
	public void setVisible(boolean hiddenOrShown) {
		visible = hiddenOrShown;
	}
	
	public String toString() {
		return String.format("X: %f; Y: %f, Heading: %f; penDown: %b; visible: %b", x, y, heading, penDown, visible);
	}
}