/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import command_abstractions.ControlCommand;

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



}
