
public class GameRanking {
	private GameEntry[] Ranking; //array without limit
	
	//constructor
	public GameRanking() {
		Ranking = new GameEntry[10]; //set of 10 positions to array
		Ranking[0] = new GameEntry("Sabrina", 10);
	}
	
	public void list() {
		for (int i = 0; i < Ranking.length; i++) {
			Ranking[i].toString();
		}
	}
	
	public static void main(String[] args) {
		new GameRanking().list();
	}

}
