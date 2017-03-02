/**
 * 
 */
package nonTurtle;

import java.util.List;

import commands.Command;

/**
 * @author harirajan
 *
 */
public class Log extends NonTurtleCommand {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException(String.format(
					"%s command takes exactly %d argument, %d given", "Log", 1, input.size()));
		}
		return Math.log(input.get(0));
	}

}
