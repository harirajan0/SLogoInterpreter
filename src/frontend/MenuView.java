package frontend;

import constants.Constants;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class MenuView {

	private MenuBar myMenuBar;
	private MenuFactory myMenuFactory;
	
	public MenuView(Stage myStage) {
		myMenuFactory=new MenuFactory();
		myMenuBar = new MenuBar();
		myMenuBar.prefWidthProperty().bind(myStage.widthProperty()); //make sure menu bar is full screen width
		
		//for loop to dynamically add items
		for(int menuItem = 1; menuItem <= Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("numOfOptions")); menuItem++){
			//Creates menu choices
			String menuName=Constants.DEFAULT_RESOURCE_BUNDLE.getString("option" + menuItem);
			Menu newMenu=myMenuFactory.MakeMenu(menuName);
			myMenuBar.getMenus().add(newMenu);	
		}
	}

	public MenuBar getNode() {
		return myMenuBar;
	}
}
