/**
 * 
 */
package ASTNode;

import java.util.ArrayList;
import java.util.List;

import backend.Variable;
import command_abstractions.Command;
import commands.Sum;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class ASTNode {
	
	private Command myCommand;
	String myVariableName;
	private double myValue;
	private SLogoData mySlogoData;
	private boolean isBlock;
	private List<ASTNode> myArguments;
	
	
	public ASTNode(Command command, String variableName, double value,
			List<ASTNode> arguments, SLogoData slogoData, boolean isBlock) {
		myCommand = command;
		myVariableName = variableName;
		myValue = value;
		myArguments = arguments;
		mySlogoData = slogoData;
		this.isBlock = isBlock;
	}
	
	public double evaluate() {
		print();
		if (isBlock) return myArguments.get(0).evaluate();
		if (myVariableName != null) {
			if (mySlogoData.getVariable(myVariableName) != null) {
				return mySlogoData.getVariable(myVariableName).getValue();
			}
			else {
				return 0.0; // THROW EXCEPTION FOR NOT BEING ABLE TO FIND VARIABLE
			}
		}
		if (myCommand == null) return myValue; // if its a double
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
		if (isBlock) { return "BLOCK: " + myArguments.toString(); }
		if (myCommand != null) return myCommand.getClass().getName();
		return String.valueOf(myValue);
	}
	
	public boolean hasMathValue() {
		if (myCommand == null) return true;
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
	

}
