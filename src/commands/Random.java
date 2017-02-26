/**
 * 
 */
package commands;

import java.util.List;

import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Random implements Command {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Random", 1, input.size()));
		}
		if (input.get(0) < 0.0) {
			throw new IllegalArgumentException("Random only takes in a positive number, negative number given");
		}
		return Math.random() * input.get(0);
	}
}
