/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class Repeat extends TwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(commands.ASTNode, commands.ASTNode, commands.ASTNode, commands.ASTNode, backend.TurtleInfo)
	 */
	@Override
	public double execute(List<Double> params, Turtle turtle)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double limit = params.get(0);
		while (limit > 0) {
//			arg2.evaluate();
//			arg1.setValue(arg1.getValue() - 1);
		}
		return 0;
	}


}
