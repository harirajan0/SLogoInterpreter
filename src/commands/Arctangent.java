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
public class Arctangent extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> arguments) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Arctangent", 1, arguments.size()));
		}
		
		return Math.toDegrees(Math.atan(Math.toRadians(arguments.get(0))));
	}

}
