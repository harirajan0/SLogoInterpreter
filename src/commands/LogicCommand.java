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
public abstract class LogicCommand implements Command {
	
	@Override
	public double execute(List<Double> arguments, TurtleInfo turtleInfo) throws IllegalArgumentException {
		return execute(arguments);
	}

	public abstract double execute(List<Double> input) throws IllegalArgumentException;
}
