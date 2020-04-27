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

	
	public void handlePlayAgain(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		game = new MainMenuController();
		game.start(window);
	}
	
	public void handleGo2Menu(Event event) throws Exception{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		main = new Main();
		main.start(window);
	}
}