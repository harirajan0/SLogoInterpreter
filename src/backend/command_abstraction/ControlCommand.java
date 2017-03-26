// This entire file is part of my masterpiece.
// Alex Boss

/*
 * This class is an abstract superclass that inherits the Command interface. It defines the implementation
 * of a control command like Repeat. One feature that distinguishes this class from other groups' implementations
 * is the robust exception handling. Our parsing algorithm can detect the exact type of error committed by the user,
 * more than just a general "you typed something wrong." This interface/inheritance hierarchy combo makes
 * it very easy and intuitive to add a new command. You need only create a new command class that extends
 * the right Command superclass. No lines of code have to be changed anywhere else but the factory. I use
 * the factory design pattern to instantiate a proper command based on the user's input, or throw an
 * exception for an invalid function name. The Repeat class demonstrates how easy it is to add a new class. 
 */

package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss An implementation of the Command interface specifically for
 *         control statements like For, If, DoTimes, Repeat IfElse
 */
public abstract class ControlCommand implements Command {

	protected void checkNumArgs(List<ASTNode> params) throws IllegalArgumentException {
		if (params.size() < getMinNumArgs()) {
			throw new IllegalArgumentException(
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("TooFewArgumentsError") + getClass().getSimpleName());
		}
	}

	protected void checkForBlocks(List<ASTNode> params) throws IllegalArgumentException {
		if (!params.get(indexOfBlock()).isBlock()) {
			throw new IllegalArgumentException(
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingBlockError") + getClass().getSimpleName());
		}
	}

	protected void checkForVariables(List<ASTNode> params) throws IllegalArgumentException {
		if (!params.get(indexOfVariable()).isVariable()) {
			throw new IllegalArgumentException(
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingBlockError") + getClass().getSimpleName());
		}
	}

	protected int indexOfBlock() {
		return 1;
	}

	protected int indexOfVariable() {
		return 0;
	}

	public boolean isSimpleEvaluation() {
		return false;
	}

}
