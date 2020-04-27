package application;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LastViewController extends Application {
	private Main main;
	private MainMenuController game;
	
	@FXML Button playAgain;
	@FXML Button exit2Menu;

	public void handle(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		if(playAgain != null){
			game.start(window);
		}
		else{ //if exit2Menu
			System.out.print("Go back to main menu");
			main = new Main();
			main.start(window);
		}
	}
}