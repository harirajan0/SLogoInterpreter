package frontend;

import java.util.Observable;
import java.util.Observer;
import constants.Constants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.SLogoData;
import screenElements.BackgroundColorChanger;
import screenElements.CommandDisplayer;
import screenElements.CommandPromptView;
import screenElements.LanguageSelector;
import screenElements.Palette;
import screenElements.PaletteView;
import screenElements.PenColorChanger;
import screenElements.PenSlider;
import screenElements.TurtleWindowView;
import screenElements.VariablesView;

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
	private Palette myPalette;
	private MenuItem languageMenu;
	private MenuItem penColorMenu;
	private MenuItem penThicknessMenu;
	private LanguageSelector myLanguageSelector;
	private PenSlider myPenSlider;
	private MenuItem helpMenu;
	private MenuItem backgroundColorMenu;
	private Button paletteOpener;

	public SLogoView(Stage s) {
		myRoot = new Group();
		topVBox = new VBox();
		myCommandPrompt = new CommandPromptView();
		myVariablesView = new VariablesView();
		myBorderPane = new BorderPane();
		myTurtleWindow = new TurtleWindowView();
		myPalette=new Palette();
		paletteOpener=new Button(Constants.DEFAULT_RESOURCE_BUNDLE.getString("palettePrompt"));
		paletteOpener.setOnAction(event ->  {
	    	myPalette.show();
	    });
		Text header = new Text(Constants.APPLICATION_TITLE);
		header.setFont(new Font(Constants.TITLE_FONT, Constants.TITLE_FONT_SIZE));
		myMenuBar = new MenuView(s);
		for (int i = 0; i < myMenuBar.getMenuItems().size(); i++) {
			if (myMenuBar.getMenuItems().get(i).getText()
					.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("listPrompt"))) {
				helpMenu = myMenuBar.getMenuItems().get(i);
			}
			if (myMenuBar.getMenuItems().get(i).getText()
					.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penColor"))) {
				penColorMenu = myMenuBar.getMenuItems().get(i);
			}

			if (myMenuBar.getMenuItems().get(i).getText()
					.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("penThickness"))) {
				penThicknessMenu = myMenuBar.getMenuItems().get(i);
				myPenSlider = new PenSlider();

			}
			if (myMenuBar.getMenuItems().get(i).getText()
					.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("backgroundColor"))) {
				backgroundColorMenu = myMenuBar.getMenuItems().get(i);
				BackgroundColorChanger bc=new BackgroundColorChanger();
				backgroundColorMenu.setOnAction(event -> {
					bc.setObjectToChangeColorOf(myTurtleWindow);
					bc.show();
					});
			}

			if (myMenuBar.getMenuItems().get(i).getText()
					.equals(Constants.DEFAULT_RESOURCE_BUNDLE.getString("languagePrompt"))) {
				languageMenu = myMenuBar.getMenuItems().get(i);
				myLanguageSelector = new LanguageSelector();
				myLanguageSelector.getChoiceBox().getSelectionModel().selectedIndexProperty()
						.addListener(new ChangeListener<Number>() {
							@Override
							public void changed(ObservableValue<? extends Number> observableValue, Number number,
									Number number2) {
								mySlogoData.setLanguage(
										(myLanguageSelector.getChoiceBox().getItems().get((Integer) number2)));
							}
						});
			}
		}

		helpMenu.setOnAction(event -> {
			CommandDisplayer myCommandDisplay = new CommandDisplayer();
			myCommandDisplay.show();
		});

	 penColorMenu.setOnAction(event -> {
		PenColorChanger pc=new PenColorChanger();
		pc.setObjectToChangeColorOf(mySlogoData);
		pc.show();
	  });
	 
		penThicknessMenu.setOnAction(event -> {
			myPenSlider.show();
			myPenSlider.getSlider().valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
					mySlogoData.setPenWidth(new_val.doubleValue());
				}
			});
		});

		languageMenu.setOnAction(event -> {
			myLanguageSelector.show();
		});

		topVBox.getChildren().addAll(myMenuBar.getNode(), header);
		setUpBorderPane();
		myRoot.getChildren().addAll(myBorderPane);
		displayStage(s);
	}

	private void setUpBorderPane() {
		myBorderPane.setBottom(myCommandPrompt.getNode());
		myBorderPane.setLeft(paletteOpener);
		myBorderPane.setRight(myVariablesView.getNode());
		myBorderPane.setCenter(myTurtleWindow.getNode());
		myBorderPane.setTop(topVBox);
	}

	private void displayStage(Stage s) {
		myScene = new Scene(myRoot, Constants.WINDOW_SIZE, Constants.WINDOW_SIZE, Constants.BACKGROUND_COLOR);
		s.setScene(myScene);
		s.setTitle(Constants.APPLICATION_TITLE);
		s.show();
	}

	// FIX THIS

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable slogoData, Object arg) {
		// TODO Auto-generated method stub
		mySlogoData = (SLogoData) slogoData;
		myVariablesView.setVariables(mySlogoData.getVariables());
		myTurtleWindow.setTurtles(mySlogoData.getTurtles());
		myTurtleWindow.changeBackgroundColor(myTurtleWindow.getBackgroundRectangle().getFill());
		myTurtleWindow.setToolTips();

		//myTurtleWindow.changeBackgroundColor(myPaletteView.getColorAtIndex(mySlogoData.getBackgroundColorIndex()));
	}

}
