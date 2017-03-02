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
public class Difference extends LogicCommand {
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> arguments) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (arguments.size() != 2) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Difference", 2, arguments.size()));
		}
		
		return arguments.get(0) - arguments.get(1);
	}
}
