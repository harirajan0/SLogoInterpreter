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
public interface Command {
	
	public double execute(List<Double> arguments, TurtleInfo turtleInfo) throws IllegalArgumentException;
	
}
