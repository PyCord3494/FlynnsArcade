package application;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuController extends Application {
		
	static int block_size = 10;
	int width = 100,height = 55;
	int initialLength = 1;
	long time = System.nanoTime(); // slow down the animation
	boolean moved = false;
	Grid g;
	int player1Score = 0;
	int player2Score = 0;
	List<Integer> arr = new ArrayList<Integer>();
	List<Integer> arr2 = new ArrayList<Integer>();
	
	public void start(Stage ps)
	{
			VBox root = new VBox(10); // import javafx.scene.layout.VBox;
			root.setPadding(new Insets(5)); // import javafx.geometry.Insets
			
			g = new Grid(width,height);
			g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
						
			// Start button
			root.getChildren().add(g);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("Press OK to start game!\nPlayer 1 is red.\nPlayer 2 is blue.");
			Platform.runLater(alert::showAndWait);
			alert.setOnHidden(e ->{
			
			//
			AnimationTimer timer = new AnimationTimer() 
			{
				public void handle(long now)
				{
					stop();
					
					start();
					if(now - time > 1000000000 / 10)
					{
						g.update();
						time = now;
						moved = false;
						
						if(g.gameOverP1() && g.gameOverP2())
						{
							stop();
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setHeaderText("We have a tie!");
							Platform.runLater(alert::showAndWait);
							
							alert.setOnHidden(e -> {
								root.getChildren().remove(g);
								g = new Grid(width, height);
								g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
								root.getChildren().add(g);
								start();
							});
							player1Score--;
							player2Score--;
						}
						else if(g.gameOverP1())
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
							player2Score++;
						}
						
						else if(g.gameOverP2())
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
							player1Score++;
						}
					}
				}
			};
			timer.start();
			});// end of start button
			
			//root.getChildren().add(g);
			
			Scene scene = new Scene(root);
			
		    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                    case LEFT:
                    	if(event.getCode().equals(KeyCode.LEFT) && g.p2.getDirection() != Block.RIGHT)
                    	{
                    		setDirection(g.p2, Block.LEFT);
                        	break;
                    	}
                    case RIGHT:
                    	if(event.getCode().equals(KeyCode.RIGHT) && g.p2.getDirection() != Block.LEFT)
                    	{
	                        setDirection(g.p2, Block.RIGHT);
	                        break;
                    	}
                    case UP:
                    	if(event.getCode().equals(KeyCode.UP) && g.p2.getDirection() != Block.DOWN)
                    	{
	                        setDirection(g.p2, Block.UP);
	                        break;
                    	}
                    case DOWN:
                    	if(event.getCode().equals(KeyCode.DOWN) && g.p2.getDirection() != Block.UP)
                    	{
	                        setDirection(g.p2, Block.DOWN);
	                        break;
                    	}
                    
                    case A:
                    	if(event.getCode().equals(KeyCode.A) && g.p1.getDirection() != Block.RIGHT)
                    	{
	                        setDirection(g.p1, Block.LEFT);
	                        break;
                    	}
                    case D:
                    	if(event.getCode().equals(KeyCode.D) && g.p1.getDirection() != Block.LEFT)
                    	{
	                        setDirection(g.p1, Block.RIGHT);
	                        break;
                    	}
                    case W:
                    	if(event.getCode().equals(KeyCode.W) && g.p1.getDirection() != Block.DOWN)
                    	{
	                        setDirection(g.p1, Block.UP);
	                        break;
                    	}
                    case S:
                    	if(event.getCode().equals(KeyCode.S) && g.p1.getDirection() != Block.UP)
                    	{
	                        setDirection(g.p1, Block.DOWN);
	                        break;
                    	}
                    default:
                        break;
                    }
                }
            });
			
			ps.setResizable(false);
			ps.setScene(scene);
			ps.setTitle("Tron");
			
			ps.show();
	}
	
	public void setDirection(Player p1, int num)
    {
        arr.add(num);
        ListIterator<Integer> itr = arr.listIterator(); 
        while(itr.hasNext())
        {
            p1.setDirection(itr.next());
            moved = true;
        }
    }
    
    public void setDirection(Player2 p2, int num)
    {
        arr2.add(num);
        ListIterator<Integer> itr2 = arr2.listIterator(); 
        while(itr2.hasNext())
        {
            p2.setDirection(itr2.next());
            moved = true;
        }
    }
}
