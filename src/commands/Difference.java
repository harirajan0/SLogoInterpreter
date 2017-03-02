/**
 * 
 */
package commands;

import java.util.List;


/**
 * @author harirajan
 *
 */
public class Difference extends LogicCommand {
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> arguments) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (arguments.size() != 2) {
			throw new IllegalArgumentException();
		}
		
		return arguments.get(0) - arguments.get(1);
	}
}
