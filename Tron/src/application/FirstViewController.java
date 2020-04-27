package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import application.Main;
/***
 * 
 * @author uys943
 *
 */
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
