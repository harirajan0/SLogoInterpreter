/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import command_abstractions.ControlCommand;
import main.SLogoData;

/**
 * @author harirajan
 *
 */
public class Repeat extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
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
