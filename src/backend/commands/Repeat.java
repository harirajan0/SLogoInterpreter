// This entire file is part of my masterpiece.
// Alex Boss

/*
 * This class demonstrates how easy it is to add a new command. This shows off the principle of flexibility
 * and the open/closed principle. No class needs to be modified when adding a new command (closed), but
 * the command hierarchy is open to extension, as shown here. 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.command_abstraction.ControlCommandMasterpiece;

/**
 * @author Alex Boss
 *
 */
public class Repeat extends ControlCommandMasterpiece {

	@Override
	public double execute(List<ASTNode> params) throws IllegalArgumentException {

		double limit = params.get(0).evaluate();
		double ret = 0.0;
		while (limit > 0) {
			ret = params.get(1).evaluate();
			limit--;
		}
		return ret;
	}
}
