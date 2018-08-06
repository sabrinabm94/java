package ordenacoes;

public class Main extends Population {
	public static void main(String[] args) {
		Bubble bubble = new Bubble();
		int[] vetor = new int[]{12, 8, 9, 3};
		bubble.sort(vetor);
		bubble.print(vetor);
	}
}