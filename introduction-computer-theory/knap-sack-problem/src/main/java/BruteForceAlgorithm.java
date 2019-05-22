public class BruteForceAlgorithm {
	
		
	public void execute(Knapsack knapsack) {
		int size = knapsack.size();
		int solution[] = new int[size];
		
		int maxValue = -1;
		int minWeight = 0;
		int s = 0;
		
		// Cria a string binaria somente com 1s
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < size;i++) {
			buffer.append(1);
		}
		// Converte para decimal e acrescenta 1
		int possibilities = Integer.parseInt(buffer.toString(), 2)+1;
		
		for(int i = 0; i < possibilities; i ++) {
			// Transforma o numero inteiro em binario.
			String binary = String.format("%1$" + size + "s", Integer.toBinaryString(i)).replace(' ', '0');
			System.out.print(binary);
			// Transforma a string em vetor de 0s e 1s
			for(int j = 0; j < size; j++) {
				solution[j] = Integer.parseInt(""+binary.charAt(j));
			}
			// Calcula o valor da solucao
			int r[] = knapsack.calcule(solution);
			if(r[0] > maxValue) {
				maxValue = r[0];
				s = i;
				minWeight = r[1];
			}else if(r[0] == maxValue && r[1] < minWeight) {
				maxValue = r[0];
				s = i;
				minWeight = r[1];
			}
			System.out.println(" : v = "+r[0]+" w ="+r[1]);
		}
		
		System.out.println("------------");
		System.out.println("Best");
		System.out.println(String.format("%1$" + size + "s", Integer.toBinaryString(s)).replace(' ', '0'));
		System.out.println("v = "+maxValue+" w = "+minWeight);
		
		
	}
	

}