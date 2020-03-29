package application;
	
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
//import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

public class Main extends Application
{
	static int block_size = 10;
	int width = 50,height = 50;
	int initialLength = 1;
	long time = System.nanoTime(); // slow down the animation
	boolean moved = false;
	Grid g;
	
	@Override
	public void start(Stage ps)
	{
			VBox root = new VBox(10); // import javafx.scene.layout.VBox;
			root.setPadding(new Insets(10)); // import javafx.geometry.Insets
			
			g = new Grid(width,height);
			g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
						
			AnimationTimer timer = new AnimationTimer() 
			{
				public void handle(long now)
				{
					if(now - time > 1000000000 / 10)
					{
						g.update();
						time = now;
						moved = false;
						
						if(g.gameOverP1())
						{
							stop();
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText("Player 2 Wins!");
							Platform.runLater(alert::showAndWait);
							
							alert.setOnHidden(e -> {
								root.getChildren().remove(g);
								g = new Grid(width, height);
								g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
								root.getChildren().add(g);
								start();

							});
						}
						
						if(g.gameOverP2())
						{
							stop();
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText("Player 1 Wins!");
							Platform.runLater(alert::showAndWait);
							
							alert.setOnHidden(e -> {
							root.getChildren().remove(g);
							g = new Grid(width, height);
							g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
							root.getChildren().add(g);
							start();
							});
						}
					}
				}
			};
			timer.start();
			
			root.getChildren().add(g);
			
			Scene scene = new Scene(root);
			//	ArrayList<Block> blocks1 = new ArrayList<Block>();

			final ArrayList<KeyCode> acceptedCodes = new ArrayList<KeyCode>();
			acceptedCodes.add(KeyCode.W);
			acceptedCodes.add(KeyCode.A);
			acceptedCodes.add(KeyCode.S);
			acceptedCodes.add(KeyCode.D);
			acceptedCodes.add(KeyCode.UP);
			acceptedCodes.add(KeyCode.RIGHT);
			acceptedCodes.add(KeyCode.LEFT);
			acceptedCodes.add(KeyCode.DOWN);
			
			final Set<KeyCode> codes = new HashSet<>();
			scene.setOnKeyReleased(e -> codes.clear());
			scene.setOnKeyPressed(e -> {
				if(acceptedCodes.contains(e.getCode()))
				{
					codes.add(e.getCode());
					if(codes.contains(KeyCode.UP) && g.p1.getDirection() != Block.DOWN)
					{
						setDirection(g.p1, Block.UP);
					}
					else if(codes.contains(KeyCode.RIGHT) && g.p1.getDirection() != Block.LEFT)
					{
						setDirection(g.p1, Block.RIGHT);
					}
					else if(codes.contains(KeyCode.DOWN) && g.p1.getDirection() != Block.UP)
					{
						setDirection(g.p1, Block.DOWN);
					}
					else if(codes.contains(KeyCode.LEFT) && g.p1.getDirection() != Block.RIGHT)
					{
						setDirection(g.p1, Block.LEFT);
					}
					
					if(codes.contains(KeyCode.W) && g.p2.getDirection() != Block.DOWN)
					{
						setDirection(g.p2, Block.UP);
					}
					else if(codes.contains(KeyCode.D) && g.p2.getDirection() != Block.LEFT)
					{
						setDirection(g.p2, Block.RIGHT);
					}
					else if(codes.contains(KeyCode.S) && g.p2.getDirection() != Block.UP)
					{
						setDirection(g.p2, Block.DOWN);
					}
					else if(codes.contains(KeyCode.A) && g.p2.getDirection() != Block.RIGHT)
					{
						setDirection(g.p2, Block.LEFT);
					}
				}
			});
//			
//			scene.setOnKeyPressed(key1 -> {
//				if(key1.getCode().equals(KeyCode.UP) && g.p1.getDirection() != Block.DOWN)
//				{
//					setDirection(g.p1, Block.UP);
//				}
//				else if(key1.getCode().equals(KeyCode.RIGHT) && g.p1.getDirection() != Block.LEFT)
//				{
//					setDirection(g.p1, Block.RIGHT);
//				}
//				else if(key1.getCode().equals(KeyCode.DOWN) && g.p1.getDirection() != Block.UP)
//				{
//					setDirection(g.p1, Block.DOWN);
//				}
//				else if(key1.getCode().equals(KeyCode.LEFT) && g.p1.getDirection() != Block.RIGHT)
//				{
//					setDirection(g.p1, Block.LEFT);
//				}
//			});
//			scene.setOnKeyPressed(key2 -> {
//				if(key2.getCode().equals(KeyCode.W) && g.p2.getDirection() != Block.DOWN)
//				{
//					setDirection(g.p2, Block.UP);
//				}
//				else if(key2.getCode().equals(KeyCode.D) && g.p2.getDirection() != Block.LEFT)
//				{
//					setDirection(g.p2, Block.RIGHT);
//				}
//				else if(key2.getCode().equals(KeyCode.S) && g.p2.getDirection() != Block.UP)
//				{
//					setDirection(g.p2, Block.DOWN);
//				}
//				else if(key2.getCode().equals(KeyCode.A) && g.p2.getDirection() != Block.RIGHT)
//				{
//					setDirection(g.p2, Block.LEFT);
//				}
//			});
			
			ps.setResizable(false);
			ps.setScene(scene);
			ps.setTitle("Tron");
			
			ps.show();
	}
	
	public void setDirection(Player p1, int num)
	{
		if(!moved)
		{
			p1.setDirection(num);
			moved = true;
		}
	}
	
	public void setDirection(Player2 p2, int num)
	{
		if(!moved)
		{
			p2.setDirection(num);
			moved = true;
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
