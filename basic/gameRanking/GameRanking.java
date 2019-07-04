package gameRanking;

public class GameRanking {
	private GameEntry[] Ranking; //array without limit
	
	public GameRanking() {
		Ranking = new GameEntry[10]; //set 10 positions in array
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
