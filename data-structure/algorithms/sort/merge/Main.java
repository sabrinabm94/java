package sort;

public class Main extends Population {
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		
		int[] decrescent = {12, 8, 9, 3};
		int[] crescent = {3, 8, 9, 12};
		int[] random = {12, 3, 9, 8};

		mergeSort.mergeSort(decrescent, 0, decrescent.length);
		int worseCase = mergeSort.counter;
		mergeSort.print(decrescent);
		mergeSort.counter = 0;
		
		mergeSort.mergeSort(crescent, 0, crescent.length);
		int bestCase = mergeSort.counter;
		mergeSort.print(crescent);
		mergeSort.counter = 0;
		
		mergeSort.mergeSort(random, 0, random.length);
		int middleCase = mergeSort.counter;
		mergeSort.print(random);
		mergeSort.counter = 0;
		
		System.out.println(bestCase + ";" + worseCase + ";" + middleCase);
	}
}
