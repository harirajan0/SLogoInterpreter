/**
 * 
 */
package backend.command_abstraction;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An extension of the MathCommand for commands that take a minimum of 1 arguments
 */
public abstract class MathCommandOneParam extends MathCommand {

	@Override
	public int getMinNumArgs() {
		return 1;
	}

}
