package mum.asd.mediator;

public class Player implements IPlayer {

	private String name;
	private boolean isWin;
	private boolean youTurn;
	private int score;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isWin() {
		return isWin;
	}
	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
	public boolean isYouTurn() {
		return youTurn;
	}
	public void setYouTurn(boolean youTurn) {
		this.youTurn = youTurn;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
