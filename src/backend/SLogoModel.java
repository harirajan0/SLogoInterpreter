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
		myExecutor.parseText(new ArrayList<String>(Arrays.asList(input.split(" "))));
	}
	
	public TurtleInfo getTurtleInfo() {
		return myTurtleInfo;
	}
	
	public void setTurtleInfo(TurtleInfo newTurtleInfo) {
		myTurtleInfo = newTurtleInfo;
	}

//	public static void main(String[] args) {
//		String userInput = "towards 0 1";
//		SlogoModel test = new SlogoModel("English");
//		test.parse(userInput);
//		System.out.println(test.getTurtleInfo().toString());
////		userInput = "fd 50";
////		test.parse(userInput);
////		System.out.println(test.getTurtleInfo().toString());
//	}
	
}
