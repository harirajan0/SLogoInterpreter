/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import backend.Variable;
import command_abstractions.Command;
import main.SLogoData;

/**
 * @author harirajan
 *
 */
public class DoTimes implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, main.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		double ret = 0;
		for (int i = 1; i <= params.get(0).getArguments().get(1).evaluate(); i++) {
			slogoData.addVariable(new Variable(params.get(0).getArguments().get(0).getVariableName(), i));
			ret = params.get(1).evaluate();
		}
		slogoData.deleteVariable(params.get(0).getArguments().get(0).getVariableName());
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
