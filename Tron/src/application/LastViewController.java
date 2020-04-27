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
	
	public String p1;
	public String p2;
	
	public void setLabel(String score, String player1, String player2){
		label.setText(score);
		this.p1 = player1;
		this.p2 = player2;
	}

	/**
	 * Handler for "Race Again" option
	 * @param event
	 * @throws Exception
	 */
	public void handlePlayAgain(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		game = new MainMenuController();
		game.setPlayer(this.p1, this.p2);
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