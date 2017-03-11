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
public class Turtles implements Command {


	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		return slogoData.getNumTurtles();
	}


	@Override
	public int getMinNumArgs() {
		return 0;
	}

	@Override
	public boolean isMathCommand() {
		return false;
	}

}
