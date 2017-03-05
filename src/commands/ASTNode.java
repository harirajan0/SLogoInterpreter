/**
 * 
 */
package commands;

import backend.TurtleInfo;
import backend.Variable;

/**
 * @author harirajan
 *
 */
public class ASTNode {
	
	Command myCommand;
	Variable myVariable;
	double myValue;
	ASTNode myArg1;
	ASTNode myArg2;
	ASTNode myArg3;
	ASTNode myArg4;
	
	ASTNode[] myArgs = { myArg1, myArg2, myArg3, myArg4 };
	
	public ASTNode(Command command, Variable variable, double value,
			ASTNode arg1, ASTNode arg2, ASTNode arg3, ASTNode arg4) {
		myCommand = command;
		myVariable = variable;
		myValue = value;
		myArg1 = arg1;
		myArg2 = arg2;
		myArg3 = arg3;
		myArg4 = arg4;
	}
	
	public double evaluate() {
		if (myVariable != null) return myVariable.getValue();
		if (myCommand == null) return myValue;
		return myCommand.execute(myArg1,  myArg2, myArg3, myArg4, new TurtleInfo());
	}
	
	public double getValue() {
		if (myVariable != null) return myVariable.getValue();
		if (myCommand == null) return myValue;
		return evaluate();
	}
	

}
