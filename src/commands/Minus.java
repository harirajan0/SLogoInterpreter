/**
 * 
 */
package commands;

import java.util.List;

/**
 * @author harirajan
 *
 */
public class Minus extends LogicCommand {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 1) {
			throw new IllegalArgumentException();
		}
		
		return 0 - input.get(0);
	}
}
