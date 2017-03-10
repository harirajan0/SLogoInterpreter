/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.MathCommandOneParam;

/**
 * @author harirajan
 *
 */
public class Cosine extends MathCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {

		return Math.toDegrees(Math.cos(Math.toRadians(params.get(0))));
	}

}
