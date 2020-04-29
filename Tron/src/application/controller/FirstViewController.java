package application.controller;

import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import application.Main;

/**
 * Class to display the start view from FXML file. Handles the start button on screen and
 * calls showMenuView() from Main.java.
 * 
 * @author uys943
 */
@SuppressWarnings("rawtypes")
public class FirstViewController implements EventHandler{
	Main main;
	@Override
	
	/**
	 * This handles the user clicking the button to load the next view,
	 * which is the view with the user names.
	 * 
	 * @param event		variable to see if the button on the scene is clicked
	 */
	public void handle(Event event) {
		main = new Main();
		try
		{
			main.showMenuView(event);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
