/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public interface Command {
	
	public double execute(List<Double> list) throws IllegalArgumentException;

}
