/**
 * 
 */
package command_abstractions;

import java.util.ArrayList;
import java.util.List;

import ASTNode.ASTNode;
import main.SLogoData;
import turtle.Turtle;

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
