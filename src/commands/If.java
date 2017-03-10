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
 * @author Alex Boss
 */
public class If extends ControlCommand {


	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		double ret = 0.0;
		if (params.get(0).evaluate() == 1) ret = params.get(1).evaluate();
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 2;
	}

	

}
