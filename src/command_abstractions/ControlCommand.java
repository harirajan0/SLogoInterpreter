/**
 * 
 */
package command_abstractions;

/**
 * @author harirajan
 *
 */
public abstract class ControlCommand implements Command {
	
	
	public boolean isMathCommand() {
		return false;
	}
}
