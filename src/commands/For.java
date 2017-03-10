/**
 * 
 */
package commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.Variable;
import command_abstractions.ControlCommand;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class For extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {

		checkNumArgs(params);

		if (!params.get(0).isBlock()) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("ForBlockError"));
		}
		
		if (params.get(0).getArguments().get(0).getVariableName() == null) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("ForNoVariableError"));
		}
		double ret = 0;
		for (double i = params.get(0).getArguments().get(1).evaluate(); i < params.get(0).getArguments().get(2)
				.evaluate(); i += params.get(0).getArguments().get(3).evaluate()) {
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
