package frontend;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import constants.Constants;

/**
 * @author Daniel
 * 
 * This class opens up a formatted html page
 * containing a list of SLogo commands.
 */

public class CommandDisplayer extends Stage {
	
	protected CommandDisplayer() {
		URL urlHello = getClass().getResource(Constants.DEFAULT_RESOURCE_BUNDLE.getString("commandList"));
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		webEngine.load(urlHello.toExternalForm());
		Scene s = new Scene(browser);
		this.setScene(s);
	}
}
