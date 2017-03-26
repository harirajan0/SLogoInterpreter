/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;

/**
 * @author harirajan
 *
 */
public class MakeUserInstruction implements Command {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {

		slogoData.addFunction(params.get(0));
		return 0;
	}

	@Override
	public int getMinNumArgs() {

		return 1;
	}

	@Override
	public boolean isSimpleEvaluation() {

		return false;
	}

}
