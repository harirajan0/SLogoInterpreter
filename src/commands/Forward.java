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
public class Forward implements Command {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.lang.Double[])
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Forward", 1, input.size()));
		}
		//turtle.movejjhfughreo
		return input.get(0);
	}

}
