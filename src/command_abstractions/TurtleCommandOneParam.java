/**
 * 
 */
package command_abstractions;

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
