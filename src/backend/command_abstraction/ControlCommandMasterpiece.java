// This entire file is part of my masterpiece.
// Alex Boss

/*
 * This class is an abstract superclass that inherits the Command interface. It defines the implementation
 * of a control command like Repeat. One feature that distinguishes this class from other groups' implementations
 * is the robust exception handling. This parsing algorithm can detect the exact type of error committed by the user,
 * more than just a general "you typed something wrong." This interface/inheritance hierarchy combo makes
 * it very easy and intuitive to add a new command. You need only create a new command class that extends
 * the right Command superclass. No lines of code have to be changed anywhere else but the factory. I use
 * the factory design pattern to instantiate a proper command based on the user's input, or throw an
 * exception for an invalid function name. The Repeat class demonstrates how easy it is to add a new class.
 * 
 *  The exception handling is done in the superclass so it does not need to be done every time you make a new
 *  Command. It checks for three conditions automatically. One issue I faced with the group's design was
 *  passing SLogoData around. To get around this and ensure data safety, I have another call to the execute
 *  method that does not pass SLogoData as a parameter, because it is not needed. This way, somebody who is
 *  creating a new Command (like Repeat) cannot accidently alter the program data. 
 *  
 *  I use resource files to store the error messages, which are tailored to the specific error. This way, the
 *  user will get an alert with the exact error he/she committed, which is great for the user experience. 
 */

package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import constants.Constants;

public abstract class ControlCommandMasterpiece implements Command {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		checkConditions(params);
		return execute(params);
	}

	protected abstract double execute(List<ASTNode> params);
	
	protected void checkConditions(List<ASTNode> params) throws IllegalArgumentException {
		checkNumArgs(params);
		checkForBlocks(params);
		checkForVariables(params);
	}

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
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingVariableError") + getClass().getSimpleName());
		}
	}

	protected int indexOfBlock() {
		return 0;
	}

	protected int indexOfVariable() {
		return 0;
	}

	public boolean isMathCommand() {
		return false;
	}

}