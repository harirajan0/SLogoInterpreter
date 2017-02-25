/**
 * 
 */
package resources.languages;

import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author harirajan
 *
 */
public class Resources {
	
	private ResourceBundle myResources;
	
	public Resources(String lang) {
		myResources = ResourceBundle.getBundle("resources.languages/" + lang);
	}
	
	public String getString(String key) {
		return myResources.getString(key);
	} 
	
	public Set<String> getKeys() {
		return myResources.keySet();
	}

}
