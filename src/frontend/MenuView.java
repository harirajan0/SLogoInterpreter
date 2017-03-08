package frontend;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import PenObjects.PenColorChooser;
import PenObjects.PenSlider;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import languages.Language;
import main.SLogoController;

/**
 * @author Daniel
 *
 */

public class MenuView {

	private MenuBar myMenuBar;
	private Language myLanguage;
	private PenSlider myPenSlider;
	private PenColorChooser colorPicker;
	
	public MenuView(Stage myStage) {
		myPenSlider=new PenSlider();
   	    colorPicker = new PenColorChooser();
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
//			try {
//				Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/compsci308/spring17/assign/03_slogo/commands.php").toURI());
//			} catch (IOException | URISyntaxException e) {
//				new ExceptionListener(e);
//			}
	        WebView webView = new WebView();
	        WebEngine webEngine = webView.getEngine();
	            URL urlHello = getClass().getResource("listOfCommands.html");
	            webEngine.load(urlHello.toExternalForm());
		});
	    helpMenu.getItems().add(help);
	
	    optionMenu.getItems().add(new Menu("Display Options"));
	    
	    Menu penMenu=new Menu("Pen Properties");
	    MenuItem penThickness=new MenuItem("Adjust pen thickness");
	    MenuItem penColor=new MenuItem("Change pen color");
	    penColor.setOnAction(event -> {
	    	 colorPicker.show();
	    });
	    penThickness.setOnAction(event -> {
	    	myPenSlider.show();
	    });
	    penMenu.getItems().add(penThickness);
	    penMenu.getItems().add(penColor);
	    optionMenu.getItems().add(penMenu);
		myMenuBar.getMenus().addAll(helpMenu, optionMenu);
	}

	public MenuBar getNode() {
		return myMenuBar;
	}
	
	public Language getLanguage(){
		return myLanguage;
	}
}
