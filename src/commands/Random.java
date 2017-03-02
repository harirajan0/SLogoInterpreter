/**
 * 
 */
package commands;

import java.util.List;


/**
 * @author harirajan
 *
 */
public class Random extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException();
		}
		if (input.get(0) < 0.0) {
			throw new IllegalArgumentException("Random only takes in a positive number, negative number given");
		}
		return Math.random() * input.get(0);
	}
}
