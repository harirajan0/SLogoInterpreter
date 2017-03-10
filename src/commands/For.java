/**
 * 
 */
package commands;

import java.util.List;

import ASTNode.ASTNode;
import backend.Variable;
import command_abstractions.ControlCommand;
import main.SLogoData;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class For extends ControlCommand {


	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		double ret = 0;
		for (double i = params.get(0).getArguments().get(1).evaluate();
				i < params.get(0).getArguments().get(2).evaluate(); 
				i += params.get(0).getArguments().get(3).evaluate()) {
			slogoData.addVariable(new Variable(params.get(0).getArguments().get(0).getVariableName() , i));
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
