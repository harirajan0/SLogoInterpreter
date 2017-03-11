/**
 * 
 */
package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;

/**
 * @author harirajan
 * @author Alex Boss
 * This interfaces provides 3 methods that all commands must implement. 
 */
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
	 * @return A boolean that represents whether this command is mathematical or not
	 */
	public boolean isMathCommand();
	
}
