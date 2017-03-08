package frontend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

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
			MenuItem help = new MenuItem("See a list of commands");
		    help.setOnAction(actionEvent ->  {
				try {
					Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/compsci308/spring17/assign/03_slogo/commands.php").toURI());
				} catch (IOException | URISyntaxException e) {
					new ExceptionListener(e);
				}
			});
		    helpMenu.getItems().add(help);
		    return helpMenu;
			
		case "Options":
			Menu optionMenu = new Menu("Options");
		    optionMenu.getItems().add(new Menu("Display Options"));		    
		    Menu penMenu=new Menu("Pen Properties");
		    MenuItem penThickness=new MenuItem("Adjust pen thickness");
		    MenuItem penColor=new MenuItem("Change pen color");
		    penColor.setOnAction(event -> {
		    	//we need ACCESS to our instance of pen!!! 
		    	//colorPicker.show();
		    });
		    penThickness.setOnAction(event -> {
		    	//WE NEED SOME INSTANCE of the pen
		    	//myPenSlider.show();
		    });
		    penMenu.getItems().add(penThickness);
		    penMenu.getItems().add(penColor);
		    optionMenu.getItems().add(penMenu);
		    return optionMenu;
		    
		case "Languages":
			Menu languageMenu = new Menu("Language");
			ToggleGroup languageSelection = new ToggleGroup();
			for (Language lang : Language.values()){
				RadioMenuItem languageItem=new RadioMenuItem(lang.getLang());
				languageMenu.getItems().add(languageItem);
				languageItem.setSelected(true);
				languageItem.setToggleGroup(languageSelection);
				languageItem.setOnAction(new EventHandler<ActionEvent>() {
				    @Override public void handle(ActionEvent e) {
				    	//FRONTEND NEEDS SOME ACCESS TO OUR INSTANCE OF CONTROLLER HERE!!!
				    	//SLogoController.changeLanguage(lang);
				    }
				});
			}
			return languageMenu;
			
			
		default: return new Menu(menuName);
		}
	}

}
