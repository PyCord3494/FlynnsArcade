package application.model;

/**
 * This class is for keeping track of each player's name and score.
 * 
 * @author uys943
 */
public class ScoreTracker {

	private String name1;
	private String name2;
	public int p1Score;
	public int p2Score;
	
	/**
	 * Constructor for keeping track of player scores.
	 * 
	 * @param p1 		player object for player 1
	 * @param p2		player object for player 2
	 */
	public ScoreTracker(String p1, String p2){
		this.name1 = p1;
		this.name2 = p2;
	}
	
	/**
	 * Getter that returns player 1's name.
	 * 
	 * @return name1		player 1's name
	 */
	public String getNamePlayer1(){
		return name1;
	}
	
	/**
	 * Getter that returns player 2's name.
	 * @return name2		player 2's name
	 */
	public String getNamePlayer2(){
		return name2;
	}
	
	/**
	 * Getter that returns player 1's score.
	 * @return p1Score		player 1's score
	 */
	public int getScorePlayer1(){
		return p1Score;
	}
	
	/**
	 * Getter that returns player 2's score.
	 * @return p2Score		player 2's score
	 */
	public int getScorePlayer2(){
		return p2Score;
	}
}

