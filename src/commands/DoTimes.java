/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import backend.Variable;
import command_abstractions.Command;
import command_abstractions.ControlCommand;
import constants.Constants;
import main.SLogoData;

/**
 * @author harirajan
 *
 */
public class DoTimes extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
		checkNumArgs(params);
		
		double iterations = params.get(0).getArguments().get(1).evaluate();
		if (iterations < 0 ) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("DoTimesError"));
		}
		
		
	
		double ret = 0;
		for (int i = 1; i < iterations; i++) {
			slogoData.addVariable(new Variable(params.get(0).getArguments().get(0).getVariableName(), i));
			ret = params.get(1).evaluate();
		}
		slogoData.deleteVariable(params.get(0).getArguments().get(0).getVariableName());
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 2;
	}

}
