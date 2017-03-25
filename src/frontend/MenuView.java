//This entire file is part of my masterpiece.
//BELAL TAHER
//For my masterpiece, the refactored component that I'm submitting is the 
//UI (the MenuView and the CommandPromptView). The version of the code
//submitted on the master branch at the end of this project is what I'm submitting
//since I SIGNIFICANTLY refactored it. Originally, our MenuView and CommandPromptView
//had lots of magic numbers and didn't use any resource files or constants.
//I changed all of that so that the menu is a lot more mutable by the user.
//I also made all initialization occur in the constructor because it 
//seems appropriate for the necessary functionality to be set up as soon
//as this object is constructed. My masterpiece also reflects the design
//choice of using broad public methods (or in this case the constructor) with
//very specialized private methods. for example, the setUpMenuBarItems() is 
//a specialized function. This is better reflected in the CommandPromptView class.
//Although I wasn't able to really implement some of the more recent design choices
//we learned about in class in this masterpiece, the nature of what I was working
//on didn't allow. For example, since all the computation and logic was done on the back 
//end, the only real design choices we could make on the front end were ones
//that helped the code be readable. It would be unnecessary if we tried to implement
//anything that deals with improved functionality (like Observables, lambdas, e.t.c)
//because that would just overcomplicate the project. Instead, the design choice
//I focused on making was making easy to read code. Because of the limited functionality
//of the front end, good looking code was one of our biggest priorities. This was necessary
//due to the fact that most of aspects of design were handled by the back end.
//This code's purpose to to initialize and give functionality to the menu.

package frontend;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import languages.Language;
import constants.Constants;

/**
 * @author Daniel
 * @author Belal
 * 
 * This class sets up the elements of the menu and puts them into the menubar.
 */

public class MenuView {
	private MenuBar myMenuBar;
	private Menu myHelpMenu;
	private Menu myLanguagesMenu;
	private ChoiceBox<String> myLanguageChoiceBox;
	
	protected MenuView() {
		/** constructor that creates the menu bar and adds menu items to the menu bar */
		myMenuBar = new MenuBar();
		setUpMenuBarItems();
		myMenuBar.getMenus().addAll(myHelpMenu, myLanguagesMenu);
	}


	@SuppressWarnings("serial")
	private void setUpMenuBarItems() {
		/** set up the items in the menu bar */
		myHelpMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("helpPrompt"));
		MenuItem help = new MenuItem(Constants.DEFAULT_RESOURCE_BUNDLE.getString("listPrompt"));
	    myHelpMenu.getItems().add(help);
	    myHelpMenu.setOnAction(event -> {
			CommandDisplayer myCommandDisplay = new CommandDisplayer();
			myCommandDisplay.show();
		});
	    
	    
	    myLanguagesMenu = new Menu(Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagePrompt"));
	    MenuItem languages = new MenuItem();
	    myLanguageChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(
	    	new ArrayList<String>() {{
	    		for (Language lang : Language.values()) if (!lang.equals(Language.SYNTAX)) add(lang.getLang());
	    }}));
	    myLanguageChoiceBox.getSelectionModel().select(Constants.DEFAULT_LANGUAGE);
	    languages.setGraphic(myLanguageChoiceBox);
	    myLanguagesMenu.getItems().add(languages);
		
	}

	protected MenuBar getNode() {
		/** get the menu bar that has been set up*/
		return myMenuBar;
	}

	protected ChoiceBox<String> getLanguageChoiceBox() {
		/** get the 'select language' choice box */
		return myLanguageChoiceBox;
	}
}