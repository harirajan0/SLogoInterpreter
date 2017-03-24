/**
 * 
 */
package backend.command_abstraction;

import java.util.ArrayList;
import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import backend.turtle.Turtle;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An implementation of the Command interface for commands that specifically affect the turtle, like
 * Forward and Right
 */
public abstract class TurtleCommand implements Command {
	
	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
		if(params.size() < getMinNumArgs()){
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("TooFewArgumentsError") +
					getClass().getSimpleName());
		}
		
		List<Double> paramList = new ArrayList<>();
		List<ASTNode> evaluateList = new ArrayList<>();		
		for (int i = 0; i < params.size(); i++) {
			if (i >= getMinNumArgs()) {
				if (params.get(i).getCommand() != null) {
					if (!params.get(i).getCommand().isMathCommand()) { //change string to constant
						evaluateList.add(params.get(i));
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
