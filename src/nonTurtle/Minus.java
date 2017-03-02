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
public class Minus extends NonTurtleCommand {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Minus", 1, input.size()));
		}
		
		return 0 - input.get(0);
	}
}
