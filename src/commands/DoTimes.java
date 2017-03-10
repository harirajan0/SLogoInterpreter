/**
 * 
 */
package commands;

import java.util.ArrayList;
import java.util.List;

import ASTNode.ASTNode;
import backend.Variable;
import command_abstractions.ControlCommand;
import constants.Constants;
import main.SLogoData;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class DoTimes extends ControlCommand {

	@Override
	public double execute(List<ASTNode> params, SLogoData slogoData) throws IllegalArgumentException {
		
		checkNumArgs(params);
		checkForBlocks(params, indicesOfRequiredBlocks());
		checkForVariables(params, indicesOfRequiredVariables());
		
		double iterations = params.get(0).getArguments().get(1).evaluate();
		if (iterations < 0 ) {
			throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("DoTimesNegativeError"));
		}
		
		double ret = 0;
		for (int i = 1; i < iterations; i++) {
			slogoData.addVariable(new Variable(params.get(0).getArguments().get(0).getVariableName(), i));
			ret = params.get(1).evaluate();
		}
		slogoData.deleteVariable(params.get(0).getArguments().get(0).getVariableName());
		return ret;
	}

	@Override
	public int getNumArgs() {
		return 2;
	}

	@Override
	protected List<Integer> indicesOfRequiredBlocks() {
		List<Integer> blocks = new ArrayList<Integer>();
		blocks.add(0); blocks.add(1);
		return blocks;
	}

	@Override
	protected List<Integer> indicesOfRequiredVariables() {
		List<Integer> vars = new ArrayList<Integer>();
		vars.add(0);
		return vars;
	}

}
