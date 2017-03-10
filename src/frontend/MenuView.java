package frontend;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import languages.Language;
import constants.Constants;

public class MenuView {
	private MenuBar myMenuBar;
	private List<MenuItem> myMenuItems;
	private Menu myHelpMenu;
	private Menu myLanguagesMenu;
	private ChoiceBox<String> myLanguageChoiceBox;
	
	public MenuView() {
		myMenuBar = new MenuBar();
		myMenuItems = new ArrayList<MenuItem>();
		setUpMenuBarItems();
		myMenuBar.getMenus().addAll(myHelpMenu, myLanguagesMenu);
	}

	/**
	 * 
	 */
	@SuppressWarnings("serial")
	private void setUpMenuBarItems() {
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

	public MenuBar getNode() {
		return myMenuBar;
	}

	public List<MenuItem> getMenuItems() {
		return myMenuItems;
	}

	public ChoiceBox<String> getLanguageChoiceBox() {
		return myLanguageChoiceBox;
	}
}