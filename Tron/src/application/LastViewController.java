package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Java class to handle the ending screen of the game
 * Provides the "Race Again" and "Go to Main Menu" buttons' functionality
 * @author uys943
 */
public class LastViewController extends Application {
	private Main main;
	private MainMenuController game;
	
	@FXML Button playAgain;
	@FXML Button exit2Menu;
	@FXML Label label;
	
	public void setLabel(String score){
		label.setText(score);
	}

	/**
	 * Handler for "Race Again" option
	 * @param event
	 * @throws Exception
	 */
	public void handlePlayAgain(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		game = new MainMenuController();
		game.start(window);
	}
	
	/**
	 * Handler for "Go to Main Menu" option
	 * @param event
	 * @throws Exception
	 */
	public void handleGo2Menu(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		main = new Main();
		main.start(window);
	}
}