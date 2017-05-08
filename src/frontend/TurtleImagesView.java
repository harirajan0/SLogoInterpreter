package frontend;

import java.io.File;
import java.util.List;

import backend.SLogoData;
import backend.turtle.Turtle;
import constants.Constants;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class TurtleImagesView {
	private Group myRoot;
	private Rectangle myRectangle;
	private List<Turtle> myTurtles;
	private Scene myScene;
	private SLogoData mySlogoData;
	private HBox HB;
	private Stage myStage;
	
	public TurtleImagesView(Stage s, SLogoData mySD){
	myRoot = new Group();
	HB=new HBox();
	myRoot.getChildren().add(HB);
	myScene = new Scene(myRoot, Constants.COMMAND_WINDOW_WIDTH, Constants.COMMAND_WINDOW_HEIGHT, Constants.BACKGROUND_COLOR);
	mySlogoData=mySD;
	myStage=s;

	}
	
	public void setTurtles(List<Turtle> turtles) {
		/** given a list of turtles, display them on the screen */
		myTurtles = turtles;
		for (int i=0; i<mySlogoData.getNumTurtles(); i++){
			VBox myVBox=new VBox(new Label("Turtle "+i+ "(Click here)"));
			myVBox.getChildren().add(mySlogoData.getTurtles().get(i).getView().getImage());
			int index=i;
			myVBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    openFileChooser(index);
                }

            });
        	myStage.setScene(myScene);
        	myStage.show();
			HB.getChildren().add(myVBox);
		}
	}
	
	public void openFileChooser(int index){
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.setTitle("Open Image File");
		 fileChooser.getExtensionFilters().addAll(
		         new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
		 File selectedFile = fileChooser.showOpenDialog(null);
		 if (selectedFile != null) {
			 mySlogoData.getTurtles().get(index).changeImage(new Image(selectedFile.getName()));
		 }
		 
	}
	
}
