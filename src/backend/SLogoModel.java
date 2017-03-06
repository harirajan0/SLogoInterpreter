/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import frontend.TurtleView;
import languages.Language;

/**
 * @author harirajan
 *
 */
public class SLogoModel {
	
	List<TurtleView> myTurtles;
//	TurtleInfo myTurtleInfo;
	Executor myExecutor;
	Language myLang;
	
	public SLogoModel(List<TurtleView> turtles) {
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
		for (TurtleView turtle : myTurtles) myExecutor.parseText(turtle.getTurtleInfo()).evaluate();
	}
	
	public List<TurtleView> getTurtles() {
		return myTurtles;
	}
	
//	public void setTurtleInfo(TurtleInfo newTurtleInfo) {
//		myTurtleInfo = newTurtleInfo;
//		myExecutor.setTurtleInfo(myTurtleInfo);
//	}
}
