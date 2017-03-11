package frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import backend.SLogoData;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import constants.Constants;

/**
 *  @author Daniel
 *  @author Hari
 *  
 *  This class contains all the elements on the screen (we initialize all
 *  screen elements from here).
 *  This class also contains an instance of SLogoData, which holds the
 *  information about the turtles, pen info, etc. Using observers,
 *  we update the display is mySlogoData changes from the backend,
 *  and backend receives updates if information is changed from 
 *  the frontend (ex: if pen color or variable values are changed).
 *  
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

	public SLogoView(Stage s) {
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
		displayStage(s);
	}

	/**
	 * 
	 */
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
	
	public ColorPicker getBackgroundColorPicker() {
		/** get the background color picker */
		return myBackgroundColorPicker;
	}

	public CommandPromptView getCommandBox() {
		/** get the command box */
		return myCommandPrompt;
	}

	public TurtleWindowView getTurtleWindow() {
		/** get the turtle window */
		return myTurtleWindow;
	}

	public Button getExecuteButton() {
		/** get the execute button */
		return myCommandPrompt.getExecuteButton();
	}

	public String getUserInput() {
		/** get the user's input in the command line as a string */
		return myCommandPrompt.getUserInput();
	}

	public void addCommandToHistory(String cmd) {
		/** add string to our command prompt's history */
		myCommandPrompt.addCommandToHistory(cmd);
	}

	public void clearCommandPrompt() {
		/** clear the command prompt */
		myCommandPrompt.setCommandPromptText("");
	}
	
	public ChoiceBox<String> getPenColorChoiceBox() {
		/** get the pen color chooser */
		return myPenColorChoiceBox;
	}
	
	public Slider getPenThicknessSlider() {
		/** get the 'choose pen thickness slider' */
		return myPenThicknessSlider;
	}
	
	public List<ColorPicker> getPaletteColorPickers() {
		/** get the list of color pickers contained in the palette
		 * (the currently selected color can be retrieved within each color picker) */
		return myPaletteView.getColorPickers();
	}
	
	public ChoiceBox<String> getLanguageChoiceBox() {
		/** get the language choice box */
		return myMenuBar.getLanguageChoiceBox();
	}
	
	public CheckBox getGraphicalDisplayButton(){
		/** get the checkbox which enables us to display selected
		 * turtles differently from non-selected ones */
		return myCommandPrompt.getGraphicalDisplayButton();
	}
	
	public boolean getShowSelected() {
		/** get the boolean value that tells us whether to display selected turtles differently */
		return showSelectedGraphically;
	}
	
	public void toggleShowSelection() {
		/** change this boolean value that tells us whether to display selected turtles differently
		 * (set true to false and vice-versa) */
		showSelectedGraphically = !showSelectedGraphically;
	}

	public Button getVariableUpdateButton() {
		/** get the button in the variables view that updates variable values with what the user has typed graphically */
		return myVariablesView.getUpdateButton();
	}
	
	public VariablesView getVariablesView() {
		/** get our entire variables view */
		return myVariablesView;
	}
	
	public Button getTurtleImageSelectionButton() {
		/** get the button that allows us to chose a new image for the turtle */
		return myCommandPrompt.getTurtleImageSelectionButton();
	}
	
	@Override
	public void update(Observable slogoData, Object arg) {
		/** 
		 * Using Observable, we make sure that we are always displaying the variables
		 * contained in SLogoData, the turtles contained in SlogoData, and the background
		 * in SLogoData.
		 */
		mySlogoData = (SLogoData) slogoData;
		myVariablesView.setVariables(mySlogoData.getVariables());
		myTurtleWindow.setTurtles(mySlogoData.getTurtles());
		myTurtleWindow.changeBackgroundColor(mySlogoData.getBackgroundColor());
		myTurtleWindow.setToolTips();
	}

}
