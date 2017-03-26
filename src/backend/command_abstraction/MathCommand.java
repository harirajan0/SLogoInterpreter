/**
 * 
 */
package backend.command_abstraction;

import java.util.ArrayList;
import java.util.List;

import backend.ASTNode;
import backend.SLogoData;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * An implementation of the Command interface specifically for mathematical functions like Sum and Product
 */
public abstract class MathCommand implements Command {

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
					if (!params.get(i).getCommand().isSimpleEvaluation()) {
						evaluateList.add(params.get(i));
						continue;
					}
				}
			}
			paramList.add(params.get(i).evaluate());
		}
		double ret = execute(paramList);
		for (ASTNode node : evaluateList) node.evaluate();
		return ret;
	}
	
	@Override
	public boolean isSimpleEvaluation() {
		return true;
	}
	
	protected abstract double execute(List<Double> params) throws IllegalArgumentException;
	
}
