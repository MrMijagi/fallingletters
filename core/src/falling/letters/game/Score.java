package falling.letters.game;

public class Score {
	private String username;
	private int misses;
	private int hits;
	private float sumOfAccuracy;
	
	public Score(String username) {
		this.username = username;
		this.misses = 0;
		this.hits = 0;
		this.sumOfAccuracy = 0;
	}
	
	public String getUsername() {return this.username;}
	public int getMisses() {return this.misses;}
	public int getHits() {return this.hits;}
	public float getSumOfAccuracy() {return this.sumOfAccuracy;}
	
	public void addMiss() {this.misses++;}
	public void addHit() {this.hits++;}
	public void addAccuracy(float accuracy) {
		if (accuracy > 1 || accuracy <= 0) {
			throw new IllegalArgumentException("Argument needs be in range (0, 1]");
		}
		this.sumOfAccuracy += accuracy;
	}
	
	public float getAverageAccuracy() {
		return this.sumOfAccuracy / (this.hits + this.misses);
	}
	public float getHitRate() {
		return this.hits / (this.hits + this.misses);
	}
}
