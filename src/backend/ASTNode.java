/**
 * 
 */
package backend;

import java.util.List;

import backend.command_abstraction.Command;
import constants.Constants;

/**
 * @author harirajan
 * @author Alex Boss
 * 
 * This class is a node of the abstract syntax tree. It contains information about itself (whether it 
 * represents a double value, a variable, or a command) and it also contains a List<ASTNode> of arguments.
 * Subtrees are evaluated recursively from the head node. 
 */
public class ASTNode {

	private Command myCommand;
	private String myVariableName;
	private String myFunctionName;
	private double myValue;
	private SLogoData mySlogoData;
	private boolean isBlock;
	private List<ASTNode> myArguments;	
	
	/**
	 * 
	 * @param command The command this node represents (if applicable) 
	 * @param variableName The name of the variable this node represents (if applicable) 
	 * @param functionName The name of the function this node represents (if applicable) 
	 * @param value The double value of this node (if applicable) 
	 * @param arguments The arguments to this node's function (if applicable) 
	 * @param slogoData The data of the program
	 * @param isBlock A boolean representing whether this node represents a "block" (a set of things between brackets)
	 */
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

	/**
	 * 
	 * @return The double value of the recrusively calculated value of this node. Returns its own double value
	 * if this node is a double or variable, else evaluates this node's function with its parameters. 
	 */
	public double evaluate() {
		print();
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
				throw new IllegalArgumentException(Constants.DEFAULT_RESOURCE_BUNDLE.getString("VariableNotFoundError"));
			}
		}
		if (myCommand == null)
			return myValue;
		return myCommand.execute(myArguments, mySlogoData);
	}

	/**
	 * 
	 * @return The command this node represents, or null.
	 */
	public Command getCommand() {
		return myCommand;
	}

	protected boolean hasMathValue() {
		if (isBlock) return false;
		if (myCommand == null)
			return true;
		return myCommand.isMathCommand();
	}
	
	/**
	 * 
	 * @return A boolean representing whether this node is a block expression
	 */
	public boolean isBlock(){
		return isBlock;
	}
	
	/**
	 * 
	 * @return A boolean representing whether this node represents a variable
	 */
	public boolean isVariable(){
		return (myVariableName != null);
	}

	/**
	 * 
	 * @return The name of the variable this node represents (if applicable) 
	 */
	public String getVariableName() {
		return myVariableName;
	}

	/**
	 * 
	 * @return A list of this node children, or the arguments to its command (if applicable) 
	 */
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
	
	private void print() {
		System.out.println();
		System.out.println(this);
		System.out.println(this.myArguments);
	}
}
