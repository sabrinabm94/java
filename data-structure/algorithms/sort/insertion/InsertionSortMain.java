public class InsertionSortMain extends InsertionSortPopulate {
	public static void main(String[] args) {
		InsertionSortPopulate population = new InsertionSortPopulate();
		ordenacoes.SelectionSort selectionSort = new ordenacoes.SelectionSort();

		for(int n = 1; n < 1000; n++) {
			int[] crescent = new int [n];
			int[] decrescent = new int [n];
			int[] random = new int [n];
	
			population.crescent(crescent);
			population.decreasing(decrescent);
			population.random(random);
			
			int crescentSort = selectionSort.sort(crescent);
			
			int descrescentSort = selectionSort.sort(decrescent);
			
			int randomSort = selectionSort.sort(random);
	
			System.out.println(n + ";" + crescentSort + ";" + descrescentSort + ";" + randomSort);
			//1;0;0;0;0;0
		}
	}
}
