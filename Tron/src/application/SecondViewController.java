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

public class SecondViewController implements EventHandler{
	
	private Main main;
	@FXML private TextField player1;
	@FXML private TextField player2;
	@Override
	public void handle(Event event) {
		if(!player1.getText().isEmpty() && !player2.getText().isEmpty())
		{
			MainMenuController game = new MainMenuController();
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			game.start(window);
		}
	}
}

