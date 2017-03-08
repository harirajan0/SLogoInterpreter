/**
 * 
 */
package commands;

/**
 * @author harirajan
 *
 */
public abstract class OneParam implements Command {
	
	@Override
	public int getNumArgs() {
		return 1;
	}

	@Override
	public boolean isLogicCommand() {
		return false;
	}
}
