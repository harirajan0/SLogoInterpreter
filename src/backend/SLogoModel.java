/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import languages.Language;
import turtle.Turtle;
import turtle.TurtleView;

/**
 * @author harirajan
 *
 */
public class SLogoModel {
	
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

}
