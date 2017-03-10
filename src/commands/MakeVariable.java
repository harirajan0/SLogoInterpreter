/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.Variable;
import command_abstractions.Command;

/**
 * @author harirajan
 *
 */
public class MakeVariable implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, main.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		slogoData.addVariable(new Variable(params.get(0).getVariableName(), params.get(1).evaluate()));
		return 0.0;
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
