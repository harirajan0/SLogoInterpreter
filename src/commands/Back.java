package commands;

import java.util.List;

import backend.TurtleInfo;

/**
 * 
 * @author Alex Boss
 *
 */
public class Back implements Command{

	@Override
	public double execute(List<Double> arguments, TurtleInfo turtle) throws IllegalArgumentException {
		if (arguments.size() != 1) {
			throw new IllegalArgumentException();
		}
		double backAmount = arguments.get(0);
		turtle.setX(turtle.getX() - backAmount*Math.sin(Math.toRadians(turtle.getHeading())));
		turtle.setY(turtle.getY() + backAmount*Math.cos(Math.toRadians(turtle.getHeading())));
		return backAmount;
	}

}
