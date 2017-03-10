package frontend;
<<<<<<< HEAD
import java.util.List;
=======

>>>>>>> b25ac1c6c7e0d486b4d68bc366ea41e206cada59

import constants.Constants;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * @author Daniel
 *
 */

public class MenuFactory {
	
	public Menu MakeMenu(String menuName){
		switch(menuName){
		case "Help":
			Menu helpMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("helpPrompt"));
			addElementsToMenu(helpMenu);
		    return helpMenu;
			
		case "Options":
			Menu optionMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("optionsPrompt"));
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
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("backgroundColorContainedIn").equals(myMenu.getText())){
			MenuItem backgroundColor = new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("backgroundColor"));
		    myMenu.getItems().add(backgroundColor);
		}

		}
	
	
	}
	
