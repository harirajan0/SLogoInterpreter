/**
 * 
 */
package commands;

import java.util.List;

import backend.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Forward implements Command {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.lang.Double[])
	 */
	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException();
		}
		double fwdAmount = arguments.get(0);
		turtle.setX(turtle.getX() + fwdAmount*Math.sin(Math.toRadians(turtle.getHeading())));
		turtle.setY(turtle.getY() - fwdAmount*Math.cos(Math.toRadians(turtle.getHeading())));
		return fwdAmount;
	}

}
