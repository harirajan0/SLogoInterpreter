package frontend;

import java.io.File;
import java.util.List;

import backend.SLogoData;
import backend.turtle.Turtle;
import constants.Constants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TurtleImages {

		private Group myRoot;
		private Rectangle myRectangle;
		
		private List<Turtle> myTurtles;
		private SLogoData data;
		private Stage stage;
		private VBox myVBox;



		public TurtleImages(Stage myStage, SLogoData myData) {
			myRoot = new Group();
			myRectangle = new Rectangle(Constants.TURTLE_WINDOW_SIZE, Constants.TURTLE_WINDOW_SIZE,
					Constants.TURTLE_WINDOW_COLOR);
			myVBox=new VBox();
			myRoot.getChildren().add(myVBox);
			data=myData;
			stage=myStage;
			setupSingleChooser();
		}


		public void setupSingleChooser() {
			if (data.getTurtles().size()==0){
				return;
			}
			for (int i=0; i<data.getTurtles().size(); i++){
				HBox myHBox = new HBox();
				myHBox.setAlignment(Pos.TOP_CENTER);
				myHBox.getChildren().addAll(new Label("turtle "+ data.getTurtles().get(i).getID()));
				myVBox.getChildren().add(myHBox);
			}
			myRoot.getChildren().add(myVBox);
		
		}


		public void changeImage() {
			    	FileChooser fc = new FileChooser();
	                File file = fc.showOpenDialog(stage);
	                FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	                FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	                fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
	                if (file==null){
	                	return;
	                	}
	               data.changeImage(new Image(file.getName()));
		}
}
