package frontend;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import constants.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import languages.Language;
import main.SLogoController;

/**
 * @author Daniel
 *
 */

public class MenuFactory {
	private List<MenuItem> myMenuItems;
	
	public Menu MakeMenu(String menuName){
		switch(menuName){
		case "Help":
			Menu helpMenu = new Menu("Help");
			addElementsToMenu(helpMenu);
		    return helpMenu;
			
		case "Options":
			Menu optionMenu = new Menu("Options");
			addElementsToMenu(optionMenu);
		    return optionMenu;
		    
			
		default: return new Menu(menuName);
		}
	}
	
	public void addElementsToMenu(Menu myMenu){
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColorContainedIn").equals(myMenu.getText())){
		    MenuItem penColor=new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColor"));
		    myMenu.getItems().add(penColor);
		    
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("penWidthContainedIn").equals(myMenu.getText())){
		    MenuItem penThickness=new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penThickness"));
		    myMenu.getItems().add(penThickness);
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagesContainedIn").equals(myMenu.getText())){
		    MenuItem languages=new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagePrompt"));
		    myMenu.getItems().add(languages);
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("listOfCommandsContainedIn").equals(myMenu.getText())){
			MenuItem help = new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("listPrompt"));
		    myMenu.getItems().add(help);
		}

		}
	
	
	}
	
