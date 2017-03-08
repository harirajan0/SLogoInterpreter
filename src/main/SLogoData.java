package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.Variable;
import commands.Command;
import javafx.scene.paint.Color;
import turtle.Turtle;

/**
 * 
 */

/**
 * @author harirajan
 *
 */
public class SLogoData extends Observable {
	
	private List<Turtle> myTurtles;
	private List<Variable> myVariables;
	
	private int myBackgroundColorIndex;
	
	public SLogoData(Turtle firstTurtle) {
		myTurtles = new ArrayList<>(Arrays.asList(firstTurtle));
		myVariables = new ArrayList<>();
		myBackgroundColorIndex = 0; //black
	}
	
	
	public double runCommand(Command cmd, List<Double> params) {
		if (cmd.isLogicCommand()) return cmd.execute(params, null, this);
		else {
			double ret = 0.0;
			for (Turtle turtle : myTurtles) {
				if (turtle.isSelected()) {
					ret = cmd.execute(params, turtle, this);
					setChanged();
					notifyObservers();
				}
			}
			return ret;
		}
	}
	
	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		o.update(this, null);
	}
	
	public void changeBackgroundColorIndex(int index) {
		myBackgroundColorIndex = index;
		setChanged();
	}
	
	public int getBackgroundColorIndex() {
		return myBackgroundColorIndex;
	}
	
	public Variable getVariable(String name) {
		for (Variable var : myVariables) {
			if (var.getName().equals(name)) return var;
		}
		return null; //fix this to throw error when we cant find the variable
	}
	
	public void addVariable(Variable var) {
		myVariables.add(var);
		setChanged();
		notifyObservers();
	}
	
	public void addTurtle(Turtle turtle) {
		myTurtles.add(turtle);
		setChanged();
		notifyObservers();
	}
	
	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	
}
