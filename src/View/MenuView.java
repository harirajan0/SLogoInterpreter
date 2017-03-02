package View;

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

public class MenuView {
	public MenuView(Group root, Stage myStage){
	MenuBar myMenuBar=new MenuBar();
	myMenuBar.prefWidthProperty().bind(myStage.widthProperty()); //make sure menu bar is full screen width
	Menu helpMenu=new Menu("Help");
	Menu optionMenu=new Menu("Options");
	Menu languageMenu = new Menu("Language");
	languageMenu.getItems().addAll(  
			//TODO:
			//how to check only one at a time? how to have english as default?
			//there must be a better way to do this with enumerated types.
        new RadioMenuItem("English"),
        new RadioMenuItem("French"),
        new RadioMenuItem("German"),
        new RadioMenuItem("Italian"),
        new RadioMenuItem("Portuguese"),
        new RadioMenuItem("Russian"),
        new RadioMenuItem("Spanish"));
	
    optionMenu.getItems().add(languageMenu);
    MenuItem help=new MenuItem("See a list of commands");
    help.setOnAction(actionEvent ->  {
		try {
			
			//TODO: replace by our own formatted page
			Desktop.getDesktop().browse(new URL("http://www.cs.duke.edu/courses/compsci308/spring17/assign/03_slogo/commands.php").toURI());
		} catch (IOException | URISyntaxException e) {
			new ExceptionListener(e);
		}
	});
    helpMenu.getItems().add(help);


	myMenuBar.getMenus().addAll(helpMenu, optionMenu);
	root.getChildren().add(myMenuBar);
	}

}
