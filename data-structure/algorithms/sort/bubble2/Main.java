package ordenacoes;

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
			
			//minmax1c
			int op1c = minMax.minMaxWorseCase(crescent);
			
			//minmax2c
			int op2c = minMax.minMaxMediumCase(crescent);
			
			//minmax2d
			int op2d = minMax.minMaxMediumCase(decrescent);
			
			//minmax2r
			int op2r = minMax.minMaxMediumCase(random);
			
			//minmax3c
			int op3 = 0;
			
			//even - odd error tratament
			if(n % 2 == 0) {
				op3 = minMax.minMaxBetterCaseEven(crescent);
			} else {
				op3 = minMax.minMaxBetterCaseOdd(crescent);
			}

			//System.out.println(n + ";" + op1 + ";" + op2c + ";" + op2d + ";" + op2a + ";" + op3);
			//1;0;0;0;0;0
		}

		bubble.sort(vetor);
		bubble.print(vetor);
	}
}