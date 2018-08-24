package ordenacoes;
public class SelectionSort {
	public int sort(int[] vetor) {
		int i, j, min, aux, counter = 0;
		for(i = 0; i < vetor.length; i++) { //controla a variável min
			min  = i;
			for(j = i + 1; j < vetor.length; j++) { //da posição min para frente quem é o menor?, faz a ordenação	
				counter = counter +1;
				if(vetor[j] < vetor[min]) {
					min = j;
				}
			}
			counter = counter +1;
			if(vetor[i] != vetor[min]) { 
				counter = counter +1;
				aux = vetor[i];
				vetor[i] = vetor[min];
				vetor[min] = aux;
			}
		}
		return counter;
		//System.out.println("Number of instructions: " + counter);
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
