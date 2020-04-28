package application;

public class ScoreTracker {

	private String name1;
	private String name2;
	int p1Score;
	int p2Score;
	
	public ScoreTracker(String p1, String p2){
		this.name1 = p1;
		this.name2 = p2;
	}
	
	public String getNamePlayer1(){
		return name1;
	}
	
	public String getNamePlayer2(){
		return name2;
	}
	
	public int getScorePlayer1(){
		return p1Score;
	}
	
	public int getScorePlayer2(){
		return p2Score;
	}
}

