package exercicios;

class Exercicios<T> {

	public static void main(String[] args) {
		Exercicios<Integer> teste = new Exercicios<>();

		//============ TESTANDO AS SOLUÇÕES ============

		FilaDinamica<Integer> filaA = new FilaDinamica<>();
		FilaDinamica<Integer> filaB = new FilaDinamica<>();

		filaA.add(1);
		filaA.add(2);
		filaA.add(3);

		filaB.add(4);
		filaB.add(5);
		filaB.add(6);
		filaB.add(7);

		FilaDinamica<Integer> filaParaModa = new FilaDinamica<>();

		filaParaModa.add(1);
		filaParaModa.add(1);
		filaParaModa.add(1);
		filaParaModa.add(2);
		filaParaModa.add(3);
		filaParaModa.add(2);
		filaParaModa.add(3);
		filaParaModa.add(2);
		filaParaModa.add(3);
		filaParaModa.add(3);
		filaParaModa.add(3);

		//========== TESTE EXERCÍCIO 1 ==========
		System.out.print("Concatenado: ");
		FilaDinamica<Integer> filaConcatenada = teste.concatenaDuasFilas(filaA, filaB);
		filaConcatenada.list(e -> System.out.print(e + " "));
		System.out.println();

		//========== TESTE EXERCÍCIO 2 ==========
		System.out.println("Maior valor da fila: " + teste.retornaMaiorValor(filaConcatenada));

		//========== TESTE EXERCÍCIO 3 ==========
		System.out.println("Contém 5: " + teste.temEsteValor(filaConcatenada, 5));
		System.out.println("Contém 999: " + teste.temEsteValor(filaConcatenada, 999));

		//========== TESTE EXERCÍCIO 4 ==========
		System.out.println("Média:   " + teste.media(filaConcatenada));
		System.out.println("Mediana: " + teste.mediana(filaConcatenada));
		System.out.println("Moda: " + teste.moda(filaParaModa));

		//========== TESTE EXERCÍCIO 5 ==========
		// ainda não fiz :/ 
	}

	//==============================================================================
	//                    EXERCÍCIOS ENUNCIADOS e MÉTODOS
	//==============================================================================
	
	//Implemente um método que receba duas listas como parâmetro e produza uma ...
	//... terceira lista, concatenando os elementos da primeira e segunda lista.
	FilaDinamica<T> concatenaDuasFilas(FilaDinamica<T> filaA, FilaDinamica<T> filaB) {
		FilaDinamica<T> filaConcatenada = new FilaDinamica<>();
		
		while(!filaA.isEmpty()) {
			filaConcatenada.add(filaA.remove());
		}
		
		while(!filaB.isEmpty()) {
			filaConcatenada.add(filaB.remove());
		}
		
		return filaConcatenada;
	}
	
	//Escreva um método que receba uma lista encadeada de inteiros e retorne o ...
	//... maior valor encontrado na lista.
	Integer retornaMaiorValor(FilaDinamica<Integer> fila) {
		return fila.maiorValor();
	}
	
	//Escreva um método que percorra uma lista encadeada recebida como parâmetro e verifique se existe um determinado valor na lista, 
	//também recebido como parâmetro. Se o valor recebido como parâmetro for encontrado na lista, o método deve retornar verdadeiro, 
	//do contrário deve ser retornado falso.
	boolean temEsteValor(FilaDinamica<Integer> fila, int valorProcurando) {
		return fila.temEsteValor(valorProcurando);
	}
	
	//Escreva três métodos que percorram uma lista encadeada de inteiros recebida como parâmetro 
	//e calculem a média, mediana e a moda dos valores contidos nesta lista.

	//média
	double media(FilaDinamica<Integer> fila) {
		return fila.media(); 
	}

	//mediana
	int mediana(FilaDinamica<Integer> fila) {
		return fila.mediana(); 
	}

	//moda
	int moda(FilaDinamica<Integer> fila) {
		return fila.moda(); 
	}
}