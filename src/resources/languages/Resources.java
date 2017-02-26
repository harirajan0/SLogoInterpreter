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
	
	public static String getString(String lang, String key) {
		return ResourceBundle.getBundle("resources.languages/" + lang).getString(key);
	} 
	
	public static Set<String> getKeys(String lang) {
		return ResourceBundle.getBundle("resources.languages/" + lang).keySet();
	}

}
