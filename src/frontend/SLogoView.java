// This entire file is part of my masterpiece.
// Daniel Rubinstein

package frontend;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import backend.SLogoData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import main.SLogoController;
import constants.Constants;

/**
 *  @author Daniel and Hari
 *  
 *  This class contains all the elements on the screen. We initialize all screen elements from here (encapsulation!) and
 *  also define their action here.
 *  This class also contains an instance of SLogoData, which holds the
 *  information about the turtles, pen info, etc. Using observers (we observe the Controller),
 *  we update the display is mySlogoData changes from the backend. We can also
 *  directly can modify the Controller's SLogoData from the frontend, in which case SLogoModel will 
 *  get notified via SLogoController (since SlogoModel also observes the instance of SLogoData in SLogoController and will 
 *  get updated if SLogoController's instance of SLogoData changes).
 *  This class shows how we use observers and lambda methods (to define button actions) effectively.
 *  (Note: the setting up of all the buttons is a bit repetitive, but I wanted to show how the observers work with the controller and 
 *  I needed to include this whole class to do so).
 */

public class SLogoView implements Observer {

	private SLogoData mySlogoData;
	private BorderPane myBorderPane;
	private Scene myScene;
	private Group myRoot;
	private CommandPromptView myCommandPrompt;
	private VariablesView myVariablesView;
	private TurtleWindowView myTurtleWindow;
	private MenuView myMenuBar;
	private VBox topVBox;
	private boolean showSelectedGraphically;
	private ScrollPane myLeftScrollPane;
	private VBox myLeftScrollPaneVBox;
	private PaletteView myPaletteView;
	private ChoiceBox<String> myPenColorChoiceBox;
	private ColorPicker myBackgroundColorPicker;
	private HBox myPenColorChanger;
	private HBox myPenThicknessChanger;
	private HBox myBackgroundColorChanger;
	private Slider myPenThicknessSlider;
	private ScrollPane rightScrollPane;
	private SLogoController myController;

	public SLogoView(Stage s, SLogoController mainController) { //set up all the items on the screen
		myController = mainController;
		myRoot = new Group();
		topVBox = new VBox();
		setUpScrollPanes();
		myCommandPrompt = new CommandPromptView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		Text header = new Text(Constants.APPLICATION_TITLE);
		header.setFont(new Font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		myMenuBar = new MenuView();
		topVBox.getChildren().addAll(myMenuBar.getNode(), header);
		setUpBorderPane();
		myRoot.getChildren().addAll(myBorderPane);
		showSelectedGraphically = false;
		setUpButtonActions();
		displayStage(s);
	}
	
	@Override
	public void update(Observable slogoData, Object arg) {
		/** 
		 * SLogoView observes the instance of SLogoData contained in the controller.
		 * If this instance of SLogoData changes (due to backend action), we will receive the new information
		 * and then update the screen (setTurtles based on new turtle info, display new variables on screen, etc.)
		 */
		mySlogoData = (SLogoData) slogoData;
		myVariablesView.setVariables(mySlogoData.getVariables());
		myTurtleWindow.setTurtles(mySlogoData.getTurtles());
		myTurtleWindow.changeBackgroundColor(mySlogoData.getBackgroundColor());
		myTurtleWindow.setToolTips();
	}

	private void setUpScrollPanes() {
		myLeftScrollPane = new ScrollPane();
		myLeftScrollPane.setPrefSize(Constants.TURTLE_WINDOW_SIZE / 2, Constants.TURTLE_WINDOW_SIZE);
		myLeftScrollPaneVBox = new VBox();
		myPaletteView = new PaletteView();
		setUpColorChangers();
		setUpPenThicknessSlider();
		myLeftScrollPaneVBox.getChildren().addAll(myPaletteView.getNode(), myPenColorChanger, myBackgroundColorChanger, myPenThicknessChanger);
		myLeftScrollPane.setContent(myLeftScrollPaneVBox);
		rightScrollPane = new ScrollPane();
		rightScrollPane.setPrefSize(Constants.TURTLE_WINDOW_SIZE / 2, Constants.TURTLE_WINDOW_SIZE);
		myVariablesView = new VariablesView();
		rightScrollPane.setContent(myVariablesView.getNode());
		
	}
	
	@SuppressWarnings("serial")
	private void setUpColorChangers() {
		myPenColorChanger = new HBox();
		myPenColorChanger.setAlignment(Pos.BASELINE_RIGHT);
		Label penColorTitle = new Label(Constants.PEN_COLOR_LABEL);
		myPenColorChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(
		new ArrayList<String>() {{
			for (int i = 0; i < 4; i++) add(Constants.PALETTE_COLOR_LABEL + i);
		}}));
		myPenColorChoiceBox.getSelectionModel().selectFirst();
		myPenColorChanger.getChildren().addAll(penColorTitle, myPenColorChoiceBox);
		myBackgroundColorChanger = new HBox();
		myBackgroundColorChanger.setAlignment(Pos.BASELINE_RIGHT);
		Label backgroundColorTitle = new Label(Constants.BACKGROUND_COLOR_LABEL);
		myBackgroundColorPicker = new ColorPicker();
		myBackgroundColorPicker.setPrefWidth(Constants.MEDIUM_BUTTON_SIZE);
		myBackgroundColorChanger.getChildren().addAll(backgroundColorTitle, myBackgroundColorPicker);
	}
	
