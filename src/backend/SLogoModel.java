/**
 * 
 */
package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import languages.Language;

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
	
	@SuppressWarnings("serial")
	public void parse(String input) {
		myExecutor.parseText(mySlogoData, new ArrayList<String>() {{
			for (String str : input.split("\\s+")) add(str.trim());
		}}).evaluate();
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
