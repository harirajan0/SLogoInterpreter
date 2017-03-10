/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;

/**
 * @author harirajan
 *
 */
public class SetPenColor implements Command {

	/* (non-Javadoc)
	 * @see command_abstractions.Command#execute(java.util.List, backend.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		//ALEX THROW EXPCETION IS PARAMS.GET(0).EVALUATE() IS NOT 0,1,2,3
		int index = (int) params.get(0).evaluate();
		slogoData.setPenColor(index);
		return index;
	}

	/* (non-Javadoc)
	 * @see command_abstractions.Command#getNumArgs()
	 */
	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 1;
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
