/**
 * 
 */
package backend;

import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import languages.Language;
import languages.LanguageFactory;


/**
 * @author harirajan
 *
 */

public class RegexParser {
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    private List<Entry<String, Pattern>> mySymbols;
    
    private Language myLang;


    protected RegexParser(Language lang) {
        mySymbols = new ArrayList<>();
        myLang = lang;
        addPatterns(myLang);
    }

    // adds the given resource file to this language's recognized types
    private void addPatterns(Language lang) {
        for (String key : lang.getKeys()) {
            String regex = lang.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    // returns the language's type associated with the given text if one exists 
    protected String getSymbol(String text) {
        for (Entry<String, Pattern> entry : mySymbols) {
            if (match(text, entry.getValue())) {
                return entry.getKey();
            }
        }
        return "PossibleFunction";
    }

    // returns true if the given text matches the given regular expression pattern
    private boolean match(String text, Pattern regex) {
        return regex.matcher(text).matches();
    }
    

}
