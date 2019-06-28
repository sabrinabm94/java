package ordenacoes;

public class MergeSort {
	public static int counter = 0;
	public void merge(int[] vetor, int first, int start, int end) {
		int[] vetorHelper = new int[start+end];
		int helper = 0, helperOne = 0, helper2 = 0;
		
		while((helperOne < start) && (helper2 < end)) {
			counter = counter + 1;
			if (vetor[first + helperOne] < vetor[first + start + helper2]) {
				vetorHelper[helper++] = vetor[first + helperOne++];
			}
			else {
				vetorHelper[helper++] = vetor[first + start + helper2++];
			}
		}

		while(helperOne < start) {
			counter = counter + 1;
			vetorHelper[helper++] = vetor[first + helperOne++];
		}

		while(helper2 < end) {
			counter = counter + 1;
			vetorHelper[helper++] = vetor[first + start +helper2++];
		}

		for(int i = 0; i < start+end; i++) {
			counter = counter + 1;
			vetor[first + i] = vetorHelper[i];
		}
	}

	public void mergeSort(int[] vetor, int first, int last) {
		int start, end;
		
		if (last > 1) {
			start = last/2;
			end = last - start;

			mergeSort(vetor, first, start); //m�todo recursivo
			mergeSort(vetor, first + start, end); //m�todo recursivo
			merge(vetor, first, start, end);
		}
	}

	public void print(int[] vetorOrdened) { //print dos vetores
		System.out.print("vetor ordened: ");
		for(int i = 0 ; i < vetorOrdened.length; i++) {
			System.out.print(vetorOrdened[i] + " ");
		}
		System.out.println("");
	}
}
