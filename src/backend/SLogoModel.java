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
	
	Executor myExecutor;
	
	public SLogoModel() {
		myExecutor = new Executor(mySlogoData.getLanguage());
	}
	
	
	public void parse(String input) {
		myExecutor.setInput(new ArrayList<String>(Arrays.asList(input.split(" "))));
		//myExecutor.parseText(mySlogoData).evaluate();
//		for (Turtle turtle : myTurtles)
			myExecutor.parseText(mySlogoData).evaluate();
	}
	
	public List<Turtle> getTurtles() {
		return mySlogoData.getTurtles();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable slogoData, Object arg) {
		mySlogoData = (SLogoData) slogoData;
		myExecutor.setLanguage(mySlogoData.getLanguage());
	}

}
