package frontend;
import java.util.ArrayList;
import java.util.List;
import constants.Constants;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuView {
	private MenuBar myMenuBar;
	private MenuFactory myMenuFactory;
	private List<MenuItem> myMenuItems;
	
	public MenuView(Stage myStage) {
		myMenuFactory=new MenuFactory();
		myMenuBar = new MenuBar();
		myMenuItems=new ArrayList<MenuItem>();
		myMenuBar.prefWidthProperty().bind(myStage.widthProperty()); //make sure menu bar is full screen width
		//for loop to dynamically add items
		for(int menuItem = 1; menuItem <= Integer.parseInt(Constants.DEFAULT_RESOURCE_BUNDLE.getString("numOfOptions")); menuItem++){
			//Creates menu choices
			String menuName=Constants.DEFAULT_RESOURCE_BUNDLE.getString("option" + menuItem);
			Menu newMenu=myMenuFactory.MakeMenu(menuName);
			myMenuItems.addAll(newMenu.getItems());
			myMenuBar.getMenus().add(newMenu);	
		}
	}
	
	public MenuBar getNode() {
		return myMenuBar;
	}
	
	public List<MenuItem> getMenuItems(){
		return myMenuItems;
	}
	
	public MenuItem getLanguageMenuItem() {
		return myMenuBar.getMenus().get(myMenuBar.getMenus().indexOf("Language"));
	}
}