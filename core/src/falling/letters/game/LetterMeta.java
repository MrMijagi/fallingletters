package falling.letters.game;

public class LetterMeta {
	private char key;
	private long time;
	
	public LetterMeta(char key, long time) {
		this.key = key;
		this.time = time;
	}
	
	public char getChar() {return this.key;}
	public long getTime() {return this.time;}
}
