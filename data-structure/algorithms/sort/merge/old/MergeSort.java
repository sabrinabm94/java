package sort;
public class MergeSort {
	//verifica se os valores passados são válidos
    public void merge(int[] vetor, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            //Divide a parte esquerda do vetor
            merge(vetor, low, middle);
            //Divide a parte direita do vetor
            merge(vetor, middle + 1, high);
            //Une as duas partes
            mergeParts(vetor, low, middle, high);
        }
    }
    public void mergeParts(int[] vetor, int low, int middle, int high) {
    	int[] helper = new int[vetor.length];
		for (int i = low; i <= high; i++) {
        	helper[i] = vetor[i];
        }
        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
            	vetor[current] = helper[helperLeft];
            	helperLeft++;
            } else {
            	vetor[current] = helper[helperRight];
            	helperRight++;
            }
            current++;
        }
        /*
        while (helperLeft <= middle) {
        	vetor[current] = helper[helperLeft];
        	current++;
            helperLeft++;
        }
        */
        int remaining = middle - helperLeft;
        for(int i = 0; i <= remaining; i++) {
        	vetor[current+i] = helper[helperLeft + 1];
        }
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
