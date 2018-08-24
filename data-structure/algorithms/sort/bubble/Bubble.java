package ordenacoes;

public class Bubble {
	public int sort(int[] vetor) {
		int aux = 0, counter = 0;
		  for(int i = 0; i < vetor.length; i++){  
			  for(int j = i + 1;j < vetor.length; j++){
				  counter = counter + 1;
				  if(vetor[j] > vetor[i]) {
					  aux = vetor[i];
					  vetor[i] = vetor[j];
					  vetor[j] = aux;				  
				  }			  			  
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
