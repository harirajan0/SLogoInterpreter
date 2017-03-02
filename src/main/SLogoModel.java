/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Arrays;

import backend.Executor;
import backend.TurtleInfo;

/**
 * @author harirajan
 *
 */
public class SLogoModel {
	
	TurtleInfo myTurtleInfo;
	Executor myExecutor;
	String myLang;
	
	public SLogoModel(String lang, TurtleInfo turtleInfo) {
		myTurtleInfo = turtleInfo;
		myExecutor = new Executor(myTurtleInfo);
		myLang = lang;
	}
	
	public void parse(String input) {
		myExecutor.parseText(new ArrayList<String>(Arrays.asList(input.split(" "))), myLang);
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
