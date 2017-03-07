/**
 * 
 */
package commands;

import backend.Variable;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class ASTNode {
	
	private Command myCommand;
	Variable myVariable;
	private double myValue;
	private ASTNode myArg1;
	private ASTNode myArg2;
	private ASTNode myArg3;
	private ASTNode myArg4;
	private Turtle myTurtle;
	
//	ASTNode[] myArgs = { myArg1, myArg2, myArg3, myArg4 };
	
	public ASTNode(Command command, Variable variable, double value,
			ASTNode arg1, ASTNode arg2, ASTNode arg3, ASTNode arg4, Turtle turtle) {
		myCommand = command;
		myVariable = variable;
		myValue = value;
		myArg1 = arg1;
		myArg2 = arg2;
		myArg3 = arg3;
		myArg4 = arg4;
		myTurtle = turtle;
	}
	
	public double evaluate() {
		if (myVariable != null) return myVariable.getValue();
		if (myCommand == null) return myValue;
		return myCommand.execute(myArg1,  myArg2, myArg3, myArg4, myTurtle);
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
	
	/**
	 * @return the myArg1
	 */
	public ASTNode getArg1() {
		return myArg1;
	}

	/**
	 * @param myArg1 the myArg1 to set
	 */
	public void setArg1(ASTNode myArg1) {
		this.myArg1 = myArg1;
	}

	/**
	 * @return the myArg2
	 */
	public ASTNode getArg2() {
		return myArg2;
	}

	/**
	 * @param myArg2 the myArg2 to set
	 */
	public void setArg2(ASTNode myArg2) {
		this.myArg2 = myArg2;
	}

	/**
	 * @return the myArg3
	 */
	public ASTNode getArg3() {
		return myArg3;
	}

	/**
	 * @param myArg3 the myArg3 to set
	 */
	public void setArg3(ASTNode myArg3) {
		this.myArg3 = myArg3;
	}

	/**
	 * @return the myArg4
	 */
	public ASTNode getArg4() {
		return myArg4;
	}

	/**
	 * @param myArg4 the myArg4 to set
	 */
	public void setArg4(ASTNode myArg4) {
		this.myArg4 = myArg4;
	}
	
	
	public ASTNode getFirstAvailableArgument() {
		if (myArg1 != null) return myArg1;
		if (myArg2 != null) return myArg2;
		if (myArg3 != null) return myArg3;
		if (myArg4 != null) return myArg4;
		return null;
	}
	
	public String toString() {
		if (myCommand != null) return myCommand.getClass().getName();
		return String.valueOf(myValue);
	}

}
