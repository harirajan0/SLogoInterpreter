/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import languages.Language;

/**
 * @author harirajan
 * The main backend class which contains an instance of crucial program data (SlogoData class) and an executor
 * class
 */
public class SLogoModel implements Observer {
	
	SLogoData mySlogoData;
	Executor myExecutor;
	
	/**
	 * Instantiate a new SLogoModel. Called once by Controller. 
	 */
	public SLogoModel() {
		myExecutor = new Executor();
	}
	
	/**
	 * 
	 * @param lang The language in which the parser should parse commands
	 */
	public void setLanguage(Language lang) {
		myExecutor.setLanguage(lang);
	}
	
	@SuppressWarnings("serial")
	public void parse(String input) {
		myExecutor.parseText(mySlogoData, new ArrayList<String>() {{
			for (String str : input.split("\\s+")) add(str.trim());
		}}).evaluate();
	}
	

	/**
	 * Part of the observer interface
	 */
	@Override
	public void update(Observable slogoData, Object arg) {
		mySlogoData = (SLogoData) slogoData;
		setLanguage(mySlogoData.getLanguage());
	}

}
