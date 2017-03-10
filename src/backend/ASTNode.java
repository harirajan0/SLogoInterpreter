/**
 * 
 */
package backend;

import java.util.List;

import backend.command_abstraction.Command;

/**
 * @author harirajan
 * @author Alex Boss
 */
public class ASTNode {

	private Command myCommand;
	private String myVariableName;
	private String myFunctionName;
	private double myValue;
	private SLogoData mySlogoData;
	private boolean isBlock;
	private List<ASTNode> myArguments;	
	
	public ASTNode(Command command, String variableName, String functionName, double value,
			List<ASTNode> arguments, SLogoData slogoData, boolean isBlock) {
		myCommand = command;
		myVariableName = variableName;
		myFunctionName = functionName;
		myValue = value;
		myArguments = arguments;
		mySlogoData = slogoData;
		this.isBlock = isBlock;
	}

	public double evaluate() {
		if (isBlock) {
			return myArguments.get(0).evaluate();
		}
		if (myFunctionName != null) {
			if (myArguments.size() > 2) {
				return runAsFunction();
			}
			else { return 0.0; }
		}
		if (myVariableName != null) {
			if (mySlogoData.getVariable(myVariableName) != null) {
				return mySlogoData.getVariable(myVariableName).getValue();
			} else {
				return 0.0; // THROW EXCEPTION FOR NOT BEING ABLE TO FIND
							// VARIABLE
			}
		}
		if (myCommand == null)
			return myValue; // if its a double
		return myCommand.execute(myArguments, mySlogoData);
	}

	public Command getCommand() {
		return myCommand;
	}

	protected boolean hasMathValue() {
		if (myCommand == null)
			return true;
		return myCommand.isMathCommand();
	}
	
	public boolean isBlock(){
		return isBlock;
	}
	
	public boolean isVariable(){
		return (myVariableName != null);
	}

	public String getVariableName() {
		return myVariableName;
	}

	public List<ASTNode> getArguments() {
		return myArguments;
	}

	private double runAsFunction() {
		for (int i = 0; i < myArguments.get(0).getArguments().size(); i++) {
			mySlogoData.addVariable( new Variable(myArguments.get(0).getArguments().get(i).getVariableName(), 
												myArguments.get(2).getArguments().get(i).evaluate()));
		}
		double ret = myArguments.get(1).evaluate();
		for (int i = 0; i < myArguments.get(0).getArguments().size(); i++) {
			mySlogoData.deleteVariable(myArguments.get(0).getArguments().get(i).getVariableName());
		}
		myArguments.remove(2);
		return ret;
	}

	protected String getFunctionName() {
		return myFunctionName;
	}
	
	protected void addArgument(ASTNode toAdd) {
		myArguments.add(toAdd);
	}
}
