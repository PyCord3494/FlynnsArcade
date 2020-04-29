package application.controller;

import application.model.ScoreTracker;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * This class handles the second scene in the game (getting player names)
 * and displays it from the FXML file.
 * 
 * @author kxm210
 */
@SuppressWarnings("rawtypes")
public class SecondViewController implements EventHandler{
	
	@FXML private TextField player1;
	@FXML private TextField player2;

	@Override
	/**
	* This function handles the view where the players enter their names before the game starts.
	* The game won't begin until both name slots are filled.
	* 
	* @param even		variable to check if button was pressed
	*/
	public void handle(Event event) {
		if(!player1.getText().isEmpty() && !player2.getText().isEmpty())
		{
			ScoreTracker scoreT = new ScoreTracker(player1.getText(),player2.getText());
			MainMenuController game = new MainMenuController();
			game.passScoreTracker(scoreT);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			game.start(window);
		}
	}
	
	
}

