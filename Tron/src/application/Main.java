package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * 
 * @author kxm210
 *
 */
public class Main extends Application
{
	private Stage primaryStage;
	private BorderPane startScene;
	private AnchorPane optionsScene;
	private BorderPane gameOverScene;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			this.primaryStage = primaryStage;
			showStartView();
		}
		catch(Exception e){
			System.out.println("Cause of Exception: " + e.getCause());
		}
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void showStartView() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("StartView.fxml"));
		startScene = loader.load();
		primaryStage.setScene(new Scene(startScene));
		primaryStage.show();
	}
	
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void showMenuView(Event event) throws IOException{	
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("MenuView.fxml"));
		optionsScene = loader.load();
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(new Scene(optionsScene));
		window.show();
	}
	
	/**
	 * 
	 * @param window
	 * @param score
	 * @throws IOException
	 */
	public void showGameOverView(Stage window, String score, String player1, String player2) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("GameOverView.fxml"));
		gameOverScene = loader.load();
		LastViewController lv = loader.getController();
		lv.setLabel(score, player1, player2);
		window.setScene(new Scene(gameOverScene));
		window.show();
	}
	
	/**
	 * Main method to run the program
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
    }


}
