/**
 * 
 */
package backend.command_abstraction;

import java.util.List;

import backend.ASTNode;
import resources.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 */
public abstract class ControlCommand implements Command {

	public boolean isMathCommand() {
		return false;
	}
	
	protected abstract List<Integer> indicesOfRequiredBlocks();
	
	protected abstract List<Integer> indicesOfRequiredVariables();
	
	protected void checkNumArgs(List<ASTNode> params) throws IllegalArgumentException {
		if (params.size() < getNumArgs()) {
			throw new IllegalArgumentException(
					Constants.DEFAULT_RESOURCE_BUNDLE.getString("TooFewArgumentsError") + getClass().getSimpleName());
		}
	}

	protected void checkForBlocks(List<ASTNode> params, List<Integer> blockIndices) throws IllegalArgumentException {
		for(Integer index : blockIndices){
			if(!params.get(index).isBlock()){
				throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingBlockError")
						+ getClass().getSimpleName());
			}
		}
	}
	
	protected void checkForVariables(List<ASTNode> params, List<Integer> variableIndices){
		for(Integer index : variableIndices){
			if(!params.get(index).getArguments().get(0).isVariable()){
				throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("MissingVariableError")
						+ getClass().getSimpleName());
			}
		}
	}

	
}
