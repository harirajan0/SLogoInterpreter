/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.ControlCommand;

/**
 * @author harirajan
 * @author Alex Boss
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
