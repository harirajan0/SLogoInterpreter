/**
 * 
 */
package resources.languages;

import java.util.ResourceBundle;

/**
 * @author harirajan
 *
 */
public class Resources {
	
	private ResourceBundle myResources;
	
	public Resources(String lang) {
		myResources = ResourceBundle.getBundle(lang);
	}
	
	public String getString(String key) {
		return myResources.getString(key);
	} 

}
