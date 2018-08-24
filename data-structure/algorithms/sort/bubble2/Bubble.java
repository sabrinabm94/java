package ordenacoes;

public class Bubble {
	public int sort(int[] vetor) {
		int i, j, aux, counter = 0;
		boolean changed = true;
		int firstChange = -1;
		
		while(changed) {
			changed = false;
			i = firstChange + 1;
			
			while(i < vetor.length - 1) {
				counter = counter + 1;
				
				if(vetor[i] > vetor[i+1]) {
					counter = counter + 1;
					aux = vetor[i];
					vetor[i] = vetor[i+1];
					vetor[i+1] = aux;
					changed = true;
					
					if(!changed) {
						counter = counter + 1;
						firstChange = i;
					}
				}
				i++;
			}
		}
		//System.out.println("Number of instructions: " + counter);
		return counter;
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
