/**
 * 
 */
package backend.command_abstraction;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An extension of the Turtle command for turtle commands that take a minimum of 1 arguments
 */
public abstract class TurtleCommandOneParam extends TurtleCommand {

	@Override
	public int getMinNumArgs() {
		return 1;
	}
}
