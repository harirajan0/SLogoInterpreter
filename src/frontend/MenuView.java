package frontend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import languages.Language;
import main.SLogoController;

public class MenuView {

	MenuBar myMenuBar;
	Language myLanguage;

	
	public MenuView(Stage myStage) {
		myMenuBar = new MenuBar();
		myMenuBar.prefWidthProperty().bind(myStage.widthProperty()); //make sure menu bar is full screen width
		Menu helpMenu = new Menu("Help");
		Menu optionMenu = new Menu("Options");
		Menu languageMenu = new Menu("Language");
		ToggleGroup languageSelection = new ToggleGroup();
		for (Language lang : Language.values()){
			RadioMenuItem languageItem=new RadioMenuItem(lang.getLang());
			languageMenu.getItems().add(languageItem);
			languageItem.setSelected(true);
			languageItem.setToggleGroup(languageSelection);
			languageItem.setOnAction(new EventHandler<ActionEvent>() {
			    @Override public void handle(ActionEvent e) {
			    	SLogoController.changeLanguage(lang);
			    }
			});
		}
		
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
	
	    optionMenu.getItems().add(new Menu("Display Options"));
	    
		myMenuBar.getMenus().addAll(helpMenu, optionMenu);
	}

	public MenuBar getNode() {
		return myMenuBar;
	}
	
	public Language getLanguage(){
		return myLanguage;
	}
}
