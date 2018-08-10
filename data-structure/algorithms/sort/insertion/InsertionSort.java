package sort;
public class InsertionSort {
	public void sort(int[] vetor) {
		int i, j, pivo, counter = 0;
		for(i = 1; i < vetor.length; i++) { //controla o pivo e faz as trocas do menor para esquerda e maior para direita
			pivo = vetor[i];
			for(j = i - 1; j >= 0; j--) { //começo do pivo para os valores que tiver a esquerda, enquanto o 0 não for 0, caminhará até o início do vetor
				counter = counter + 1;
				if(pivo < vetor[j]) {
					vetor[j + 1] = vetor[j]; //deslocamento do pivo
				} else {
					break;
				}
			}
			vetor[j + 1] = pivo; //deslocamento
			counter = counter + 1;
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
