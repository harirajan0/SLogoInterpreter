/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.TwoParams;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class For extends TwoParams {

	/* (non-Javadoc)
	 * @see commands.Command#execute(commands.ASTNode, commands.ASTNode, commands.ASTNode, commands.ASTNode, backend.TurtleInfo)
	 */
	@Override
	public double execute(List<Double> params, Turtle turtleInfo)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
//		while (arg1.evaluate() < arg2.evaluate()) {
//			arg4.evaluate();
//			arg1.getArg2().setValue(arg1.getArg2().getValue() + arg3.evaluate());
//		}
		return 0;
	}

}
