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
public class Cosine extends LogicCommand {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> arguments) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (arguments.size() != 1) {
			throw new IllegalArgumentException(String.format(
					Resources.getString("English", "IllegalArgumentException"), "Cosine", 1, arguments.size()));
		}
		
		return Math.toDegrees(Math.cos(Math.toRadians(arguments.get(0))));
	}
}
