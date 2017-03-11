/**
 * 
 */
package backend.command_abstraction;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An extension of the Turtle command for turtle commands that take a minimum of 2 arguments
 */
public abstract class TurtleCommandTwoParams extends TurtleCommand {

	@Override
	public int getMinNumArgs() {
		return 2;
	}
	
}
