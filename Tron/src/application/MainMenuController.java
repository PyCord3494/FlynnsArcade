package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * @author yng451
 *
 */
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
	
	private Main main = new Main();
	String player1;
	String player2;

	public void setPlayer(String p1, String p2){
		this.player1 = p1;
		this.player2 = p2;
	}
	/**
	 * Function to start the game
	 * Passed in the Stage ps to build the application
	 */
	public void start(Stage ps)
	{
			VBox root = new VBox(10); // import javafx.scene.layout.VBox;
			root.setPadding(new Insets(5)); // import javafx.geometry.Insets
			
			g = new Grid(width,height);
			g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
						
			// Start button
			root.getChildren().add(g);
			
			AnimationTimer timer = new AnimationTimer() {
				public void handle(long now){
					stop();
					
					start();
					if(now - time > 1000000000 / 10){
						g.update();
						time = now;
						moved = false;
						
						if(g.gameOverP1() && g.gameOverP2()){
							stop();
							try {
								main.showGameOverView(ps, "It's a tie!");
							} catch (IOException e) {
								e.printStackTrace();
							}
							player1Score--;
							player2Score--;
						}
						else if(g.gameOverP1()){
							stop();
							try {
								main.showGameOverView(ps, "Player "+player2+" Wins");
							} catch (IOException e) {
								e.printStackTrace();
							}
							player2Score++;
						}
						else if(g.gameOverP2()){
							stop();
							try {
								main.showGameOverView(ps, "Player "+player1+ " Wins");
							} catch (IOException e) {
								e.printStackTrace();
							}
							player1Score++;
						}
					}
				}
			};
			timer.start();
			//	}); end of start button
			//root.getChildren().add(g);
			
			Scene scene = new Scene(root);
			
		    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                    case LEFT:
                    	if(event.getCode().equals(KeyCode.LEFT) && g.p2.getDirection() != Block.RIGHT){
                    		setDirection(g.p2, Block.LEFT);
                        	break;
                    	}
                    case RIGHT:
                    	if(event.getCode().equals(KeyCode.RIGHT) && g.p2.getDirection() != Block.LEFT){
	                        setDirection(g.p2, Block.RIGHT);
	                        break;
                    	}
                    case UP:
                    	if(event.getCode().equals(KeyCode.UP) && g.p2.getDirection() != Block.DOWN){
	                        setDirection(g.p2, Block.UP);
	                        break;
                    	}
                    case DOWN:
                    	if(event.getCode().equals(KeyCode.DOWN) && g.p2.getDirection() != Block.UP){
	                        setDirection(g.p2, Block.DOWN);
	                        break;
                    	}
                    
                    case A:
                    	if(event.getCode().equals(KeyCode.A) && g.p1.getDirection() != Block.RIGHT){
	                        setDirection(g.p1, Block.LEFT);
	                        break;
                    	}
                    case D:
                    	if(event.getCode().equals(KeyCode.D) && g.p1.getDirection() != Block.LEFT){
	                        setDirection(g.p1, Block.RIGHT);
	                        break;
                    	}
                    case W:
                    	if(event.getCode().equals(KeyCode.W) && g.p1.getDirection() != Block.DOWN){
	                        setDirection(g.p1, Block.UP);
	                        break;
                    	}
                    case S:
                    	if(event.getCode().equals(KeyCode.S) && g.p1.getDirection() != Block.UP){
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
	
	/**
	 * Sets the direction for player
	 * @param p1	function for player1
	 * @param num	integer representing player's direction
	 */
	public void setDirection(Player p1, int num){
        arr.add(num);
        ListIterator<Integer> itr = arr.listIterator(); 
        while(itr.hasNext()){
            p1.setDirection(itr.next());
            moved = true;
        }
    }
    
	/**
	 * Sets the direction for player
	 * @param p2	function for player2
	 * @param num	integer representing player's direction
	 */
    public void setDirection(Player2 p2, int num){
        arr2.add(num);
        ListIterator<Integer> itr2 = arr2.listIterator(); 
        while(itr2.hasNext()){
            p2.setDirection(itr2.next());
            moved = true;
        }
    }
}
