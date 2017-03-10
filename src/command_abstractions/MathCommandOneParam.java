/**
 * 
 */
package command_abstractions;

/**
 * @author harirajan
 *
 */
public abstract class MathCommandOneParam extends MathCommand {

	@Override
	public int getNumArgs() {
		return 1;
	}

}
