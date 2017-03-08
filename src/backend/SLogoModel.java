/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import languages.Language;
import main.SLogoData;
import turtle.Turtle;
import turtle.TurtleView;

/**
 * @author harirajan
 *
 */
public class SLogoModel implements Observer {
	
	SLogoData mySlogoData;
	
	List<Turtle> myTurtles;
	Executor myExecutor;
	Language myLang;
	
	public SLogoModel(Turtle firstTurtle) {
		myTurtles = new ArrayList<>(Arrays.asList(firstTurtle));
		myExecutor = new Executor();
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
		myExecutor.setLanguage(lang);
	}
	
	public void parse(String input) {
		myExecutor.setInput(new ArrayList<String>(Arrays.asList(input.split(" "))));
		for (Turtle turtle : myTurtles) myExecutor.parseText(turtle).evaluate();
	}
	
	public List<Turtle> getTurtles() {
		return myTurtles;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable slogoData, Object arg) {
		mySlogoData = (SLogoData) slogoData;
	}

}
