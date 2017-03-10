/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import command_abstractions.MathCommandOneParam;


/**
 * @author harirajan
 *
 */
public class Arctangent extends MathCommandOneParam {

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.atan(Math.toRadians(params.get(0))));
	}
	
}