	private void setUpPenThicknessSlider() {
		myPenThicknessChanger = new HBox();
		Label penThicknessTitle = new Label("Pen Thickness: ");
		myPenThicknessSlider = new Slider();
		myPenThicknessSlider.setOrientation(Orientation.HORIZONTAL);
		myPenThicknessSlider.setMajorTickUnit(Constants.SLIDER_INCREMENT_VALUE);
		myPenThicknessSlider.setMax(Constants.MAX_SLIDER_VALUE);
		myPenThicknessSlider.setShowTickMarks(true);
		myPenThicknessSlider.setShowTickLabels(true);
		myPenThicknessSlider.setPrefWidth(Constants.TURTLE_WINDOW_SIZE / 4);
		myPenThicknessChanger.getChildren().addAll(penThicknessTitle, myPenThicknessSlider);
	}

	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(myLeftScrollPane);
		myBorderPane.setRight(rightScrollPane);
		myBorderPane.setCenter(myTurtleWindow.getRoot());
		myBorderPane.setTop(topVBox);
	}

	private void displayStage(Stage s) {
		myScene = new Scene(myRoot, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE, Constants.BACKGROUND_COLOR);
		s.setScene(myScene);
		s.setTitle(Constants.APPLICATION_TITLE);
		s.show();
	}
	
	public TurtleWindowView getTurtleWindow() {
		return myTurtleWindow;
	}

	private void setUpButtonActions(){
		setUpLanguageChoice();
		setUpPenColorChoiceBox();
		setUpPenThicknessSliderHandler();
		setUpTurtleMovementButtonHandlers();
		setUpTurtleExecuteButtonHandler();
		setUpTurtleImageSelectionHandler();
		setUpVariableUpdateHandler();
		setUpViewSelectionGraphicallyHandler();
		setUpBackgroundColorPickerHandler();
		for (int i = 0; i < myPaletteView.getColorPickers().size(); i++) setUpColorPickerEventHandlers(i);
	}
	
	private void setUpLanguageChoice() {
		myMenuBar.getLanguageChoiceBox().getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				myController.getMainSLogoData().setLanguage(newValue);
			}});
	}
	
	private void setUpPenColorChoiceBox(){
		myPenColorChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				myController.getMainSLogoData().setPenColor((int) newValue);
			}});
	}
	

	private void setUpPenThicknessSliderHandler() {
		myPenThicknessSlider.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				myController.getMainSLogoData().setPenWidth((double) newValue);
			}});
	}

	private void setUpBackgroundColorPickerHandler() {
		myBackgroundColorPicker.setOnAction(e -> myController.getMainSLogoData().changeBackgroundColor(myBackgroundColorPicker.getValue()));
	}

	private void setUpViewSelectionGraphicallyHandler() {
		myCommandPrompt.getGraphicalDisplayButton().setOnAction(e -> {
			toggleShowSelection();
			myController.getMainSLogoData().showSelectedGraphically(showSelectedGraphically);
		});
	}


	private void setUpVariableUpdateHandler() {
		myVariablesView.getUpdateButton().setOnAction(e -> {
			myVariablesView.updateVariables();
			myController.getMainSLogoData().setVariables(myVariablesView.getVariables());
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle(Constants.VARIABLE_UPDATE_MESSAGE);
			alert.setContentText(Constants.VARIABLE_UPDATE_CONFIRMATION_MESSAGE);
			alert.showAndWait();
		});	
	}


	private void setUpTurtleImageSelectionHandler() {
		myCommandPrompt.getTurtleImageSelectionButton().setOnAction(e -> {
			FileChooser fc = new FileChooser();
	        fc.setTitle(Constants.IMAGE_CHOOSER_TITLE);
	        fc.setInitialDirectory(new File(System.getProperty("user.dir"), "./images"));
	        fc.getExtensionFilters().setAll(new ExtensionFilter("Images", "*.png"));
	        File imageFile;
	        if (!((imageFile = fc.showOpenDialog(null)) == null)){
	        	myController.getMainSLogoData().changeImage(new Image(imageFile.getName()));
	        }});
	}


	private void setUpTurtleExecuteButtonHandler() {
		myCommandPrompt.getExecuteButton().setOnAction(action -> {
			if (!myCommandPrompt.getUserInput().replace("\n", " ").trim().equals(""))
				try {
					myController.getMainSlogoModel().parse(myCommandPrompt.getUserInput().replace("\n", " ").trim());
				} catch (Exception e) {
					new ExceptionAlert(e);
				}
				myCommandPrompt.addCommandToHistory(myCommandPrompt.getUserInput());
				myCommandPrompt.setCommandPromptText(Constants.EMPTY_STRING); //clear command prompt
		});
	}

	private void setUpTurtleMovementButtonHandlers() {
		myCommandPrompt.setForwards(e -> myController.getMainSLogoData().moveSelectedTurtles(Constants.FORWARD_BUTTON_DISTANCE, 0));
		myCommandPrompt.setBackwards(e -> myController.getMainSLogoData().moveSelectedTurtles(Constants.BACKWARDS_BUTTON_DISTANCE, 0));
		myCommandPrompt.setRotateLeft(e -> myController.getMainSLogoData().moveSelectedTurtles(0, Constants.LEFT_BUTTON_ROTATION));
		myCommandPrompt.setRotateRight(e -> myController.getMainSLogoData().moveSelectedTurtles(0, Constants.RIGHT_BUTTON_ROTATION));
	}


	private void setUpColorPickerEventHandlers(int index) {
		myPaletteView.getColorPickers().get(index).setOnAction(e -> 
		myController.getMainSLogoData().changeColor(index, myPaletteView.getColorPickers().get(index).getValue()));
	}
	
	private void toggleShowSelection() {
		/** change this boolean value that tells us whether to display selected turtles differently (set true to false and vice-versa) */
		showSelectedGraphically = !showSelectedGraphically;
	}
}