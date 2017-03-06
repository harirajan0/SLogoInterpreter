/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Arrays;

import languages.Language;

/**
 * @author harirajan
 *
 */
public class SLogoModel {
	
	TurtleInfo myTurtleInfo;
	Executor myExecutor;
	Language myLang;
	
	public SLogoModel(TurtleInfo turtleInfo) {
		myTurtleInfo = turtleInfo;
		myExecutor = new Executor(myTurtleInfo);
	}
	
	public void setLanguage(Language lang) {
		myLang = lang;
		myExecutor.setLanguage(lang);
	}
	
	public void parse(String input) {
		myExecutor.setInput(new ArrayList<String>(Arrays.asList(input.split(" "))));
		myExecutor.parseText().evaluate();
	}
	
	public TurtleInfo getTurtleInfo() {
		return myTurtleInfo;
	}
	
	public void setTurtleInfo(TurtleInfo newTurtleInfo) {
		myTurtleInfo = newTurtleInfo;
		myExecutor.setTurtleInfo(myTurtleInfo);
	}
}
