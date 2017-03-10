/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import languages.Language;
import main.SLogoData;
import turtle.Turtle;

/**
 * @author harirajan
 *
 */
public class SLogoModel implements Observer {
	
	SLogoData mySlogoData;
	
	Executor myExecutor;
	
	public SLogoModel() {
		myExecutor = new Executor();
	}
	
	public void setLanguage(Language lang) {
		myExecutor.setLanguage(lang);
	}
	
	public void parse(String input) {
//		myExecutor.setInput(new ArrayList<String>(Arrays.asList(input.split(" "))));
		//myExecutor.parseText(mySlogoData).evaluate();
//		for (Turtle turtle : myTurtles)
		
		/*This is too revealing of the implementation of the parser
		 * 
		 */
		myExecutor.parseText(mySlogoData, new ArrayList<String>() {{
			for (String str : input.split(" ")) add(str.trim());
		}}).evaluate();
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
		setLanguage(mySlogoData.getLanguage());
	}

}
