/**
 * 
 */
package nonTurtle;

import java.util.List;

import commands.Command;
import resources.languages.Resources;

/**
 * @author harirajan
 *
 */
public class Quotient extends NonTurtleCommand {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Quotient", 2, input.size()));
		}
		
		return input.get(0) / input.get(1);
	}
}
