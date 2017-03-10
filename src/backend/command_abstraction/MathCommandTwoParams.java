/**
 * 
 */
package backend.command_abstraction;
 
/**
 * @author harirajan
 *
 */
public abstract class MathCommandTwoParams extends MathCommand {
	
	@Override
	public int getNumArgs() {
		return 2;
	}

}
