package ordenacoes;

public class Bubble {
	public void sort(int[] vetor) {
		int i, j, min, auxiliar, counter = 0;
		for(i = 0; i < vetor.length; i++) { 
			for(j = 0; j < vetor.length-1; j++) {
				if(vetor[j] > vetor[j + 1]) {
					auxiliar = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = auxiliar;
				}
			}
		}
		System.out.println("Number of instructions: " + counter);
	}
	public void print(int[] vetor) {
		int i = 0;
		System.out.println("");
		System.out.println("Starting print...");
		for(i = 0; i < vetor.length; i++) { 
			System.out.println("value " + vetor[i] +  " of position: " + i);
		}
		System.out.println("End");
		System.out.println("");
	}
}
