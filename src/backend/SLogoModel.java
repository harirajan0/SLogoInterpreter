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
//	TurtleInfo myTurtleInfo;
	Executor myExecutor;
	Language myLang;
	
	public SLogoModel(List<Turtle> turtles) {
		myTurtles = turtles;
//		myTurtleInfo = turtleInfo;
		myExecutor = new Executor();
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
		myExecutor.setLanguage(lang);
	}
	
	public void parse(String input) {
		myExecutor.setInput(new ArrayList<String>(Arrays.asList(input.split(" "))));
		for (Turtle turtle : myTurtles) myExecutor.parseText(turtle.getTurtleInfo()).evaluate();
	}
	
	public List<Turtle> getTurtles() {
		return myTurtles;
	}

}
