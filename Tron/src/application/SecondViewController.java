package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * 
 * @author kxm210
 *
 */
public class SecondViewController implements EventHandler{
	
	private Main main;
	@FXML private TextField player1;
	@FXML private TextField player2;

	@Override
	/**
	* This function handles the view where the players enter the names before the game starts
	* Cant begin game until both name slots are filled.
	*/
	public void handle(Event event) {
		if(!player1.getText().isEmpty() && !player2.getText().isEmpty())
		{
			String p1 = player1.getText();
			String p2= player2.getText();
			MainMenuController game = new MainMenuController();
			game.setPlayer(p1,p2);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			game.start(window);
		}
	}
	
	
}

