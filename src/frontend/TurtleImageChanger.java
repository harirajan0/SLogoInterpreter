/**
 * 
 */
package frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.SLogoData;
import constants.Constants;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * @author harirajan
 *
 */
public class TurtleImageChanger extends Application implements Observer {
	
	private Group myRoot;
	private Scene myScene;
	private SLogoData mySlogoData;
	private ComboBox<HBox> myComboMax;
	
	public TurtleImageChanger(Stage s, SLogoData sd) throws Exception {
		myRoot = new Group();
		myScene = new Scene(myRoot, Constants.TURTLE_IMAGE_SELECTOR_WINDOW_WIDTH, Constants.TURTLE_IMAGE_SELECTOR_WINDOW_HEIGHT, Constants.BACKGROUND_COLOR);
		start(s);
		myComboMax = new ComboBox();
		mySlogoData = sd;
		setUpChoiceBox();
		myRoot.getChildren().add(myComboMax);
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
		setUpChoiceBox();
	}
	
	private void setUpChoiceBox() {
		List<HBox> l = new ArrayList<>();
		for (int i = 0; i < mySlogoData.getTurtles().size(); i++) {
			HBox hb = new HBox();
			hb.getChildren().addAll(new Label("Turtle " + String.valueOf(i)), mySlogoData.getTurtles().get(i).getNode());
			l.add(hb);
		}
		myComboMax.setItems(FXCollections.observableList(l));
		myComboMax.valueProperty().addListener(e -> changeImage(myComboMax.getSelectionModel().getSelectedIndex()));
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
