package sort;
public class Main extends Population {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		/*Population population = new Population();
		MinMax minMax = new MinMax();
		for(int n = 1; n < 5; n++){
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
		 */
		int[] vetor = new int[]{12, 8, 9, 3, 1};
		mergeSort.merge(vetor, 1, 100);
		mergeSort.print(vetor);
	}
}
