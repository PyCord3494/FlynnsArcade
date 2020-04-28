package application.controller;

import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import application.Main;
/***
 * 
 * @author uys943
 *
 */
@SuppressWarnings("rawtypes")
public class FirstViewController implements EventHandler{
	Main main;
	@Override
	
	/***
	 * @param event
	 * This handles the user clicking the button to load the next view which is the view with the user names.
	 */
	public void handle(Event event) {
		//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		main = new Main();
		try {
			main.showMenuView(event);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
