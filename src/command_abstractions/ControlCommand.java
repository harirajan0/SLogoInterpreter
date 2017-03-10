/**
 * 
 */
package command_abstractions;

import java.util.List;

import ASTNode.ASTNode;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 */
public abstract class ControlCommand implements Command {

	public void checkNumArgs(List<ASTNode> params) throws IllegalArgumentException {
		if (params.size() < getNumArgs()) {
			throw new IllegalArgumentException(
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("TooFewArgumentsError") + getClass().getSimpleName());
		}

	}

	public boolean isMathCommand() {
		return false;
	}
}
