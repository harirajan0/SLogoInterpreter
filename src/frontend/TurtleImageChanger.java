/**
 * 
 */
package frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeMap;

import backend.SLogoData;
import backend.turtle.Turtle;
import constants.Constants;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * @author harirajan
 *
 */
public class TurtleImageChanger extends Application implements Observer {
	
	private Group myRoot;
	private Scene myScene;
	private SLogoData mySlogoData;
	private ChoiceBox<String> myChoiceBox;
	private TreeMap<String, Turtle> myTurtleMap;
	
	public TurtleImageChanger(Stage s, SLogoData sd) {
		myRoot = new Group();
		myScene = new Scene(myRoot, Constants.TURTLE_IMAGE_SELECTOR_WINDOW_WIDTH, Constants.TURTLE_IMAGE_SELECTOR_WINDOW_HEIGHT, Constants.BACKGROUND_COLOR);
		try {
			start(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myChoiceBox = new ChoiceBox();
		myTurtleMap = new TreeMap<>();
		myRoot.getChildren().add(myChoiceBox);
		mySlogoData = sd;
		steUpTreeMap();
		setUpChoiceBox();
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage s) throws Exception {
		// TODO Auto-generated method stub
		s.setScene(myScene);
		s.setTitle(Constants.TURTLE_IMAGE_SELECTOR_TITLE);
		s.show();
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		SLogoData slogoData = (SLogoData) o;
		mySlogoData = slogoData;
		steUpTreeMap();
		setUpChoiceBox();
	}
	
	private void setUpChoiceBox() {
		myChoiceBox.setItems(FXCollections.observableList(new ArrayList<>(myTurtleMap.keySet())));
		myChoiceBox.valueProperty().addListener(e -> changeImage(myChoiceBox.getSelectionModel().getSelectedIndex()));
	}
	
	private void steUpTreeMap() {
		myTurtleMap.clear();
		for (int i = 0; i < mySlogoData.getTurtles().size(); i++) {
			myTurtleMap.put("Turtle " + String.valueOf(i), mySlogoData.getTurtles().get(i));
		}
	}
	
	private void changeImage(int index) {
		FileChooser fc = new FileChooser();
        fc.setTitle(Constants.IMAGE_CHOOSER_TITLE);
        fc.setInitialDirectory(new File(System.getProperty("user.dir"), "./images"));
        fc.getExtensionFilters().setAll(new ExtensionFilter("Images", "*.png"));
        File imageFile;
        if (!((imageFile = fc.showOpenDialog(null)) == null)){
        	mySlogoData.changeImage(index, new Image(imageFile.getName()));
        }
	}

}
