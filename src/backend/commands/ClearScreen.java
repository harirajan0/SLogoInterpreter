/**
 * 
 */
package backend.commands;

import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.command_abstraction.Command;

/**
 * @author harirajan
 *
 */
public class ClearScreen implements Command {

	/* (non-Javadoc)
	 * @see backend.command_abstraction.Command#execute(java.util.List, backend.SLogoData)
	 */
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		slogoData.clearScreen();
		return Math.sqrt((Math.pow(slogoData.getTurtles().get(0).getX() - 200, 2)) + (Math.pow(slogoData.getTurtles().get(0).getY() - 200, 2)));
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.Command#getNumArgs()
	 */
	@Override
	public int getNumArgs() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see backend.command_abstraction.Command#isMathCommand()
	 */
	@Override
	public boolean isMathCommand() {
		// TODO Auto-generated method stub
		return false;
	}

}
