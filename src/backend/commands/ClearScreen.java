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

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		slogoData.clearScreen();
		return Math.sqrt((Math.pow(slogoData.getTurtles().get(0).getX() - 200, 2)) + (Math.pow(slogoData.getTurtles().get(0).getY() - 200, 2)));
	}


	@Override
	public int getMinNumArgs() {
		return 0;
	}

	@Override
	public boolean isSimpleEvaluation() {
		return false;
	}

}
