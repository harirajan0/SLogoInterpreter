/**
 * 
 */
package backend.commands;

import java.util.ArrayList;
import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.ControlCommand;

/**
 * @author harirajan
 *
 */
public class Repeat extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
		checkNumArgs(params);
		
		double limit = params.get(0).evaluate();
		
		if(limit < 0 ){
			throw new IllegalArgumentException();
		}
		
		double ret = 0.0;
		while (limit > 0) {
			ret = params.get(1).evaluate();
			limit--;
		}
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 2;
	}

	@Override
	public boolean isMathCommand() {
		return false;
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.ControlCommand#indicesOfRequiredBlocks()
	 */
	@Override
	protected List<Integer> indicesOfRequiredBlocks() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.ControlCommand#indicesOfRequiredVariables()
	 */
	@Override
	protected List<Integer> indicesOfRequiredVariables() {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}



}
