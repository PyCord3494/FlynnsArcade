package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;


public class Main extends Application
{
	static int block_size = 10;
	
	int width = 50,height = 50;
	
	@Override
	public void start(Stage ps)
	{
			VBox root = new VBox(10); // import javafx.scene.layout.VBox;
			root.setPadding(new Insets(10)); // import javafx.geometry.Insets
			
			Grid g = new Grid(width,height);
			
			root.getChildren().add(g);
			
			Scene scene = new Scene(root);
			
			ps.setResizable(false);
			ps.setScene(scene);
			ps.setTitle("Tron");
			
			ps.show();
	}
//	public void start(Stage primaryStage) {
//		try {
//			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Menu.fxml"));
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
