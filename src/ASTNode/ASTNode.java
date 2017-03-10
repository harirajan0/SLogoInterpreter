/**
 * 
 */
package ASTNode;

import java.util.List;

import backend.Variable;
import command_abstractions.Command;
import main.SLogoData;

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

	public double getValue() {
		return myValue;
	}

	public void setValue(double newValue) {
		myValue = newValue;
	}

	public String toString() {
		if (isBlock) {
			return "BLOCK: " + myArguments.toString();
		}
		if (myCommand != null)
			return myCommand.getClass().getName();
		return String.valueOf(myValue);
	}

	public boolean hasMathValue() {
		if (myCommand == null)
			return true;
		return myCommand.isMathCommand();
	}

	public String getVariableName() {
		return myVariableName;
	}

	public List<ASTNode> getArguments() {
		return myArguments;
	}

	public void print() {
		System.out.println();
		System.out.println(this);
		System.out.println(this.myArguments);
	}	
	public double runAsFunction() {
		for (int i = 0; i < myArguments.get(0).getArguments().size(); i++) {
			mySlogoData.addVariable( new Variable(myArguments.get(0).getArguments().get(i).getVariableName(), 
												myArguments.get(2).getArguments().get(i).evaluate()));
		}
		double ret = myArguments.get(1).evaluate();
		for (int i = 0; i < myArguments.get(0).getArguments().size(); i++) {
			mySlogoData.deleteVariable(myArguments.get(0).getArguments().get(i).getVariableName());
		}
		return ret;
	}

	public String getFunctionName() {
		return myFunctionName;
	}
	
	public void addArgument(ASTNode toAdd) {
		myArguments.add(toAdd);
	}
}
