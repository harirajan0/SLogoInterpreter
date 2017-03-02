/**
 * 
 */
package main;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author harirajan
 *
 */
public class Main extends Application {

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage s) throws Exception {
		// TODO Auto-generated method stub
		
		SLogoController myController = new SLogoController(s);
		
		s = myController.getView().getInitializedStage(s);
		s.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
