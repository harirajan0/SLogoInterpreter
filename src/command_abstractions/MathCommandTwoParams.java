/**
 * 
 */
package command_abstractions;
 
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
