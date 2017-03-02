/**
 * 
 */
package commands;

import java.util.List;


/**
 * @author harirajan
 *
 */
public class Quotient extends LogicCommand {

	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> input) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (input.size() != 2) {
			throw new IllegalArgumentException();
		}
		
		return input.get(0) / input.get(1);
	}
}
