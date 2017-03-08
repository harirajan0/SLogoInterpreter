/**
 * 
 */
package commands;

/**
 * @author harirajan
 *
 */
public abstract class TwoParams implements Command {
	
	@Override 
	public int getNumArgs() {
		return 2;
	}
	
	@Override
	public boolean isLogicCommand() {
		return true;
	}

}
