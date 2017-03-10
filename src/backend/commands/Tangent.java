/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.MathCommandOneParam;
import backend.turtle.Turtle;
/**
 * @author harirajan
 *
 */
public class Tangent extends MathCommandOneParam {
	
	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List)
	 */
	@Override
	public double execute(List<Double> params) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return Math.toDegrees(Math.tan(Math.toRadians(params.get(0))));
	}


}
