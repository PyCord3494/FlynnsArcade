package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainMenuController {
	

	
		@FXML private TextField player1;
		@FXML private TextField player2;
		
		
		public void handlePlayerNames(TextField player1, TextField player2)
		{
			while(!player1.getText().isEmpty() && !player2.getText().isEmpty())
			{
				//calls game
			}
		}
}

