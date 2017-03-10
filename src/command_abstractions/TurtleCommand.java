/**
 * 
 */
package command_abstractions;

import java.util.ArrayList;
import java.util.List;

import backend.ASTNode;
import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public abstract class TurtleCommand implements Command {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		List<Double> paramList = new ArrayList<>();
		List<ASTNode> evaluateList = new ArrayList<>();		
		for (int i = 0; i < params.size(); i++) {
			if (i >= getNumArgs()) {
				if (params.get(i).getCommand() != null) {
					if (!params.get(i).getCommand().isMathCommand()) { //change string to constant
						evaluateList.add(params.get(i));
						continue;
					}
				}
			}
			paramList.add(params.get(i).evaluate());
		}
		double ret = slogoData.runCommand(this, paramList);
		for (ASTNode node : evaluateList) node.evaluate();
		return ret;
	}
	
	@Override
	public boolean isMathCommand() {
		return false;
	}
	
	public abstract double execute(List<Double> params, Turtle turtle);

}
