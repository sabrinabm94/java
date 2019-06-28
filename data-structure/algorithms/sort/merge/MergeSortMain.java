import ordenacoes.MergeSort;

public class MergeSortMain extends InsertionSortPopulate {
	public static void main(String[] args) {
		InsertionSortPopulate insertionSortPopulate = new InsertionSortPopulate();
		ordenacoes.MergeSort mergeSort = new MergeSort();

		for(int n = 1; n < 1000; n++){
			int[] crescent = new int [n];
			int[] decrescent = new int [n];
			int[] random = new int [n];

			insertionSortPopulate.crescent(crescent);
			insertionSortPopulate.decreasing(decrescent);
			insertionSortPopulate.random(random);

			mergeSort.mergeSort(decrescent, 0, decrescent.length);
			int worseCase = mergeSort.counter;
			mergeSort.counter = 0;
			
			mergeSort.mergeSort(crescent, 0, crescent.length);
			int bestCase = mergeSort.counter;
			mergeSort.counter = 0;
			
			mergeSort.mergeSort(random, 0, random.length);
			int middleCase = mergeSort.counter;
			mergeSort.counter = 0;

			System.out.println(n + ";" + worseCase + ";" + bestCase + ";" + middleCase);
			//1;0;0;0;0;0
		}
	}
}