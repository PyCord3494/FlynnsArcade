package application.controller;
import application.Main;
import application.model.ScoreTracker;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Java class to handle the ending screen of the game.
 * Provides the "Race Again" and "Go to Main Menu" buttons' functionality.
 * 
 * @author uys943
 */
public class LastViewController extends Application {
	private Main main;
	private MainMenuController game;
	
	
	@FXML Button playAgain;
	@FXML Button exit2Menu;
	@FXML Label label;
	ScoreTracker currentPlayers;
	
	/**
	 * Function to display who wins on the game over screen.
	 * 
	 * @param score		String to display of which player wins
	 * @param st		Data of each player's score to display on screen
	 */
	public void setLabel(String score, ScoreTracker st){
		label.setText(score);
		this.currentPlayers = st;
	}

	/**
	 * Handler for "Race Again" option.
	 * 
	 * @param event			action recorded for if the button is pressed on the scene
	 */
	public void handlePlayAgain(Event event)
	{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		game = new MainMenuController();
		game.passScoreTracker(this.currentPlayers);
		game.start(window);
	}
	
	/**
	 * Handler for "Go to Main Menu" option.
	 * 
	 * @param event				variable to keep track of button press
	 * @throws Exception		exception for if the primary view is not loaded
	 */
	public void handleGo2Menu(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		main = new Main();
		main.start(window);
	}

	@Override
	/**
	 * Function required by class.
	 */
	public void start(Stage arg0) throws Exception
	{		
	}
}