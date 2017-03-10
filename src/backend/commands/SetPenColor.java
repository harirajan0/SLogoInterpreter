/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;
import constants.Constants;

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

		int index = (int) params.get(0).evaluate();
		
		if(index < 0 || index > 3){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("SetColorError"));
		}
		slogoData.setPenColor(index);
		return index;
	}

	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public boolean isMathCommand() {
		// TODO Auto-generated method stub
		return false;
	}



}
