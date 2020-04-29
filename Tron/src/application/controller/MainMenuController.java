package application.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import application.Main;
import application.model.Player;
import application.model.Player2;
import application.model.ScoreTracker;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Java class to actually play the game. Creates the playable grid and the players.
 * Keeps track of player's score and sets the message to display on game over screen.
 * 
 * @author kxm210, gtp818, yng451 and uys943
 */
public class MainMenuController extends Application
{
	
	ScoreTracker scrT;
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
	
	/**
	 * Function to start the game and is passed in the Stage ps to build the application.
	 */
	public void start(Stage ps)
	{
		VBox root = new VBox(10);
		root.setPadding(new Insets(5));
			
		g = new Grid(width,height);
		g.addPlayer(new Player(initialLength,g), new Player2(initialLength,g));
			
		// Start button
		root.getChildren().add(g);
			
		AnimationTimer timer = new AnimationTimer()
		{
			/**
			 * Function to check which player won and add the correct message
			 * to the game over screen label.
			 * 
			 * @param now		current system time used to help with animating player movement
			 */
			public void handle(long now)
			{
				String status;
				stop();
				String player1 = scrT.getNamePlayer1();
				String player2 = scrT.getNamePlayer2();
					
				start();
				if(now - time > 1000000000 / 10)
				{
					g.update();
					time = now;
					moved = false;
						
					if(g.gameOverP1() && g.gameOverP2())
					{
						stop();
						try {
							if(scrT.getScorePlayer1() > 0 && scrT.getScorePlayer2() > 0)
							{
								scrT.p1Score--;
								scrT.p2Score--;
							}
							status =  "\tIt's a tie! \n\t-Scores- \n\t" +player1+ " - "+scrT.getScorePlayer1()+ "\n\t"+player2+" - "+scrT.getScorePlayer2();
							main.showGameOverView(ps,status,scrT);
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
						else if(g.gameOverP1())
						{
							stop();
							try
							{
								scrT.p2Score++;
								status = "\t" + player2+" Wins! \n\t-Scores- \n\t" +player1+ " - "+scrT.getScorePlayer1()+ "\n\t"+player2+" - "+scrT.getScorePlayer2();
								main.showGameOverView(ps,status,scrT);
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
						else if(g.gameOverP2())
						{
							stop();
							try
							{
								scrT.p1Score++;
								status =  "\t" + player1+ " Wins! \n\t-Scores- \n\t" +player1+ " - "+scrT.getScorePlayer1()+ "\n\t"+player2+" - "+scrT.getScorePlayer2();
								main.showGameOverView(ps,status,scrT);
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
				}
			};
		timer.start();
		Scene scene = new Scene(root);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			/**
			 * Function to control the player's movement by checking which key was pressed.
			 * 
			 * @param event			variable to see what key was pressed
			 */
			public void handle(KeyEvent event)
			{
				switch (event.getCode())
				{
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
	
	/**
	 * Function that sets the beginning direction for player 1.
	 * 
	 * @param p1	Player object for player 1
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
	 * Function that sets the beginning direction for player 2.
	 * 
	 * @param p2	Player object for player 2
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
    
    /**
     * Function to keep track of the current game's score.
     * 
     * @param scoreT	current score object of the game
     */
    public void passScoreTracker(ScoreTracker scoreT){
    	this.scrT = scoreT;
    }
}
