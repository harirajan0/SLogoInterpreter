package frontend;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import constants.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import languages.Language;
import main.SLogoController;

public class MenuFactory {
	
	public Menu MakeMenu(String menuName){
		switch(menuName){
		case "Help":
			Menu helpMenu = new Menu("Help");
			addElementsToMenu(helpMenu);
		    return helpMenu;
			
		case "Options":
			Menu optionMenu = new Menu("Options");
			addElementsToMenu(optionMenu);
//		    optionMenu.getItems().add(new Menu("Display Options"));		    
//		    Menu penMenu=new Menu("Pen Properties");
//		    MenuItem penThickness=new MenuItem("Adjust pen thickness");
//		    //MenuItem penColor=new MenuItem("Change pen color");
//		    //penColor.setOnAction(event -> {
//		    	//we need ACCESS to our instance of pen!!! 
//		    	//colorPicker.show();
//		    //});
//		    penThickness.setOnAction(event -> {
//		    	//WE NEED SOME INSTANCE of the pen
//		    	//myPenSlider.show();
//		    });
//		    penMenu.getItems().add(penThickness);
//		    //penMenu.getItems().add(penColor);
//		    optionMenu.getItems().add(penMenu);
		    return optionMenu;
		    
		case "Languages":
			Menu languageMenu = new Menu("Language");
			addElementsToMenu(languageMenu);
			return languageMenu;
			
			
		default: return new Menu(menuName);
		}
	}
	
	public void addElementsToMenu(Menu myMenu){
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColorContainedIn").equals(myMenu.getText())){
		    MenuItem penColor=new MenuItem("Change pen color");
		    myMenu.getItems().add(penColor);
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("penWidthContainedIn").equals(myMenu.getText())){
		    MenuItem penThickness=new MenuItem("Adjust pen thickness");
		    myMenu.getItems().add(penThickness);
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("listOfCommandsContainedIn").equals(myMenu.getText())){
			MenuItem help = new MenuItem("See a list of commands");
//		    help.setOnAction(actionEvent ->  {
//				try {
//					Desktop.getDesktop().browse(new URL(Constants.DEFAULT_RESOURCE_BUNDLE.getString("commandList")).toURI());
//				} catch (IOException | URISyntaxException e) {
//					new ExceptionListener(e);
//				}
//			});
		    myMenu.getItems().add(help);
		}
		if (Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagesMenuContainedIn").equals(myMenu.getText())){
			ToggleGroup languageSelection = new ToggleGroup();
			for (String lang : Constants.LANGUAGE_RESOURCE_BUNDLE.keySet()){
				RadioMenuItem languageItem=new RadioMenuItem(lang);
				myMenu.getItems().add(languageItem);
				if (lang.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getObject("DefaultLanguage"))){
					languageItem.setSelected(true);
				}
				languageItem.setToggleGroup(languageSelection);
//				languageItem.setOnAction(new EventHandler<ActionEvent>() {
//				    @Override public void handle(ActionEvent e) {
//				    	//FRONTEND NEEDS SOME ACCESS TO OUR INSTANCE OF CONTROLLER HERE!!!
//				    	//SLogoController.changeLanguage(lang);
//				    }
//				});
			}
		}
		
		
		
	}
	
}