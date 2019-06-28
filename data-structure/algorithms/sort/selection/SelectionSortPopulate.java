public class SelectionSortPopulate {
	public void crescent(int vetor[]) {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = i + 1;
			//System.out.println("Crescent - added value: " + vetor[i]);
		} 
	}
	public void decreasing(int vetor[]) {
		int counterDescreasing = 0;
		for (int i = vetor.length - 1; i >= 0; i--) {
			vetor[counterDescreasing++] = i;
			//System.out.println("Decreasing - added value: " + vetor[i]);
		}
	}
	public void random(int vetor[]) {
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = (int)(Math.random() * 100);	
			//System.out.println("Random - added value: " + vetor[i]);
		}		
	}
}
