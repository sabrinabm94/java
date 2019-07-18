package queue.others;

class Exercicios<T> {

	public static void main(String[] args) {
		Exercicios<Integer> teste = new Exercicios<>();

		//============ TESTANDO AS SOLUÇÕES ============

		DinamicRow<Integer> rowA = new DinamicRow<>();
		DinamicRow<Integer> rowB = new DinamicRow<>();

		rowA.add(1);
		rowA.add(2);
		rowA.add(3);

		rowB.add(4);
		rowB.add(5);
		rowB.add(6);
		rowB.add(7);

		DinamicRow<Integer> rowPerFashion = new DinamicRow<>();

		rowPerFashion.add(1);
		rowPerFashion.add(1);
		rowPerFashion.add(1);
		rowPerFashion.add(2);
		rowPerFashion.add(3);
		rowPerFashion.add(2);
		rowPerFashion.add(3);
		rowPerFashion.add(2);
		rowPerFashion.add(3);
		rowPerFashion.add(3);
		rowPerFashion.add(3);

		//========== TESTE EXERCÍCIO 5 ==========
		// ainda não fiz :/ 
	}
	
	//Escreva um método que receba uma lista encadeada de inteiros e retorne o ...
	//... maior valor encontrado na lista.
	Integer retornaMaiorValor(DinamicRow<Integer> fila) {
		return fila.maiorValor();
	}
	
	//Escreva um método que percorra uma lista encadeada recebida como parâmetro e verifique se existe um determinado valor na lista, 
	//também recebido como parâmetro. Se o valor recebido como parâmetro for encontrado na lista, o método deve retornar verdadeiro, 
	//do contrário deve ser retornado falso.
	boolean temEsteValor(DinamicRow<Integer> fila, int valorProcurando) {
		return fila.temEsteValor(valorProcurando);
	}
	
	//Escreva três métodos que percorram uma lista encadeada de inteiros recebida como parâmetro 
	//e calculem a média, mediana e a moda dos valores contidos nesta lista.

	//média
	double media(DinamicRow<Integer> fila) {
		return fila.media(); 
	}

	//mediana
	int mediana(DinamicRow<Integer> fila) {
		return fila.mediana(); 
	}

	//moda
	int moda(DinamicRow<Integer> fila) {
		return fila.moda(); 
	}
}