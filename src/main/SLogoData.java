package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.Variable;
import command_abstractions.TurtleCommand;
import languages.Language;
import languages.LanguageFactory;
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
	private Language myLanguage;

	public SLogoData(Turtle firstTurtle) {
		myTurtles = new ArrayList<>(Arrays.asList(firstTurtle));
		myVariables = new ArrayList<>();
		myLanguage = Language.ENGLISH;
		myBackgroundColorIndex = 1; // black
	}

	public double runCommand(TurtleCommand cmd, List<Double> params) {
		double ret = 0.0;
		for (Turtle turtle : myTurtles) {
			if (turtle.isSelected()) {
				ret = cmd.execute(params, turtle);
				notifyObservers();
			}
		}
		return ret;
	}


	@Override
	public void addObserver(Observer o) {
		super.addObserver(o);
		o.update(this, null);
	}
	
	@Override
	public void notifyObservers() {
		super.notifyObservers();
		setChanged();
	}

	public void changeBackgroundColorIndex(int index) {
		myBackgroundColorIndex = index;
		notifyObservers();
	}

	public int getBackgroundColorIndex() {
		return myBackgroundColorIndex;
	}

	public Variable getVariable(String name) {
		for (Variable var : myVariables) {
			if (var.getName().equals(name))
				return var;
		}
		return null; // fix this to throw error when we cant find the variable
	}

	public void addVariable(Variable var) {
		myVariables.add(var);
		notifyObservers();
	}

	public void addTurtle(Turtle turtle) {
		myTurtles.add(turtle);
		notifyObservers();
	}

	public List<Turtle> getTurtles() {
		return myTurtles;
	}
	
	public int getNumTurtles() {
		return myTurtles.size();
	}
	
	public List<Variable> getVariables() {
		return myVariables;
	}
	
	public void setLanguage(String lang) {
		myLanguage = LanguageFactory.getLang(lang);
	}
	
	public Language getLanguage() {
		return myLanguage;
	}
	
//	public void moveTurtle(int turtleIndex, double newX, double newY);

}
