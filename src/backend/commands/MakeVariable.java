/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.Variable;
import backend.command_abstraction.Command;

/**
 * @author harirajan
 *
 */
public class MakeVariable implements Command {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {

		slogoData.addVariable(new Variable(params.get(0).getVariableName(), params.get(1).evaluate()));
		return 0.0;
	}

	@Override
	public int getMinNumArgs() {

		return 2;
	}

	@Override
	public boolean isSimpleEvaluation() {

		return false;
	}

}
