package View;

import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.util.HashMap;


public class SLogoView extends Application {
	/**
	 * Start the program.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Initialize what will be displayed and how it will be updated.
	 */
	// @Override
	public void start(Stage s) {
		s=new ViewInitializer().getInitializedStage(s);
		s.show();

	}

}
