/**
 * 
 */
package commands;

/**
 * @author harirajan
 *
 */
public abstract class NoParams implements Command {
	
	@Override
	public int getNumArgs() {
		return 0;
	}
	
	@Override
	public boolean isLogicCommand() {
		return true;
	}
	

}
