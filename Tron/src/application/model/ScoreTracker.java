package application.model;
/***
 * 
 * @author uys943
 *
 */
public class ScoreTracker {

	private String name1;
	private String name2;
	public int p1Score;
	public int p2Score;
	/***
	 * 
	 * @param p1 constructor for both players scores
	 * @param p2
	 */
	public ScoreTracker(String p1, String p2){
		this.name1 = p1;
		this.name2 = p2;
	}
	/**
	 *  getter that returns player 1 name
	 * @return	player 1 name
	 */
	public String getNamePlayer1(){
		return name1;
	}
	/**
	 *  getter that returns player 2 name
	 * @return	player 2 name
	 */
	public String getNamePlayer2(){
		return name2;
	}
	/**
	 *  getter that returns player 1 score
	 * @return	player 1 score
	 */
	public int getScorePlayer1(){
		return p1Score;
	}
	/**
	 *  getter that returns player 2 score
	 * @return	player 2 score
	 */
	public int getScorePlayer2(){
		return p2Score;
	}
}

