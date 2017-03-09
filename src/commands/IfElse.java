/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.Command;
import main.SLogoData;

/**
 * @author harirajan
 *
 */
public class IfElse implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, main.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double ret = 0.0; 
		if (params.get(0).evaluate() == 1.0) {
			ret = params.get(1).evaluate();
		} else {
			ret = params.get(2).evaluate();
		}
		return ret;
	}

	/* (non-Javadoc)
	 * @see command_abstractions.Command#getNumArgs()
	 */
	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 3;
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
