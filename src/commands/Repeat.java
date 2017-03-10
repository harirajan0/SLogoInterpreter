/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import command_abstractions.Command;
import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class Repeat implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, main.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double limit = params.get(0).evaluate();
		double ret = 0.0;
		while (limit > 0) {
			ret = params.get(1).evaluate();
			limit--;
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see command_abstractions.Command#getNumArgs()
	 */
	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 2;
	}

	/* (non-Javadoc)
	 * @see command_abstractions.Command#isMathCommand()
	 */
	@Override
	public boolean isMathCommand() {
		// TODO Auto-generated method stub
		return false;
	}



}
