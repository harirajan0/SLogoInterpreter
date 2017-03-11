/**
 * 
 */
package backend.command_abstraction;
 
/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An extension of the MathCommand for commands that take a minimum of 2 arguments
 */
public abstract class MathCommandTwoParams extends MathCommand {
	
	@Override
	public int getMinNumArgs() {
		return 2;
	}

}
