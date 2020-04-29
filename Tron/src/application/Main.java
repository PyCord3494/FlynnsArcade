package application;

import java.io.IOException;
import application.controller.LastViewController;
import application.model.ScoreTracker;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main function that runs the entire program. Loads the FXML files for all screens and controllers.
 * 
 * @author kxm210, gtp818, yng451 and uys943
 */
public class Main extends Application
{
	private Stage primaryStage;
	private BorderPane startScene;
	private AnchorPane optionsScene;
	private BorderPane gameOverScene;
	

	@Override
	/**
	 * Function to display the first scene of the game.
	 * 
	 * @param primaryStage		the primary stage called for the first scene
	 * @throws Exception		exception for showStartView() if it can't load the FXML file
	 */
	public void start(Stage primaryStage) throws Exception {
		try{
			this.primaryStage = primaryStage;
			showStartView();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to load the start view FXML file.
	 * 
	 * @throws IOException		exception for if the file is not found/loaded properly
	 */
	public void showStartView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("controller/StartView.fxml"));
		startScene = loader.load();
		primaryStage.setScene(new Scene(startScene));
		primaryStage.show();
	}
	
	/**
	 * Function to load the second scene from FXML file.
	 * 
	 * @param event				Button from first scene used to load second scene
	 * @throws IOException		exception for if the file is not found/loaded properly
	 */
	public void showMenuView(Event event) throws IOException{	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("controller/MenuView.fxml"));
		optionsScene = loader.load();
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(optionsScene));
		window.show();
	}
	
	/**
	 * Function to load the final scene from FXML file.
	 * 
	 * @param window			Stage object to show the app screen
	 * @param message			String passed to the game over controller to display on label
	 * @param st				String passed to the game over controller to keep track of player scores
	 * @throws IOException		exception for if the FXML file is not found or can't load
	 */
	public void showGameOverView(Stage window, String message, ScoreTracker st) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("controller/GameOverView.fxml"));
		gameOverScene = loader.load();
		LastViewController lv = loader.getController();
		lv.setLabel(message,st);
		window.setScene(new Scene(gameOverScene));
		window.show();
	}
	
	/**
	 * Main method to run the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
    }


}
