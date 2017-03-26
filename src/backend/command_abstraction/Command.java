// This entire file is part of my masterpiece.
// Alex Boss

/*
 * This design takes advantage of interfaces and inheritance simultaneously. This interface prescribes 
 * 3 methods that all commands must implement. The reason this is useful is because we can now classify
 * all commands - math, turtle, and control - under the umbrella of "Command." This allows us to work
 * with Commands abstractly without knowing which specific type. This interface reduces duplicated code
 * and makes it easy for somebody to add new commands. This interface is implemented by the abstract super-
 * classes like ControlCommandMasterpiece (featured in this masterpiece) or their subclasses. 
 * 
 * My masterpiece makes use of the Command and Factory design patterns. 
 */

package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;


public interface Command {
	
	/**
	 * 
	 * @param params Parameters of this command in the form of a List of ASTNodes 
	 * @param slogoData The current information about the program
	 * @return A double value that is the return value of the executed command with the given parameters
	 * @throws IllegalArgumentException If this command does not receive proper parameters
	 */
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException;
	
	/**
	 * 
	 * @return The minimum number of arguments that this command must receive
	 */
	public int getMinNumArgs();
	
	/**
	 * 
	 * @return A boolean that represents whether, in the context of the ASTNode parsing algorithm,
	 * this command evaluates simply
	 */
	public boolean isSimpleEvaluation();
	
}
