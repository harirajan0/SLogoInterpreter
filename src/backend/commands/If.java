/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.ControlCommand;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class If extends ControlCommand {


	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		double ret = 0.0;
		if (params.get(0).evaluate() == Constants.TRUE) ret = params.get(1).evaluate();
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 2;
	}

	@Override
	protected List<Integer> indicesOfRequiredBlocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<Integer> indicesOfRequiredVarBlocks() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
