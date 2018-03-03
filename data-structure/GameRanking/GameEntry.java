//public acess class
public class GameEntry {
	private String name;
	private int score;
	
	//constructor
	public GameEntry(String n, int s) { 
		//this.name = n; not needed because java got this situation without this, but not always.
		name = n;
		score = s;
	}
	
	//methods/class behavior
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getScore() {
		return name;
	}
	
	public void setScore(String score) {
		this.name = score;
	}
	
	public String toString() {
		return name + " . " + score;
	}
	
}
