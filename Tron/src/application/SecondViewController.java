package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SecondViewController implements EventHandler{
	
	private Main main;
	
	@Override
	public void handle(Event event) {
		MainMenuController game = new MainMenuController();
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		game.start(window);
	}
}

