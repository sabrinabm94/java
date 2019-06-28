import java.util.Arrays;
import java.util.Random;

public class Knapsack {
	
	private int[] weight;
	private int[] value;
	private int weightCapacity;
	
	public Knapsack(int size) {
		weight = new int[size];
		value = new int[size];
		Random random = new Random();
		for(int i = 0; i < size; i ++) {
			weight[i] = random.nextInt(100);
			value[i] = random.nextInt(100);
			weightCapacity += weight[i];
		}

		System.out.println("Weight: " + Arrays.toString(weight));
		System.out.println("Value: " + Arrays.toString(value));

		weightCapacity = weightCapacity / 2;
	}
	
	public int size() {
		return value.length;
	}
	
	
	public int[] calcule(int[] solution) {
		int v = 0;
		int w = 0;

		//logica paga pegar somente os maiores
		int[] solutionCopy = value.clone();

		for(int i = 0; i < solution.length; i++) {
			int max = 0;
			int indice = 0;
			for (int y = 0; y < solutionCopy.length; y++) {//percorre o vetor buscando pelos maiores
				if (solutionCopy[y] > max) { //atualiza os valores para os atuais maiores
					max = solutionCopy[y];
					indice = y;
				}

				if(y != 0) {
					//troca o valor máximo atual por 0
					solutionCopy[indice] = 0;
				}
			}

			if(max != 0) {
				v = v + solution[indice] * value[indice];
				w = w + solution[indice] * weight[indice];
			}
		}
		if(w > weightCapacity) {
			v = 0;
		}
		return new int[]{v,w};
	}

}
