/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.MathCommandOneParam;
import turtle.Turtle;
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
