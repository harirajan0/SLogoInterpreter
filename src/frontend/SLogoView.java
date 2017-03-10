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
		// TODO Auto-generated method stub
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
		Label penColorTitle = new Label("Pen Color: ");
		myPenColorChoiceBox = new ChoiceBox<String>(FXCollections.observableArrayList(
		new ArrayList<String>() {{
			for (int i = 0; i < 4; i++) add("Palette Color " + i);
		}}));
		myPenColorChoiceBox.getSelectionModel().selectFirst();
		myPenColorChanger.getChildren().addAll(penColorTitle, myPenColorChoiceBox);
		myBackgroundColorChanger = new HBox();
		myBackgroundColorChanger.setAlignment(Pos.BASELINE_RIGHT);
		Label backgroundColorTitle = new Label("Background Color: ");
		myBackgroundColorPicker = new ColorPicker();
		myBackgroundColorPicker.setPrefWidth(50);
		myBackgroundColorChanger.getChildren().addAll(backgroundColorTitle, myBackgroundColorPicker);
	}
	
	private void setUpPenThicknessSlider() {
		myPenThicknessChanger = new HBox();
		Label penThicknessTitle = new Label("Pen Thickness: ");
		myPenThicknessSlider = new Slider();
		myPenThicknessSlider.setOrientation(Orientation.HORIZONTAL);
		myPenThicknessSlider.setMajorTickUnit(5);
		myPenThicknessSlider.setMax(20);
		myPenThicknessSlider.setShowTickMarks(true);
		myPenThicknessSlider.setShowTickLabels(true);
		myPenThicknessSlider.setPrefWidth(110);
		myPenThicknessChanger.getChildren().addAll(penThicknessTitle, myPenThicknessSlider);
	}

	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(myLeftScrollPane);
		myBorderPane.setRight(rightScrollPane);
		myBorderPane.setCenter(myTurtleWindow.getNode());
		myBorderPane.setTop(topVBox);
	}

	private void displayStage(Stage s) {
		myScene = new Scene(myRoot, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE, Constants.BACKGROUND_COLOR);
		s.setScene(myScene);
		s.setTitle(Constants.APPLICATION_TITLE);
		s.show();
	}
	
	public ColorPicker getBackgroundColorPicker() {
		return myBackgroundColorPicker;
	}

	public CommandPromptView getCommandBox() {
		return myCommandPrompt;
	}

	public TurtleWindowView getTurtleWindow() {
		return myTurtleWindow;
	}

	public Button getExecuteButton() {
		return myCommandPrompt.getExecuteButton();
	}

	public String getUserInput() {
		return myCommandPrompt.getUserInput();
	}

	public void addCommandToHistory(String cmd) {
		myCommandPrompt.addCommandToHistory(cmd);
	}

	public void clearCommandPrompt() {
		myCommandPrompt.setCommandPromptText("");
	}
	
	public ChoiceBox<String> getPenColorChoiceBox() {
		return myPenColorChoiceBox;
	}
	
	public Slider getPenThicknessSlider() {
		return myPenThicknessSlider;
	}
	
	public List<ColorPicker> getPaletteColorPickers() {
		return myPaletteView.getColorPickers();
	}
	
	public ChoiceBox<String> getLanguageChoiceBox() {
		return myMenuBar.getLanguageChoiceBox();
	}
	
	public CheckBox getGraphicalDisplayButton(){
		return myCommandPrompt.getGraphicalDisplayButton();
	}
	
	public boolean getShowSelected() {
		return showSelectedGraphically;
	}
	
	public void toggleSlowSelection() {
		showSelectedGraphically = !showSelectedGraphically;
	}

	public Button getVariableUpdateButton() {
		return myVariablesView.getUpdateButton();
	}
	
	public VariablesView getVariablesView() {
		return myVariablesView;
	}
	
	public Button getTurtleImageSelectionButton() {
		return myCommandPrompt.getTurtleImageSelectionButton();
	}
	
	@Override
	public void update(Observable slogoData, Object arg) {
		// TODO Auto-generated method stub
		mySlogoData = (SLogoData) slogoData;
		myVariablesView.setVariables(mySlogoData.getVariables());
		myTurtleWindow.setTurtles(mySlogoData.getTurtles());
		myTurtleWindow.changeBackgroundColor(mySlogoData.getBackgroundColor());
		myTurtleWindow.setToolTips();
	}

}
