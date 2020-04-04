package application;
	





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
	public static void main(String[] args) {
       Application.launch(MainMenuController.class, args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
		    AnchorPane pane;
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/Main.fxml"));		//connecting the view to the fxml loader
			pane=loader.load();
			Scene scene = new Scene(pane);
			primaryStage.setTitle("Space Federation");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
