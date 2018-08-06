package sort;
public class Main extends Population {
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int[] vetor = new int[]{12, 8, 9, 3};
		selectionSort.sort(vetor);
		selectionSort.print(vetor);
	}
}
