/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public class Remainder extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException();
		}
		double result = input.get(0);
		while ((result - input.get(1)) >= 0.0) result -= input.get(1);
		return result;
	}
}
