package estrutura;
public class Main extends Population {
	public static void main(String[] args) {
		Population population = new Population();
		Bubble bubble = new Bubble();

		for(int n = 1; n < 1000; n++){
			int[] crescent = new int [n];
			int[] decrescent = new int [n];
			int[] random = new int [n];

			population.crescent(crescent);
			population.decreasing(decrescent);
			population.random(random);

			int sortCrescente = bubble.sort(crescent);
			
			int sortDescrescente = bubble.sort(decrescent);

			int sortRadom = bubble.sort(random);
		
			System.out.println(n + ";" + sortCrescente + ";" + sortDescrescente + ";" + sortRadom);
			//1;0;0;0;0;0
		} 
	}
}