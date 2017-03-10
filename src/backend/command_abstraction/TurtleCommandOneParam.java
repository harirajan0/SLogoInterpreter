/**
 * 
 */
package backend.command_abstraction;

/**
 * @author harirajan
 *
 */
public abstract class TurtleCommandOneParam extends TurtleCommand {

	@Override
	public int getNumArgs() {
		return 1;
	}
}
