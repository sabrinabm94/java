public class BubbleMain extends InsertionSortPopulate {
	public static void main(String[] args) {
		InsertionSortPopulate population = new InsertionSortPopulate();
		ordenacoes.BubbleSort2 bubbleSort2 = new ordenacoes.BubbleSort2();

		for(int n = 1; n < 1000; n++){
			int[] crescent = new int [n];
			int[] decrescent = new int [n];
			int[] random = new int [n];

			population.crescent(crescent);
			population.decreasing(decrescent);
			population.random(random);
			
			int crescentSort = bubbleSort2.sort(crescent);
			int descrescentSort = bubbleSort2.sort(decrescent);
			int randomSort = bubbleSort2.sort(random);

			System.out.println(n + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
			//1;0;0;0;0;0
		}
	}
}