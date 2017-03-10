/**
 * 
 */
package backend;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import languages.Language;


/**
 * @author harirajan
 *
 */

public class RegexParser {
    // "types" and the regular expression patterns that recognize those types
    // note, it is a list because order matters (some patterns may be more generic)
    private List<Entry<String, Pattern>> mySymbols;
    
    private Language myLang;


    public RegexParser (Language lang) {
        mySymbols = new ArrayList<>();
        myLang = lang;
        addPatterns(myLang);
    }

    // adds the given resource file to this language's recognized types
    public void addPatterns (Language lang) {
        for (String key : lang.getKeys()) {
            String regex = lang.getString(key);
            mySymbols.add(new SimpleEntry<>(key,
                           // THIS IS THE IMPORTANT LINE
                           Pattern.compile(regex, Pattern.CASE_INSENSITIVE)));
        }
    }

    // returns the language's type associated with the given text if one exists 
    public String getSymbol (String text) {
        for (Entry<String, Pattern> entry : mySymbols) {
            if (match(text, entry.getValue())) {
                return entry.getKey();
            }
        }
        return "PossibleFunction";
    }

    // returns true if the given text matches the given regular expression pattern
    private boolean match (String text, Pattern regex) {
        // THIS IS THE KEY LINE
        return regex.matcher(text).matches();
    }
    

}
