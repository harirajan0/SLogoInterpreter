/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.Command;
import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class For implements Command {

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

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, main.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see command_abstractions.Command#getNumArgs()
	 */
	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 5;
	}

}
