package frontend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.scene.Group;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import languages.Language;

public class MenuView {

	MenuBar myMenuBar;
	
	public MenuView(Stage myStage) {
		myMenuBar = new MenuBar();
		myMenuBar.prefWidthProperty().bind(myStage.widthProperty()); //make sure menu bar is full screen width
		Menu helpMenu = new Menu("Help");
		Menu optionMenu = new Menu("Options");
		Menu languageMenu = new Menu("Language");
		for (Language lang : Language.values()) languageMenu.getItems().add(new RadioMenuItem(lang.getLang()));
	    optionMenu.getItems().add(languageMenu);
	    MenuItem help = new MenuItem("See a list of commands");
	    help.setOnAction(actionEvent ->  {
			try {
				Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/compsci308/spring17/assign/03_slogo/commands.php").toURI());
			} catch (IOException | URISyntaxException e) {
				new ExceptionListener(e);
			}
		});
	    helpMenu.getItems().add(help);
	
	
		myMenuBar.getMenus().addAll(helpMenu, optionMenu);
	}

	public MenuBar getNode() {
		return myMenuBar;
	}
}
