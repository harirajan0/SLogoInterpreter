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
public class Power extends NonTurtleCommand {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException(String.format(
					"%s command takes exactly %d argument, %d given", "Power", 2, input.size()));
		}
		return Math.pow(input.get(0), input.get(1));
	}

}
